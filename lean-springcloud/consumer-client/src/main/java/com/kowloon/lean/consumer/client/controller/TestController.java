
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * ClassName：com.kowloon.lean.consumer.client.controller.TestController　　<br/>
 * Description：<br/>
 * Date：2019年1月9日 下午7:17:57<br/>
 * @author lean
 * @version 1.0
 */
//@RestController = @Controller + @ResponseBody 默认直接返回json
@RestController
public class TestController {

	@Autowired
	private	RestTemplate testTemplate;
	
	@GetMapping("/")
    public String index() {
		//访问服务提供者
		return testTemplate.getForObject("http://provider-server/sayHello", String.class);
    }
}
