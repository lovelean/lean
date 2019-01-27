package com.lean.project.springboot.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;


/**
 * 
 * ClassName：com.lean.project.springboot.provider.BootMonitorApplication　　<br/>
 * Description：<br/>
 * Date：2019年1月25日 下午4:17:41<br/>
 * @author lean
 * @version 1.0
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class BootMonitorApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BootMonitorApplication.class, args);
//		new SpringApplicationBuilder(BootApplication.class)
//        .web(WebApplicationType.SERVLET) // 非 Web 应用
//        .run(args);
	}
}
