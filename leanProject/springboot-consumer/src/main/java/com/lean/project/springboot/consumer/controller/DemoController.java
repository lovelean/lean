
/**   
 * Title：DemoController.java 　<br/>
 * Package：com.bosssoft.itfinance.citizen.wallet.controller 　<br/>
 * Description：<br/>
 * Data：2018年8月16日 上午11:23:39<br/>
 * @author lean
 * @copyright  Corporation 2018    
 * @version v1.0 
 */
package com.lean.project.springboot.consumer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lean.project.springboot.common.api.IBootProviderService;

import lombok.extern.slf4j.Slf4j;

/**
 * ClassName：com.bosssoft.itfinance.citizen.wallet.controller.DemoController　　<br/>
 * Description：<br/>
 * Date：2018年8月16日 上午11:23:39<br/>
 * @author lean
 * @version 1.0
 */
//@RestController = @Controller + @ResponseBody 默认直接返回json
@RestController
@Slf4j
public class DemoController {

	@Reference(version = "1.0.0",
            application = "${dubbo.application.id}",
            group="boot-provider",
            url = "dubbo://172.18.160.222:32880",
            check=false,retries=0,timeout=30000)
    private IBootProviderService bootProviderService;
	
	@RequestMapping(value = "/bootConsumer", method = RequestMethod.GET)
	public String demo() {
		log.info("程序启动了......");
		return "success";
	}
	
	@RequestMapping(value = "/bootConsumer/sayHello", method = RequestMethod.GET)
	public String sayHello(@RequestParam String name) {
		return bootProviderService.sayHello(name);
	}
}
