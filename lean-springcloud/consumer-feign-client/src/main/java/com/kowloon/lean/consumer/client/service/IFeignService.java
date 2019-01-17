
/**   
 * Title：FeignService.java 　<br/>
 * Package：com.kowloon.lean.consumer.client.service 　<br/>
 * Description：<br/>
 * Data：2019年1月16日 上午9:38:39<br/>
 * @author lean
 * @copyright  Corporation 2019    
 * @version v1.0 
 */
package com.kowloon.lean.consumer.client.service;


/**
 * ClassName：com.kowloon.lean.consumer.client.service.IFeignService　　<br/>
 * Description：feign接口 <br/>
 * Date：2019年1月16日 上午9:38:39<br/>
 * @author lean
 * @version 1.0
 */
public interface IFeignService {

	/**
	 * 
	 * Description：通过url创建feign客户端实例 <br/>
	 * Date：2019年1月16日 上午9:39:13　<br/>
	 * Author：lean <br/>
	 * @param feignClientClazz feign接口类
	 * @param url 动态url，包含协议、ip、端口、根目录，如:"http://192.168.153.1:5567/ems"
	 * @return
	 */
    public <T> T newInstanceByUrl(Class<T> feignClientClazz, String url);
    
    /**
	 * 
	 * Description：通过服务名创建feign客户端实例  <br/>
	 * Date：2019年1月16日 上午9:39:13　<br/>
	 * Author：lean <br/>
	 * @param feignClientClazz feign接口类
	 * @param url 动态名称，包含协议、名称、根目录，如:"http://ems-core/ems"
	 * @return
	 */
    public <T> T newInstanceByName(Class<T> feignClientClazz, String name);	
}
