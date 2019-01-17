
/**   
 * Title：DemoController.java 　<br/>
 * Package：com.bosssoft.itfinance.citizen.wallet.controller 　<br/>
 * Description：<br/>
 * Data：2018年8月16日 上午11:23:39<br/>
 * @author lean
 * @copyright  Corporation 2018    
 * @version v1.0 
 */
package com.kowloon.lean.consumer.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * ClassName：com.kowloon.lean.consumer.client.controller.TestNormalController　　<br/>
 * Description：<br/>
 * Date：2019年1月11日 下午5:06:52<br/>
 * @author lean
 * @version 1.0
 */
@RestController
@Slf4j
public class TestNormalController {
	
	@Autowired
	@Qualifier("normalRestTemplate")
	RestTemplate normalRestTemplate;
	
	@GetMapping("/sayHelloByIp")
    public String sayHelloByIp() {
        String url = "http://172.18.160.222:18997/sayHello";
        log.info("normalRestTemplage...url地址为：{}", url);
		return normalRestTemplate.getForObject(url, String.class);
    }
}
