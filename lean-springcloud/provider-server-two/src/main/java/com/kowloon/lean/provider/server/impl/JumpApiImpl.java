
/**   
 * Title：JumpApiImpl.java 　<br/>
 * Package：com.kowloon.lean.provider.server.impl 　<br/>
 * Description：<br/>
 * Data：2019年1月15日 上午10:28:27<br/>
 * @author lean
 * @copyright  Corporation 2019    
 * @version v1.0 
 */
package com.kowloon.lean.provider.server.impl;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kowloon.lean.provider.server.api.IJumpApi;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * ClassName：com.kowloon.lean.provider.server.impl.JumpApiImpl　　<br/>
 * Description：跳跃方向实现 <br/>
 * Date：2019年1月16日 上午11:21:43<br/>
 * @author lean
 * @version 1.0
 */
@RestController
@Slf4j
public class JumpApiImpl implements IJumpApi {

	@Override
	public String front(@RequestParam("step") String step) {
		log.info("[provider-server-two]服务[JumpApi]的[front]方法被调用，参数step值为：{}", step);
		return "[provider-server-two]服务[JumpApi]调用,往前跳了"+step+"步!";
	}

	@Override
	public String back(@RequestParam("step") String step) {
		log.info("[provider-server-two]服务[JumpApi]的[back]方法被调用，参数step值为：{}", step);
		return "[provider-server-two]服务[JumpApi]调用,往后跳了"+step+"步!";
	}

	@Override
	public String left(@RequestParam("step") String step) {
		log.info("[provider-server-two]服务[JumpApi]的[left]方法被调用，参数step值为：{}", step);
		return "[provider-server-two]服务[JumpApi]调用,往左跳了"+step+"步!";
	}

	@Override
	public String right(@RequestParam("step") String step) {
		log.info("[provider-server-two]服务[JumpApi]的[right]方法被调用，参数step值为：{}", step);
		return "[provider-server-two]服务[JumpApi]调用,往右跳了"+step+"步!";
	}
}
