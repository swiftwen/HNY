package com.weiye.workflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ComponentScan("com.weiye")
@SpringBootApplication
public class WebLauncher{
  public static void main(String[] args) {
	  System.out.println("Hello, JavaPoet!");
	  SpringApplication.run(WebLauncher.class, args);
  }
}
