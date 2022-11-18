package com.librerias.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
public class WebConfig {
	
	public void addResourceHandles(ResourceHandlerRegistry reg){
        reg.addResourceHandler("/logos/**").addResourceLocations("c:/empleosWeb/src/main/resources/static/images/");
    }

}
