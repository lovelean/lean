
/**   
 * Title：DemoController.java 　<br/>
 * Package：com.bosssoft.itfinance.citizen.wallet.controller 　<br/>
 * Description：<br/>
 * Data：2018年8月16日 上午11:23:39<br/>
 * @author lean
 * @copyright  Corporation 2018    
 * @version v1.0 
 */
package com.lean.project.springboot.monitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lean.project.springboot.monitor.service.IDemoService;

/**
 * ClassName：com.bosssoft.itfinance.citizen.wallet.controller.DemoController　　<br/>
 * Description：<br/>
 * Date：2018年8月16日 上午11:23:39<br/>
 * @author lean
 * @version 1.0
 */
//@RestController = @Controller + @ResponseBody 默认直接返回json
@RestController
public class DemoController {

	@Autowired
	private IDemoService demoService;
	
	@RequestMapping(value = "/demo", method = RequestMethod.GET)
	public String demo(@RequestParam String sleep) {
		if(sleep == null || "".equals(sleep) || sleep.length() == 0) {
			sleep="0";
		}
		String aaa = demoService.demo(sleep);
		return aaa;
	}
	
	@RequestMapping(value = "/healthCheck", method = {RequestMethod.GET,RequestMethod.POST})
	public String healthCheck() {
		return "success";
	}
}
