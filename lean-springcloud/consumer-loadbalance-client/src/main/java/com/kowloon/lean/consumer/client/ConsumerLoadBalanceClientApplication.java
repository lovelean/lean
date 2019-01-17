package com.kowloon.lean.consumer.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * ClassName：com.kowloon.lean.consumer.client.ConsumerLoadBalanceClientApplication　　<br/>
 * Description：<br/>
 * Date：2019年1月11日 下午3:21:52<br/>
 * @author lean
 * @version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class ConsumerLoadBalanceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerLoadBalanceClientApplication.class, args);
		log.info("consumer-loadbalance-client启动成功!");
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
