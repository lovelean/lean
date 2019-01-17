package com.kowloon.lean.consumer.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * ClassName：com.kowloon.lean.consumer.client.ConsumerRibbonClientApplication　　<br/>
 * Description：<br/>
 * Date：2019年1月11日 下午4:37:21<br/>
 * @author lean
 * @version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class ConsumerRibbonClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerRibbonClientApplication.class, args);
		log.info("consumer-ribbon-client启动成功!");
	}

	@Bean
	//加入负载均衡能力，同时可根据applicationName 来访问服务。如http://EUREKA-CLIENT/add
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	@Bean("normalRestTemplate")
	public RestTemplate normalRestTemplate() {
	    return new RestTemplate();
	}
}
