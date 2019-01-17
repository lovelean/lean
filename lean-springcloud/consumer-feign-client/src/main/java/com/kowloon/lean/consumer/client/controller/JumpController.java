
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kowloon.lean.consumer.client.api.IJumpApiClient;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * ClassName：com.kowloon.lean.consumer.client.controller.JumpController　　<br/>
 * Description：跳跃控制层 <br/>
 * Date：2019年1月16日 上午11:24:44<br/>
 * @author lean
 * @version 1.0
 */
@RestController
@Slf4j
public class JumpController {
	
	@Autowired
    IJumpApiClient jumpApiClient;
	
	@RequestMapping(value="/jump/front", method= {RequestMethod.GET})
	public String front(@RequestParam("step") String step) {
		String walkInfo = jumpApiClient.front(step);
		log.info("跳跃信息：{}", walkInfo);
		return walkInfo;
	};
	
	@RequestMapping(value="/jump/back", method= {RequestMethod.GET})
	public String back(@RequestParam("step") String step) {
		String walkInfo = jumpApiClient.back(step);
		log.info("跳跃信息：{}", walkInfo);
		return walkInfo;
	};
	
	@RequestMapping(value="/jump/left", method= {RequestMethod.GET})
	public String left(@RequestParam("step") String step) {
		String walkInfo = jumpApiClient.left(step);
		log.info("跳跃信息：{}", walkInfo);
		return walkInfo;
	};
	
	@RequestMapping(value="/jump/right", method= {RequestMethod.GET})
	public String right(@RequestParam("step") String step) {
		String walkInfo = jumpApiClient.right(step);
		log.info("跳跃信息：{}", walkInfo);
		return walkInfo;
	};
}
