package com.weiye;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebLauncher{
  public static void main(String[] args) {
	  System.out.println("Hello, JavaPoet!");
	  SpringApplication.run(WebLauncher.class, args);
  }
}
