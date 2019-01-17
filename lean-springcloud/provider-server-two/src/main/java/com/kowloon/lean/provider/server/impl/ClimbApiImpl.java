
/**   
 * Title：ClimbApiImpl.java 　<br/>
 * Package：com.kowloon.lean.provider.server.impl 　<br/>
 * Description：<br/>
 * Data：2019年1月15日 上午10:28:27<br/>
 * @author lean
 * @copyright  Corporation 2019    
 * @version v1.0 
 */
package com.kowloon.lean.provider.server.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;

import com.kowloon.lean.provider.server.api.IClimbApi;

import feign.Param;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * ClassName：com.kowloon.lean.provider.server.impl.ClimbApiImpl　　<br/>
 * Description：<br/>
 * Date：2019年1月16日 上午10:47:02<br/>
 * @author lean
 * @version 1.0
 */
@RestController
@Slf4j
public class ClimbApiImpl implements IClimbApi {

	@Override
	public Map<String,String> front(@Param("step") String step) {
		log.info("[provider-server-two]服务[ClimbApi]的[front]方法被调用，参数step值为：{}", step);
		Map<String,String> map = new HashMap<String, String>();
		map.put("info", "[provider-server-two]服务[ClimbApi]调用,往前爬了"+step+"步!");
		return map;
	}

	@Override
	public String back(@Param("step") String step) {
		log.info("[provider-server-two]服务[ClimbApi]的[back]方法被调用，参数step值为：{}", step);
		return "[provider-server-two]服务[ClimbApi]调用,往后爬了"+step+"步!";
	}

	@Override
	public String left(@Param("step") String step) {
		log.info("[provider-server-two]服务[ClimbApi]的[left]方法被调用，参数step值为：{}", step);
		return "[provider-server-two]服务[ClimbApi]调用,往左爬了"+step+"步!";
	}

	@Override
	public String right(@Param("step") String step) {
		log.info("[provider-server-two]服务[ClimbApi]的[right]方法被调用，参数step值为：{}", step);
		return "[provider-server-two]服务[ClimbApi]调用,往右爬了"+step+"步!";
	}
}
