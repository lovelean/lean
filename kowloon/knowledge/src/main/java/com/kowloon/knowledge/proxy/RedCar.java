
/**   
 * Title：RedCar.java 　<br/>
 * Package：com.kowloon.knowledge.proxy 　<br/>
 * Description：<br/>
 * Data：2019年1月18日 上午9:34:25<br/>
 * @author lean
 * @copyright  Corporation 2019    
 * @version v1.0 
 */
package com.kowloon.knowledge.proxy;


/**
 * ClassName：com.kowloon.knowledge.proxy.RedCar　　<br/>
 * Description：红色车 <br/>
 * Date：2019年1月18日 上午9:34:25<br/>
 * @author lean
 * @version 1.0
 */
public class RedCar implements ICar {

	@Override
	public void run() {
		System.out.println("i am running!!!");
	}

}
