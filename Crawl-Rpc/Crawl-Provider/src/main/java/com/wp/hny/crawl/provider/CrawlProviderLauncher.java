package com.wp.hny.crawl.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.wp.hny.crawl.provider")
@SpringBootApplication
public class CrawlProviderLauncher{
  public static void main(String[] args) {
	  System.out.println("Hello, JavaPoet!");
		SpringApplication.run(CrawlProviderLauncher.class, args);
  }
}
