
/**   
 * Title：ITestClient.java 　<br/>
 * Package：com.kowloon.lean.consumer.client.service.impl 　<br/>
 * Description：<br/>
 * Data：2019年1月15日 上午9:42:44<br/>
 * @author lean
 * @copyright  Corporation 2019    
 * @version v1.0 
 */
package com.kowloon.lean.consumer.client.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * ClassName：com.kowloon.lean.consumer.client.service.ITestClient　　<br/>
 * Description：<br/>
 * Date：2019年1月15日 上午9:43:14<br/>
 * @author lean
 * @version 1.0
 */
//接口指向指定服务
@FeignClient(name="provider-server")
public interface ITestClient {

	/**
	 * 
	 * Description： <br/>
	 * Date：2019年1月15日 上午9:44:14　<br/>
	 * Author：lean <br/>
	 * @param name
	 * @return
	 */
    @RequestMapping(value="/sayHello", method=RequestMethod.GET)
    public String sayHello();
	
}
