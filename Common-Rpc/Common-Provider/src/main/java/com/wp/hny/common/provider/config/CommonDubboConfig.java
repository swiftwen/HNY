package com.wp.hny.common.provider.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath:dubbo/*.xml"})
public class CommonDubboConfig {
	
}
