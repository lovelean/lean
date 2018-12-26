
/**   
 * Title：DemoController.java 　<br/>
 * Package：com.kowloon.lean.leancontroller.controller 　<br/>
 * Description：<br/>
 * Data：2018年10月17日 下午5:17:47<br/>
 * @author lean
 * @copyright  Corporation 2018    
 * @version v1.0 
 */
package com.kowloon.lean.leancontroller.controller;


import org.junit.experimental.theories.ParametersSuppliedBy;
import org.junit.runners.Parameterized.Parameter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName：com.kowloon.lean.leancontroller.controller.DemoController　　<br/>
 * Description：测试控制层 <br/>
 * Date：2018年10月17日 下午5:17:47<br/>
 * @author lean
 * @version 1.0
 */
@RestController
public class DemoController {

	@RequestMapping(value = "/sayHello/{name}", method = RequestMethod.GET)
	public String sayHello(@PathVariable("name") String name, @RequestParam("tip") String tip) {
		return "SpringBoot say "+tip+" to "+name+"!";
	}
	
}
