package com.kowloon.lean.consumer.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * ClassName：com.kowloon.lean.consumer.client.ConsumerClientApplication　　<br/>
 * Description：<br/>
 * Date：2019年1月9日 下午7:17:26<br/>
 * @author lean
 * @version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerClientApplication.class, args);
	}

	//加入负载均衡能力
	//同时可根据applicationName 来访问服务
	//如http://EUREKA-CLIENT/add
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
