
/**   
 * Title：MonitorConfig.java 　<br/>
 * Package：com.lean.project.springboot.monitor.api.config 　<br/>
 * Description：<br/>
 * Data：2019年1月27日 下午4:20:00<br/>
 * @author lean
 * @copyright  Corporation 2019    
 * @version v1.0 
 */
package com.lean.project.springboot.monitor.api.config;

/**
 * ClassName：com.lean.project.springboot.monitor.api.config.MonitorConfig　　<br/>
 * Description：监控配置 <br/>
 * Date：2019年1月27日 下午4:20:00<br/>
 * @author lean
 * @version 1.0
 */
public class MonitorConfig {
	
	//监控中心地址
	private String monitorCenterUrl;
	
	//服务中心启用状态.默认不启用
	private boolean monitorEnabled = false;

	public MonitorConfig() {
		
	}
	
	public String getMonitorCenterUrl() {
		return monitorCenterUrl;
	}

	public void setMonitorCenterUrl(String monitorCenterUrl) {
		this.monitorCenterUrl = monitorCenterUrl;
	}

	public boolean isMonitorEnabled() {
		return monitorEnabled;
	}

	public void setMonitorEnabled(boolean monitorEnabled) {
		this.monitorEnabled = monitorEnabled;
	}
}
