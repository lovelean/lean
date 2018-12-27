package com.kowloon.lean.provider.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 
 * ClassName：com.kowloon.lean.provider.server.ProviderServerApplication　　<br/>
 * Description：<br/>
 * Date：2018年12月27日 上午10:05:17<br/>
 * @author lean
 * @version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class ProviderServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderServerApplication.class, args);
	}
}
