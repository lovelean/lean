
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

import com.kowloon.lean.consumer.client.api.IRunApiClient;
import com.kowloon.lean.consumer.client.service.IFeignService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * ClassName：com.kowloon.lean.consumer.client.controller.RunController　　<br/>
 * Description：跑步控制层 <br/>
 * Date：2019年1月15日 下午4:23:47<br/>
 * @author lean
 * @version 1.0
 */
@RestController
@Slf4j
public class RunController {
	
	@Autowired
	private IFeignService feignService;
	
	@RequestMapping(value="/run/front", method= {RequestMethod.GET})
	public String front(@RequestParam("serverName") String serverName, @RequestParam("step") String step) {
		IRunApiClient runApiClient = feignService.newInstanceByName(IRunApiClient.class, serverName);
		Map<String, String> runInfo = runApiClient.front(step);
		log.info("跑步信息：{}", runInfo);
		return runInfo.get("info");
	};
	
	@RequestMapping(value="/run/back", method= {RequestMethod.GET})
	public String back(@RequestParam("serverName") String serverName, @RequestParam("step") String step) {
		IRunApiClient runApiClient = feignService.newInstanceByName(IRunApiClient.class, serverName);
		String runInfo = runApiClient.back(step);
		log.info("跑步信息：{}", runInfo);
		return runInfo;
	};
	
	@RequestMapping(value="/run/left", method= {RequestMethod.GET})
	public String left(@RequestParam("serverName") String serverName, @RequestParam("step") String step) {
		IRunApiClient runApiClient = feignService.newInstanceByName(IRunApiClient.class, serverName);
		String runInfo = runApiClient.left(step);
		log.info("跑步信息：{}", runInfo);
		return runInfo;
	};
	
	@RequestMapping(value="/run/right", method= {RequestMethod.GET})
	public String right(@RequestParam("serverName") String serverName, @RequestParam("step") String step) {
		IRunApiClient runApiClient = feignService.newInstanceByName(IRunApiClient.class, serverName);
		String runInfo = runApiClient.right(step);
		log.info("跑步信息：{}", runInfo);
		return runInfo;
	};
}
