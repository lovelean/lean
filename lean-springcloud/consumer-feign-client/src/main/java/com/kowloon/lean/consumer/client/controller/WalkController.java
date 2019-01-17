
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

import com.kowloon.lean.consumer.client.api.IWalkApiClient;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * ClassName：com.kowloon.lean.consumer.client.controller.WalkController　　<br/>
 * Description：走路控制层 <br/>
 * Date：2019年1月15日 上午10:38:43<br/>
 * @author lean
 * @version 1.0
 */
@RestController
@Slf4j
public class WalkController {
	
	@Autowired
    IWalkApiClient walkApiClient;
	
	@RequestMapping(value="/walk/front", method= {RequestMethod.GET})
	public String front(@RequestParam("step") String step) {
		String walkInfo = walkApiClient.front(step);
		log.info("走路信息：{}", walkInfo);
		return walkInfo;
	};
	
	@RequestMapping(value="/walk/back", method= {RequestMethod.GET})
	public String back(@RequestParam("step") String step) {
		String walkInfo = walkApiClient.back(step);
		log.info("走路信息：{}", walkInfo);
		return walkInfo;
	};
	
	@RequestMapping(value="/walk/left", method= {RequestMethod.GET})
	public String left(@RequestParam("step") String step) {
		String walkInfo = walkApiClient.left(step);
		log.info("走路信息：{}", walkInfo);
		return walkInfo;
	};
	
	@RequestMapping(value="/walk/right", method= {RequestMethod.GET})
	public String right(@RequestParam("step") String step) {
		String walkInfo = walkApiClient.right(step);
		log.info("走路信息：{}", walkInfo);
		return walkInfo;
	};
}
