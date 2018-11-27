package com.wp.hny.repo.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.wp.hny.repo.provider")
@SpringBootApplication
public class RepoBaseProviderLauncher{
  public static void main(String[] args) {
	  System.out.println("Hello, JavaPoet!");
		SpringApplication.run(RepoBaseProviderLauncher.class, args);
  }
}
