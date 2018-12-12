package com.wp.hny.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.UUID;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.wp.hny.annotation.SystemControllerLog;


/**
    *   控制器层切面日志打印
 * @author liweiye
 * 2018年12月12日
 */
@Aspect
@Component
public class ControllerLogAspect {

	private static final Logger logger = LoggerFactory.getLogger(ControllerLogAspect.class);

	private ThreadLocal<Long> time = new ThreadLocal<Long>();
	private ThreadLocal<String> tag = new ThreadLocal<String>();
	
	@Around("@annotation(com.wp.hny.annotation.SystemControllerLog)")
	public Object aroundExec(ProceedingJoinPoint joinPoint) throws Throwable {
		time.set(System.currentTimeMillis());
		tag.set(UUID.randomUUID().toString().toUpperCase().replaceAll("-", ""));
		MethodSignature ms = (MethodSignature) joinPoint.getSignature();
		Method method = ms.getMethod();
		
		logger.info("START[ {} ] [{}]", joinPoint.getSignature(), tag.get());
		logger.info("ENTRY[ {} ] [{}]", method.getAnnotation(SystemControllerLog.class).value(), tag.get());
		Object[] os = joinPoint.getArgs();
		int[] exclude = method.getAnnotation(SystemControllerLog.class).exclude();
		Arrays.sort(exclude);
		for (int i = 0; i < os.length; i++) {
			if (Arrays.binarySearch(exclude, i) < 0) {
				logger.info("|=> 参数 [{}]:\t {}", i, os[i]);
			}
		}
		Object res = joinPoint.proceed();
		logger.info("END[ {} ] 运行消耗 {} ms, [{}]", res, (System.currentTimeMillis() - time.get()), tag.get());
		return res;
	}
}
