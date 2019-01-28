package com.lean.project.springboot.monitor.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lean.project.springboot.monitor.api.config.MonitorTool;

/**
 * 
 * ClassName：com.lean.project.springboot.provider.test.BootMonitorTest　　<br/>
 * Description：<br/>
 * Date：2019年1月27日 下午5:24:55<br/>
 * @author lean
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BootMonitorTest {
	
	@Test
	public void testA() {
		Map<String,Object> params = new HashMap<>();
    	params.put("version","1.0.0");   
    	params.put("info",new String("接口超时"));       	
    	try {
    		MonitorTool.sendInfo(params);
    	} catch (Exception e) {
    		System.out.println("post error:"+e.getMessage());
		}
	}
}
