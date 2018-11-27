package com.wp.hny.account.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
/**
 * 
 * @author swiftwen
 * @date 2018年11月27日 下午3:19:18
 */
@ComponentScan({"com.wp.hny.account.provider","com.wp.hny.repo.provider"})
@SpringBootApplication
public class AccountProviderLauncher{
  public static void main(String[] args) {
	  System.out.println("Hello, JavaPoet!");
		SpringApplication.run(AccountProviderLauncher.class, args);
  }
}
