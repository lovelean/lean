package com.kowloon.lean.consumer.client.base;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import com.kowloon.lean.consumer.client.api.IRunApiClient;

import feign.Feign;
import feign.Request.Options;
import feign.Retryer;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

/**
 * 
 * ClassName：com.kowloon.lean.consumer.client.base.FeignServiceFactoryImpl　　<br/>
 * Description：<br/>
 * Date：2019年1月15日 下午4:25:31<br/>
 * @author lean
 * @version 1.0
 */
@Service
public class FeignServiceFactory {

	@Autowired
	private DiscoveryClient discoveryClient;
	
    //服务提供者缓存
    private ConcurrentMap<String, IRunApiClient> runProviderMap = new ConcurrentHashMap<>();
    
    /**
     * 
     * Description：获取接口实例 <br/>
     * Date：2019年1月15日 下午4:31:08　<br/>
     * Author：lean <br/>
     * @param serverName
     * @return
     */
    public IRunApiClient getRunApiClient(String serverName) {
    	IRunApiClient iRunApiClient = runProviderMap.get(serverName);
    	if(iRunApiClient != null){
    		return iRunApiClient;
    	}else{
    		List<ServiceInstance> list = discoveryClient.getInstances(serverName);
    		//用JacksonEncoder和JacksonDecoder来加解码返回的结果必须为实体对象，猜测要是能装成json的对象
    		iRunApiClient = Feign.builder()
				            .encoder(new JacksonEncoder())
				            .decoder(new JacksonDecoder())
				            .options(new Options(1000, 3500))
				            .retryer(new Retryer.Default(5000, 5000, 3))
				            .target(IRunApiClient.class, list.get(0).getUri().toString());
    		runProviderMap.putIfAbsent(serverName, iRunApiClient);
            return iRunApiClient;
    	}
    }
}
