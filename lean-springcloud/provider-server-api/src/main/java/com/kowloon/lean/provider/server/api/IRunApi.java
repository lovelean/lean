
/**   
 * Title：IWalkApi.java 　<br/>
 * Package：com.kowloon.lean.provider.server.api 　<br/>
 * Description：<br/>
 * Data：2019年1月15日 上午10:19:10<br/>
 * @author lean
 * @copyright  Corporation 2019    
 * @version v1.0 
 */
package com.kowloon.lean.provider.server.api;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * ClassName：com.kowloon.lean.provider.server.api.IRunApi　　<br/>
 * Description：跑步api <br/>
 * Date：2019年1月15日 下午4:18:10<br/>
 * @author lean
 * @version 1.0
 */
public interface IRunApi {
	
	/**
	 * 
	 * Description：往前N步 <br/>
	 * Date：2019年1月15日 上午10:20:58　<br/>
	 * Author：lean <br/>
	 * @param step 步数
	 * @return
	 */
	@RequestMapping(value="/run/front", method=RequestMethod.POST)
	public Map<String,String> front(@RequestParam("step")String step);
	
	/**
	 * 
	 * Description：往后N步 <br/>
	 * Date：2019年1月15日 上午10:20:58　<br/>
	 * Author：lean <br/>
	 * @param step 步数
	 * @return
	 */
	@RequestMapping(value="/run/back", method=RequestMethod.POST)
	public String back(@RequestParam("step")String step);
	
	/**
	 * 
	 * Description：往左N步 <br/>
	 * Date：2019年1月15日 上午10:20:58　<br/>
	 * Author：lean <br/>
	 * @param step 步数
	 * @return
	 */
	@RequestMapping(value="/run/left", method=RequestMethod.GET)
	public String left(@RequestParam("step")String step);
	
	/**
	 * 
	 * Description：往右N步 <br/>
	 * Date：2019年1月15日 上午10:20:58　<br/>
	 * Author：lean <br/>
	 * @param step 步数
	 * @return
	 */
	@RequestMapping(value="/run/right", method=RequestMethod.GET)
	public String right(@RequestParam("step")String step);
}
