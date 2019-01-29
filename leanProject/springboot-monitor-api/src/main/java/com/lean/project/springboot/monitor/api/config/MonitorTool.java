package com.lean.project.springboot.monitor.api.config;

import java.util.Map;

import com.lean.project.springboot.monitor.api.httpclient.HttpClientPool;
import com.lean.project.springboot.monitor.api.httpclient.HttpClientPoolConfig;
import com.lean.project.springboot.monitor.api.httpclient.HttpClientTool;

/**
 * 
 * ClassName：com.lean.project.springboot.monitor.api.config.MonitorTool　　<br/>
 * Description：<br/>
 * Date：2019年1月28日 上午9:43:59<br/>
 * @author lean
 * @version 1.0
 */
public class MonitorTool {
	
    private static MonitorConfig monitorConfig = new MonitorConfig();

    /**
     * 
     * Description：初始化监控中心配置[默认http配置] <br/>
     * Date：2019年1月28日 上午10:07:29　<br/>
     * Author：lean <br/>
     * @param monitorCenterUrl
     * @throws Exception
     */
    public static void initMonitorConfig(String monitorCenterUrl) throws Exception {
    	monitorConfig.setMonitorCenterUrl(monitorCenterUrl);
    	monitorConfig.setMonitorEnabled(true);
    }
    
    /**
     * 
     * Description： 初始化监控中心配置[指定http请求配置]<br/>
     * Date：2019年1月28日 上午10:07:06　<br/>
     * Author：lean <br/>
     * @param monitorCenterUrl
     * @param httpClientPoolConfig
     * @throws Exception
     */
    public static void initMonitorConfig(String monitorCenterUrl, HttpClientPoolConfig httpClientPoolConfig) throws Exception {
    	if(httpClientPoolConfig != null) HttpClientPool.init(httpClientPoolConfig);
    	monitorConfig.setMonitorCenterUrl(monitorCenterUrl);
    	monitorConfig.setMonitorEnabled(true);
    }
    
    /**
     * 
     * Description：启用监控中心 <br/>
     * Date：2019年1月28日 上午10:56:30　<br/>
     * Author：lean <br/>
     * @throws Exception
     */
    public static void openMonitorCenter() {
    	monitorConfig.setMonitorEnabled(true);
    }
    
    /**
     * 
     * Description：停用监控中心 <br/>
     * Date：2019年1月28日 上午10:56:49　<br/>
     * Author：lean <br/>
     * @throws Exception
     */
    public static void closeMonitorCenter() {
    	monitorConfig.setMonitorEnabled(false);
    }
    
    /**
     * 
     * Description：服务中心是否启用 <br/>
     * Date：2019年1月28日 上午11:00:58　<br/>
     * Author：lean <br/>
     * @return
     */
    public static boolean isMonitorEnabled() {
    	return monitorConfig.isMonitorEnabled();
    }
    
    /**
     * 
     * Description：发送信息 <br/>
     * Date：2019年1月28日 上午9:47:37　<br/>
     * Author：lean <br/>
     * @param params 参数
     * @return
     * @throws Exception
     */
    public static void sendInfo(Map<String,Object> params) throws Exception {
        if(monitorConfig.getMonitorCenterUrl() == null || "".equals(monitorConfig.getMonitorCenterUrl()) || monitorConfig.getMonitorCenterUrl().length() == 0) {
        	throw new Exception("监控服务中心地址未配置,请确认!");
        }else {
        	HttpClientTool.sendForm(monitorConfig.getMonitorCenterUrl(), params);
        }
    }
    
    /**
     * 
     * Description：发送信息[指定监控服务中心地址] <br/>
     * Date：2019年1月28日 上午9:47:37　<br/>
     * Author：lean <br/>
     * @param monitorCenterUrl 服务中心地址
     * @param params 参数
     * @return
     * @throws Exception
     */
    public static void sendInfo(String monitorCenterUrl, Map<String,Object> params) throws Exception {
        if(monitorCenterUrl == null || "".equals(monitorCenterUrl) || monitorCenterUrl.length() == 0) {
        	throw new Exception("监控服务中心地址未指定,请确认!");
        }else {
        	HttpClientTool.sendForm(monitorCenterUrl, params);
        }
    }
}
