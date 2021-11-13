package com.prueba.aplicacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.prueba.aplicacion")
public class WebAppConfig{

    public static void main(String[] args) throws Exception{
        SpringApplication.run(WebAppConfig.class, args);
    }
}