package com.lean.project.springboot.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;


/**
 * 
 * ClassName：com.lean.project.springboot.consumer.BootConsumerApplication　　<br/>
 * Description：<br/>
 * Date：2018年9月29日 下午5:30:55<br/>
 * @author lean
 * @version 1.0
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class BootConsumerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BootConsumerApplication.class, args);
//		new SpringApplicationBuilder(BootApplication.class)
//        .web(WebApplicationType.SERVLET) // 非 Web 应用
//        .run(args);
	}
}
