
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

import feign.Param;
import feign.RequestLine;

/**
 * 
 * ClassName：com.kowloon.lean.provider.server.api.ISleepApi　　<br/>
 * Description：爬api <br/>
 * Date：2019年1月16日 上午10:43:16<br/>
 * @author lean
 * @version 1.0
 */
public interface IClimbApi {
	
	/**
	 * 
	 * Description：往前N步 <br/>
	 * Date：2019年1月15日 上午10:20:58　<br/>
	 * Author：lean <br/>
	 * @param step 步数
	 * @return
	 */
	@RequestLine("POST /climb/front?step={step}")
	public Map<String,String> front(@Param("step") String step);
	
	/**
	 * 
	 * Description：往后N步 <br/>
	 * Date：2019年1月15日 上午10:20:58　<br/>
	 * Author：lean <br/>
	 * @param step 步数
	 * @return
	 */
	@RequestLine("POST /climb/back?step={step}")
	public String back(@Param("step") String step);
	
	/**
	 * 
	 * Description：往左N步 <br/>
	 * Date：2019年1月15日 上午10:20:58　<br/>
	 * Author：lean <br/>
	 * @param step 步数
	 * @return
	 */
	@RequestLine("GET /climb/left?step={step}")
	public String left(@Param("step") String step);
	
	/**
	 * 
	 * Description：往右N步 <br/>
	 * Date：2019年1月15日 上午10:20:58　<br/>
	 * Author：lean <br/>
	 * @param step 步数
	 * @return
	 */
	@RequestLine("GET /climb/right?step={step}")
	public String right(@Param("step") String step);
}
