package com.kowloon.lean.eureka.server.two;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 
 * ClassName：com.kowloon.lean.eureka.server.two.EurekaServerTwoApplication　　<br/>
 * Description：eureka服务启动类<br/>
 * Date：2019年1月8日 下午4:22:14<br/>
 * @author lean
 * @version 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerTwoApplication.class, args);
	}
	
	/**
	 * 
	 * ClassName：com.kowloon.lean.eureka.server.two.WebSecurityConfig　　<br/>
	 * Description：忽略此路径下的CSRF令牌<br/>
	 * Date：2019年1月10日 上午9:39:39<br/>
	 * @author lean
	 * @version 1.0
	 */
    @EnableWebSecurity
    static class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().ignoringAntMatchers("/eureka/**");
            super.configure(http);
        }
    } 
}