package com.lean.project.springboot.monitor.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lean.project.springboot.monitor.service.IDemoService;

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
	
	@Autowired
	private IDemoService demoService;
	
	@Test
	public void testA() {
		long start = System.currentTimeMillis();
		System.out.println("first demo:100,,,time:"+start);
		demoService.demo("1000");
        long finish = System.currentTimeMillis();
		System.out.println("first demo end,,,usetime:"+(finish - start));
	}
}
