package com.lean.project.springboot.monitor.basic;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.lean.project.springboot.monitor.api.config.MonitorTool;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * ClassName：com.lean.project.springboot.monitor.basic.BootMonitorConfig　　<br/>
 * Description：<br/>
 * Date：2019年1月25日 下午4:20:46<br/>
 * @author lean
 * @version 1.0
 */
@Component
@Slf4j
public class MonitorFactory {
	
	@PostConstruct
	public void init() {
		try {
			String monitorCenterUrl = "http://172.18.160.222:32891/monitor/center/receiveInfo";
			MonitorTool.initMonitorConfig(monitorCenterUrl);
			log.error("加载监控中心地址成功:"+monitorCenterUrl);
		} catch (Exception e) {
			log.error("加载监控中心地址失败:"+e.getMessage());
		}
	}
	
}
