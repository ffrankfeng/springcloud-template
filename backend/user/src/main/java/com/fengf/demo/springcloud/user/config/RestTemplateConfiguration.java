package com.fengf.demo.springcloud.user.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory  = new SimpleClientHttpRequestFactory ();
        simpleClientHttpRequestFactory.setConnectTimeout(1000);
        simpleClientHttpRequestFactory.setReadTimeout(1000);
        return new RestTemplate(simpleClientHttpRequestFactory);
    }
}