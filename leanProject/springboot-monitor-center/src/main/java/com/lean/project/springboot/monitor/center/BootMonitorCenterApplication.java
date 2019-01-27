package com.lean.project.springboot.monitor.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;


/**
 * 
 * ClassName：com.lean.project.springboot.monitor.center.BootMonitorCenterApplication　　<br/>
 * Description：<br/>
 * Date：2019年1月27日 下午3:57:08<br/>
 * @author lean
 * @version 1.0
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class BootMonitorCenterApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BootMonitorCenterApplication.class, args);
//		new SpringApplicationBuilder(BootApplication.class)
//        .web(WebApplicationType.SERVLET) // 非 Web 应用
//        .run(args);
	}
}
