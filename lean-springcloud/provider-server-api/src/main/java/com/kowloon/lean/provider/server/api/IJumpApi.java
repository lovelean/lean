
/**   
 * Title：IjumpApi.java 　<br/>
 * Package：com.kowloon.lean.provider.server.api 　<br/>
 * Description：<br/>
 * Data：2019年1月15日 上午10:19:10<br/>
 * @author lean
 * @copyright  Corporation 2019    
 * @version v1.0 
 */
package com.kowloon.lean.provider.server.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * ClassName：com.kowloon.lean.provider.server.api.IJumpApi　　<br/>
 * Description：<br/>
 * Date：2019年1月16日 上午11:19:33<br/>
 * @author lean
 * @version 1.0
 */
public interface IJumpApi {
	//定义提供者服务名
	public static final String SERVICE_NAME = "provider-server";
	
	/**
	 * 
	 * Description：往前N步 <br/>
	 * Date：2019年1月15日 上午10:20:58　<br/>
	 * Author：lean <br/>
	 * @param step 步数
	 * @return
	 */
	@PostMapping(value="/jump/front")
	public String front(@RequestParam("step") String step);
	
	/**
	 * 
	 * Description：往后N步 <br/>
	 * Date：2019年1月15日 上午10:20:58　<br/>
	 * Author：lean <br/>
	 * @param step 步数
	 * @return
	 */
	@GetMapping(value="/jump/back")
	public String back(@RequestParam("step") String step);
	
	/**
	 * 
	 * Description：往左N步 <br/>
	 * Date：2019年1月15日 上午10:20:58　<br/>
	 * Author：lean <br/>
	 * @param step 步数
	 * @return
	 */
	@RequestMapping(value="/jump/left", method= {RequestMethod.POST})
	public String left(@RequestParam("step") String step);
	
	/**
	 * 
	 * Description：往右N步 <br/>
	 * Date：2019年1月15日 上午10:20:58　<br/>
	 * Author：lean <br/>
	 * @param step 步数
	 * @return
	 */
	@RequestMapping(value="/jump/right")
	public String right(@RequestParam("step") String step);
}
