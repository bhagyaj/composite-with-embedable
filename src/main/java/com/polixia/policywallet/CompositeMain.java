package com.polixia.policywallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@ComponentScan(basePackages = "com.polixia.policywallet")
@EnableResourceServer
public class CompositeMain {
    public static void main(String[] args) {
        SpringApplication.run(CompositeMain.class, args);
    }
}
