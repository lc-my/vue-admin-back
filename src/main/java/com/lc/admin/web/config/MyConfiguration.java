package com.lc.admin.web.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @auth liuchong
 * @data 2019-07-03 18:11
 **/
@Configuration
public class MyConfiguration {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }

            @Override
            public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
                FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
                converters.add(0, converter);
            }
        };
    }
}
