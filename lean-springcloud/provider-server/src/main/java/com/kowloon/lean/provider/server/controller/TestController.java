
/**   
 * Title：DemoController.java 　<br/>
 * Package：com.bosssoft.itfinance.citizen.wallet.controller 　<br/>
 * Description：<br/>
 * Data：2018年8月16日 上午11:23:39<br/>
 * @author lean
 * @copyright  Corporation 2018    
 * @version v1.0 
 */
package com.kowloon.lean.provider.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * ClassName：com.kowloon.lean.provider.server.controller.TestController　　<br/>
 * Description：<br/>
 * Date：2018年12月27日 上午10:15:40<br/>
 * @author lean
 * @version 1.0
 */
//@RestController = @Controller + @ResponseBody 默认直接返回json
@RestController
public class TestController {

	@RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    public String sayHello(@RequestParam(value = "name", defaultValue = "lean") String name) {
        return "hi " + name + " ,i am from provider server";
    }
}
