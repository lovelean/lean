
/**   
 * Title：DemoService.java 　<br/>
 * Package：com.lean.project.springboot.monitor.service.impl 　<br/>
 * Description：<br/>
 * Data：2019年1月25日 下午4:32:08<br/>
 * @author lean
 * @copyright  Corporation 2019    
 * @version v1.0 
 */
package com.lean.project.springboot.monitor.service.impl;

import org.springframework.stereotype.Service;

import com.lean.project.springboot.monitor.api.aop.MonitorAnnotation;
import com.lean.project.springboot.monitor.service.IDemoService;

import lombok.extern.slf4j.Slf4j;

/**
 * ClassName：com.lean.project.springboot.monitor.service.impl.DemoService　　<br/>
 * Description：<br/>
 * Date：2019年1月25日 下午4:32:08<br/>
 * @author lean
 * @version 1.0
 */
@Service
@Slf4j
public class DemoService implements IDemoService {

	@Override
	@MonitorAnnotation(timeout=500, dealIfTimeout=true)
	public String demo(String str) {
		log.info("休眠:"+str);;
		try {
			Thread.sleep(Long.valueOf(str));
		} catch (NumberFormatException | InterruptedException e) {
			
		}
		return "sleep " + str;
	}

	
}
