package com.kowloon.lean.consumer.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * ClassName：com.kowloon.lean.consumer.client.ConsumerFeignClientApplication　　<br/>
 * Description：<br/>
 * Date：2019年1月15日 上午9:37:05<br/>
 * @author lean
 * @version 1.0
 */
@SpringBootApplication
@EnableFeignClients
@Slf4j
public class ConsumerFeignClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerFeignClientApplication.class, args);
		log.info("consumer-feign-client启动成功!");
	}
}
