
/**   
 * Title：DemoController.java 　<br/>
 * Package：com.bosssoft.itfinance.citizen.wallet.controller 　<br/>
 * Description：<br/>
 * Data：2018年8月16日 上午11:23:39<br/>
 * @author lean
 * @copyright  Corporation 2018    
 * @version v1.0 
 */
package com.lean.project.springboot.monitor.center.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * ClassName：com.lean.project.springboot.monitor.center.controller.ReceiveController　　<br/>
 * Description：<br/>
 * Date：2019年1月27日 下午4:32:31<br/>
 * @author lean
 * @version 1.0
 */
@RestController
@Slf4j
public class ReceiveController {

	@RequestMapping(value = "/receiveInfo", method = {RequestMethod.GET,RequestMethod.POST})
	public String receiveInfo(@RequestParam String info, @RequestParam String version) {
		log.info("receiveInfo-version:"+version);
		log.info("receiveInfo-info:"+info);
		return "success";
	}
	
	@RequestMapping(value = "/healthCheck", method = {RequestMethod.GET,RequestMethod.POST})
	public String healthCheck() {
		return "success";
	}
}
