package com.wp.hny.common.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.wp.hny.common.provider")
@SpringBootApplication
public class CommonProviderLauncher{
  public static void main(String[] args) {
	  System.out.println("Hello, JavaPoet!");
		SpringApplication.run(CommonProviderLauncher.class, args);
  }
}
