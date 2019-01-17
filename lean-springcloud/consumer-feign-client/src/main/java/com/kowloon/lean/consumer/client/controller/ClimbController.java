
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

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kowloon.lean.consumer.client.api.IClimbApiClient;
import com.kowloon.lean.consumer.client.service.IFeignService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * ClassName：com.kowloon.lean.consumer.client.controller.ClimbController　　<br/>
 * Description：爬行控制层 <br/>
 * Date：2019年1月16日 上午10:48:45<br/>
 * @author lean
 * @version 1.0
 */
@RestController
@Slf4j
public class ClimbController {
	
	@Autowired
	private IFeignService feignService;
	
	@RequestMapping(value="/climb/front", method= {RequestMethod.GET})
	public String front(@RequestParam("serverName") String serverName, @RequestParam("step") String step) {
		IClimbApiClient ClimbApiClient = feignService.newInstanceByName(IClimbApiClient.class, serverName);
		Map<String, String> ClimbInfo = ClimbApiClient.front(step);
		log.info("爬行信息：{}", ClimbInfo);
		return ClimbInfo.get("info");
	};
	
	@RequestMapping(value="/climb/back", method= {RequestMethod.GET})
	public String back(@RequestParam("serverName") String serverName, @RequestParam("step") String step) {
		IClimbApiClient ClimbApiClient = feignService.newInstanceByName(IClimbApiClient.class, serverName);
		String ClimbInfo = ClimbApiClient.back(step);
		log.info("爬行信息：{}", ClimbInfo);
		return ClimbInfo;
	};
	
	@RequestMapping(value="/climb/left", method= {RequestMethod.GET})
	public String left(@RequestParam("serverName") String serverName, @RequestParam("step") String step) {
		IClimbApiClient ClimbApiClient = feignService.newInstanceByName(IClimbApiClient.class, serverName);
		String ClimbInfo = ClimbApiClient.left(step);
		log.info("爬行信息：{}", ClimbInfo);
		return ClimbInfo;
	};
	
	@RequestMapping(value="/Climb/right", method= {RequestMethod.GET})
	public String right(@RequestParam("serverName") String serverName, @RequestParam("step") String step) {
		IClimbApiClient ClimbApiClient = feignService.newInstanceByName(IClimbApiClient.class, serverName);
		String ClimbInfo = ClimbApiClient.right(step);
		log.info("爬行信息：{}", ClimbInfo);
		return ClimbInfo;
	};
}
