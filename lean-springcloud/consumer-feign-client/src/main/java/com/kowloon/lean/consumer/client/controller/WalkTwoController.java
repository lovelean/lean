
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

import com.kowloon.lean.consumer.client.api.IWalkTwoApiClient;
import com.kowloon.lean.consumer.client.service.IFeignService;

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
public class WalkTwoController {
	
	@Autowired
	private IFeignService feignService;
	
	@RequestMapping(value="/walkTwo/front", method= {RequestMethod.GET})
	public String front(@RequestParam("serverName") String serverName, @RequestParam("step") String step) {
		IWalkTwoApiClient walkTwoApiClient = feignService.newInstanceByName(IWalkTwoApiClient.class, serverName);
		String walkInfo = walkTwoApiClient.front(step);
		log.info("走路Two信息：{}", walkInfo);
		return walkInfo;
	};
	
	@RequestMapping(value="/walkTwo/back", method= {RequestMethod.GET})
	public String back(@RequestParam("serverName") String serverName, @RequestParam("step") String step) {
		IWalkTwoApiClient walkTwoApiClient = feignService.newInstanceByName(IWalkTwoApiClient.class, serverName);
		String walkInfo = walkTwoApiClient.back(step);
		log.info("走路Two信息：{}", walkInfo);
		return walkInfo;
	};
	
	@RequestMapping(value="/walkTwo/left", method= {RequestMethod.GET})
	public String left(@RequestParam("serverName") String serverName, @RequestParam("step") String step) {
		IWalkTwoApiClient walkTwoApiClient = feignService.newInstanceByName(IWalkTwoApiClient.class, serverName);
		String walkInfo = walkTwoApiClient.left(step);
		log.info("走路Two信息：{}", walkInfo);
		return walkInfo;
	};
	
	@RequestMapping(value="/walkTwo/right", method= {RequestMethod.GET})
	public String right(@RequestParam("serverName") String serverName, @RequestParam("step") String step) {
		IWalkTwoApiClient walkTwoApiClient = feignService.newInstanceByName(IWalkTwoApiClient.class, serverName);
		String walkInfo = walkTwoApiClient.right(step);
		log.info("走路Two信息：{}", walkInfo);
		return walkInfo;
	};
}
