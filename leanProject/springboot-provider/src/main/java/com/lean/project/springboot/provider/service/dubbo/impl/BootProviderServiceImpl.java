package com.lean.project.springboot.provider.service.dubbo.impl;


import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.lean.project.springboot.common.api.IBootProviderService;

/**
 * 
 * ClassName：com.lean.project.springboot.provide.service.dubbo.impl.BootProviderServiceImpl　　<br/>
 * Description：<br/>
 * Date：2018年9月27日 下午5:37:40<br/>
 * @author lean
 * @version 1.0
 */
@Service(version="${dubbo.service.version}", 
group="${dubbo.service.group}", 
application = "${spring.application.id}",
protocol = "${dubbo.protocol.id}",
registry = "${dubbo.registry.id}",
timeout=30000, retries=0,
interfaceClass = IBootProviderService.class)
@Component
public class BootProviderServiceImpl implements IBootProviderService {

	@Override
	public String sayHello(String name) {
		return "Hello, " + name + " (from Spring Boot)";
	}
	
	
}
