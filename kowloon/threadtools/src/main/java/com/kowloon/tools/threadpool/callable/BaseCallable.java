
/**   
 * Title：BaseCallable.java 　<br/>
 * Package：com.kowloon.tools.threadpool.callable 　<br/>
 * Description：<br/>
 * Data：2019年3月5日 下午3:42:37<br/>
 * @author lean
 * @copyright  Corporation 2019    
 * @version v1.0 
 */
package com.kowloon.tools.threadpool.callable;

import java.util.concurrent.Callable;

/**
 * ClassName：com.kowloon.tools.threadpool.callable.BaseCallable　　<br/>
 * Description：<br/>
 * Date：2019年3月5日 下午3:42:37<br/>
 * @author lean
 * @version 1.0
 */
public class BaseCallable implements Callable<String> {

	private String message;
	 
    public BaseCallable(String message) {
        this.message = message;
    }

	
	@Override
	public String call() throws Exception {
		 Thread.sleep(300);
         System.out.println(String.format("打印消息%s", message));
         return String.format("%sOK", message);
	}

}
