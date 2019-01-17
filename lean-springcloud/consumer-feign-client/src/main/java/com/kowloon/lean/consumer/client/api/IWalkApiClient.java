
/**   
 * Title：ITestClient.java 　<br/>
 * Package：com.kowloon.lean.consumer.client.service.impl 　<br/>
 * Description：<br/>
 * Data：2019年1月15日 上午9:42:44<br/>
 * @author lean
 * @copyright  Corporation 2019    
 * @version v1.0 
 */
package com.kowloon.lean.consumer.client.api;

import org.springframework.cloud.openfeign.FeignClient;

import com.kowloon.lean.provider.server.api.IWalkApi;

/**
 * 
 * ClassName：com.kowloon.lean.consumer.client.service.IWalkApiClient　　<br/>
 * Description：走路方向接口 <br/>
 * Date：2019年1月15日 上午10:36:46<br/>
 * @author lean
 * @version 1.0
 */
//接口指向指定服务
@FeignClient(name = IWalkApi.SERVICE_NAME)
public interface IWalkApiClient extends IWalkApi {
	
	
}
