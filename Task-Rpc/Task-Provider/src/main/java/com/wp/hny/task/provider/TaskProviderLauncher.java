package com.wp.hny.task.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.wp.hny.base.BaseProviderLauncher;
/**
 * 
 * @author swiftwen
 * @date 2018年12月3日 下午7:34:36
 */
@ComponentScan({"com.wp.hny.task.provider"})
@SpringBootApplication
public class TaskProviderLauncher extends BaseProviderLauncher{
  public static void main(String[] args) {
	  System.out.println("Hello, JavaPoet!");
		SpringApplication.run(TaskProviderLauncher.class, args);
  }
}
