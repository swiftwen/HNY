package com.wp.hny.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({
        "classpath:dubbo/*.xml"
})
public class WebServerDubboConfig {
}
