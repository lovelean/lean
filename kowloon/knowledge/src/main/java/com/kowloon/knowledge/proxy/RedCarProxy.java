
/**   
 * Title：CarProxy.java 　<br/>
 * Package：com.kowloon.knowledge.proxy 　<br/>
 * Description：<br/>
 * Data：2019年1月18日 上午9:36:25<br/>
 * @author lean
 * @copyright  Corporation 2019    
 * @version v1.0 
 */
package com.kowloon.knowledge.proxy;

/**
 * ClassName：com.kowloon.knowledge.proxy.CarProxy　　<br/>
 * Description：<br/>
 * Date：2019年1月18日 上午9:36:25<br/>
 * @author lean
 * @version 1.0
 */
public class RedCarProxy implements ICar {

	//代理模式的作用是：为其他对象提供一种代理以控制对这个对象的访问。
	ICar redCar = new RedCar();
	
	@Override
	public void run() {
		System.out.println("start-up"); //调用目标对象之前可以做相关操作
		redCar.run();
		System.out.println("stop");//调用目标对象之后可以做相关操作
	}

}
