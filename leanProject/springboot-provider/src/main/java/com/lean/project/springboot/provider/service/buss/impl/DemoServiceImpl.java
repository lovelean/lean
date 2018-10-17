package com.lean.project.springboot.provider.service.buss.impl;


import org.springframework.stereotype.Service;

import com.lean.project.springboot.provider.service.buss.IDemoService;

/**
 * 
 * ClassName：com.lean.project.springboot.provide.service.impl.BootProviderServiceImpl　　<br/>
 * Description：<br/>
 * Date：2018年9月27日 下午5:35:02<br/>
 * @author lean
 * @version 1.0
 */
@Service
public class DemoServiceImpl implements IDemoService {

	@Override
	public String dubboDemo(String resString) {
		return resString+" coming";
	}
	
	
}
