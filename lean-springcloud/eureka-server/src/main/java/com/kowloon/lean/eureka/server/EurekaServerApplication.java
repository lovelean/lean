package com.kowloon.lean.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 
 * ClassName：com.kowloon.lean.eureka.server.EurekaServerApplication　　<br/>
 * Description：<br/>
 * Date：2018年12月26日 下午4:50:28<br/>
 * @author lean
 * @version 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}
}
