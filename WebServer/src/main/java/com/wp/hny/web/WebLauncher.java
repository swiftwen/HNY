package com.wp.hny.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.wp.hny.web")
@SpringBootApplication
public class WebLauncher{
  public static void main(String[] args) {
	  System.out.println("Hello, JavaPoet!");
	  SpringApplication.run(WebLauncher.class, args);
  }
}
