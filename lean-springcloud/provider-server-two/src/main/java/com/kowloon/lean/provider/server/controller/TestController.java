
/**   
 * Title：DemoController.java 　<br/>
 * Package：com.bosssoft.itfinance.citizen.wallet.controller 　<br/>
 * Description：<br/>
 * Data：2018年8月16日 上午11:23:39<br/>
 * @author lean
 * @copyright  Corporation 2018    
 * @version v1.0 
 */
package com.kowloon.lean.provider.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * ClassName：com.kowloon.lean.provider.server.controller.TestController　　<br/>
 * Description：<br/>
 * Date：2019年1月9日 下午5:29:22<br/>
 * @author lean
 * @version 1.0
 */
//@RestController = @Controller + @ResponseBody 默认直接返回json
@RestController
@Slf4j
public class TestController {

	@GetMapping("/sayHello")
    public String sayHello() {
		//访问服务提供者
		log.info("服务被调用了!");
		return "provider say hello to you!";
    }
}
