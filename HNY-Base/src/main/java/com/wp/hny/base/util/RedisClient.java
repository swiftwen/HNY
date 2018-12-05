package com.wp.hny.base.util;

import java.nio.charset.Charset;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

/**
 * 
 * @author swiftwen
 * @date 2018年12月5日 上午10:16:24
 */
@Component
public class RedisClient {
	
    @Resource
	RedisTemplate<String, String> cache;

	private static final String INC_KEY = "inc";

	public static final int EXPIRED = 60 * 5;


	protected void addSerializer() {
        cache.setKeySerializer(new StringRedisSerializer());
        cache.setValueSerializer(new StringRedisSerializer());
    }

    public void set(String key, String value, long expired) {
        addSerializer();
        cache.opsForValue().set(key, value, expired, TimeUnit.SECONDS);
    }

    public void set(String key,String value){
        addSerializer();
        cache.opsForValue().set( key ,value);
    }

	public String get(String key) {
        addSerializer();
		return cache.opsForValue().get(key);
    }

	public GeoOperations opsForGeo() {
		return cache.opsForGeo();
	}

	public RedisTemplate<String, String> getRedisTemplate() {
		return cache;
	}

	public ZSetOperations opsForZSet() {
		return cache.opsForZSet();
	}

    //实现有超时的计数
    public Long incAtExpired(String key, long expired) {
        addSerializer();

        if (get(key) == null) {//超时了 则重新计数
            cache.delete(INC_KEY + key);
        }
        long count = cache.opsForValue().increment(INC_KEY + key, 1L);

        set(key, count + "", expired);
        return count;
    }

    public void delete(String key) {
        cache.delete(key);
    }

	/** 加锁标志 **/
	public final static String LOCKED = "TRUE";
	/** 锁的超时时间（秒），过期删除 **/
	public final static int EXPIRE = 60;
	/** 随机数 **/
	public final static Random random = new Random();

	/**
	 * 加锁 保证原子性
	 * 
	 * @param operateLogic 处理逻辑
	 * @param lockCacheKey 锁的cache key
	 * @param timeOut 毫秒数 获取锁的超时时间
	 * @return
	 */
	public <T> T executeSynchOperate(MainOperator<T> operator, String lockCacheKey, long milliTimeout)
					throws Exception {
		final byte[] byteKey = lockCacheKey.getBytes(Charset.defaultCharset());
		final byte[] byteValue = LOCKED.getBytes(Charset.defaultCharset());

		boolean locked = false;
		long startNaros = System.nanoTime();
		long nanoTimeOut = milliTimeout * 1000000L;
		T resultObj = null;
		RedisConnection connection = null;
		try {
			final boolean notWait = milliTimeout <= 0;// 不等待，若获取不到锁，直接返回

			while (notWait || System.nanoTime() - startNaros < nanoTimeOut) {
				if (null == connection) {
					connection = cache.getConnectionFactory().getConnection();
				}
				if (connection.setNX(byteKey, byteValue)) {
					connection.expire(byteKey, EXPIRE);
					locked = true;
					break;
				}
				if (notWait) {
					break;
				}
				Thread.sleep(10, random.nextInt(500));
			}
			resultObj = operator.executeInvokeLogic(locked);
		} finally {
			// 如果当前线程拥有锁，则释放锁
			if (locked) {
				connection.del(byteKey);
			} else {
				if (null != connection) {
					// 没有过期时间，则ttl 返回-1
					if (connection.ttl(byteKey).intValue() == -1) {
						connection.expire(byteKey, EXPIRE);
					}
				}
			}
			// 关闭 redis 连接
			if (null != connection) {
				connection.close();
			}
		}
		return resultObj;
	}

	/**
	 * 操作本身实现的逻辑
	 * 
	 * @param <T>
	 */
	public abstract interface MainOperator<T> {
		public abstract T executeInvokeLogic(boolean locked) throws Exception;
	}
}
