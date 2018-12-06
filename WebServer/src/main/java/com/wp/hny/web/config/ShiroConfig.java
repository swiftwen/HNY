package com.wp.hny.web.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

/**
 * Shiro配置Bean
 * @author swiftwen
 * @date 2018年12月5日 下午3:18:58
 */
@Configuration 
public class ShiroConfig {
		
 
	@Bean
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager){
		System.out.println("ShiroConfiguration.shirFilter()");
		ShiroFilterFactoryBean shiroFilterFactoryBean  = new ShiroFilterFactoryBean();
		
		 // 必须设置 SecurityManager  
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		
		//拦截器.
		Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
		
		//配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
		filterChainDefinitionMap.put("/logout", "logout");
		filterChainDefinitionMap.put("/getGifCode", "anon");
		filterChainDefinitionMap.put("/ajaxLogin", "anon");
		filterChainDefinitionMap.put("/assets/**", "anon");
		filterChainDefinitionMap.put("/css/**", "anon");
		filterChainDefinitionMap.put("/images/**", "anon");
		filterChainDefinitionMap.put("/img/**", "anon");
		filterChainDefinitionMap.put("/script/**", "anon");
		
		
		filterChainDefinitionMap.put("/", "user");
		filterChainDefinitionMap.put("/index", "user");
		
		filterChainDefinitionMap.put("/**", "authc");
		
		// 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/warning");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}
//异常统一处理
	/*@Bean
	public HandlerExceptionResolver solver(){
		HandlerExceptionResolver handlerExceptionResolver=new MyExceptionResolver();
		return handlerExceptionResolver;
	}*/
	/**
     * cookie对象;
     * @return
     */
    @Bean
    public SimpleCookie rememberMeCookie(){
       System.out.println("ShiroConfiguration.rememberMeCookie()");
       //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
       SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
       //<!-- 记住我cookie生效时间30天 ,单位秒;-->
       simpleCookie.setMaxAge(259200);
       return simpleCookie;
    }
   
    /**
     * cookie管理对象;
     * @return
     */
    @Bean
    public CookieRememberMeManager rememberMeManager(SimpleCookie simpleCookie){
       System.out.println("ShiroConfiguration.rememberMeManager()");
       CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
       //cookieRememberMeManager.setCookie(rememberMeCookie());
       cookieRememberMeManager.setCookie(simpleCookie);
       return cookieRememberMeManager;
    }
	@Bean
	public SecurityManager securityManager(CookieRememberMeManager cookieRememberMeManager){
		DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
		//设置realm.
		securityManager.setRealm(myShiroRealm());
		
		//注入缓存管理器;
		securityManager.setCacheManager(ehCacheManager());//这个如果执行多次，也是同样的一个对象;
		securityManager.setRememberMeManager(cookieRememberMeManager);
		return securityManager;
	}
	
	
	/**
	 * 身份认证realm;
	 * (这个需要自己写，账号密码校验；权限等)
	 * @return
	 */
	@Bean
	public MyShiroRealm myShiroRealm(){
		MyShiroRealm myShiroRealm = new MyShiroRealm();
		myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());;
		return myShiroRealm;
	}
	
	/**
	 * 凭证匹配器
	 * （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
	 *  所以我们需要修改下doGetAuthenticationInfo中的代码;
	 * ）
	 * @return
	 */
	@Bean
	public HashedCredentialsMatcher hashedCredentialsMatcher(){
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
		hashedCredentialsMatcher.setHashIterations(1);//散列的次数，比如散列两次，相当于 md5(md5(""));
		
		return hashedCredentialsMatcher;
	}
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }
    @Bean
    @DependsOn({"lifecycleBeanPostProcessor"})
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }
	
	/**
	 *  开启shiro aop注解支持.
	 *  使用代理方式;所以需要开启代码支持;
	 * @param securityManager
	 * @return
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}
    /**
     * 添加ShiroDialect 为了在thymeleaf里使用shiro的标签的bean
     * @return
     */
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }
 
	
	/**
	 * shiro缓存管理器;
	 * 需要注入对应的其它的实体类中：
	 * 1、安全管理器：securityManager
	 * 可见securityManager是整个shiro的核心；
	 * @return
	 */
	@Bean
	public EhCacheManager ehCacheManager(){
		System.out.println("ShiroConfiguration.getEhCacheManager()");
		EhCacheManager cacheManager = new EhCacheManager();
		cacheManager.setCacheManagerConfigFile("classpath:ehcache.xml");
		return cacheManager;
	}
 
	
}

