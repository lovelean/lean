
/**   
 * Title：RunApiImpl.java 　<br/>
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

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kowloon.lean.provider.server.api.IRunApi;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * ClassName：com.kowloon.lean.provider.server.impl.RunApiImpl　　<br/>
 * Description：<br/>
 * Date：2019年1月15日 下午4:37:05<br/>
 * @author lean
 * @version 1.0
 */
@RestController
@Slf4j
public class RunApiImpl implements IRunApi {

	@Override
	public Map<String,String> front(@RequestParam("step") String step) {
		log.info("[provider-server-two]服务[RunApi]的[front]方法被调用，参数step值为：{}", step);
		Map<String,String> map = new HashMap<String, String>();
		map.put("info", "[provider-server-two]服务[RunApi]调用,往前跑了"+step+"步!");
		return map;
	}

	@Override
	public String back(@RequestParam("step") String step) {
		log.info("[provider-server-two]服务[RunApi]的[back]方法被调用，参数step值为：{}", step);
		return "[provider-server-two]服务[RunApi]调用,往后跑了"+step+"步!";
	}

	@Override
	public String left(@RequestParam("step") String step) {
		log.info("[provider-server-two]服务[RunApi]的[left]方法被调用，参数step值为：{}", step);
		return "[provider-server-two]服务[RunApi]调用,往左跑了"+step+"步!";
	}

	@Override
	public String right(@RequestParam("step") String step) {
		log.info("[provider-server-two]服务[RunApi]的[right]方法被调用，参数step值为：{}", step);
		return "[provider-server-two]服务[RunApi]调用,往右跑了"+step+"步!";
	}
}
