
/**   
 * Title：FeignServiceImpl.java 　<br/>
 * Package：com.kowloon.lean.consumer.client.service.impl 　<br/>
 * Description：<br/>
 * Data：2019年1月16日 上午9:41:11<br/>
 * @author lean
 * @copyright  Corporation 2019    
 * @version v1.0 
 */
package com.kowloon.lean.consumer.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.cloud.openfeign.ribbon.LoadBalancerFeignClient;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

import com.kowloon.lean.consumer.client.service.IFeignService;

import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

/**
 * ClassName：com.kowloon.lean.consumer.client.service.impl.FeignServiceImpl　　<br/>
 * Description：feign接口 <br/>
 * Date：2019年1月16日 上午9:41:11<br/>
 * @author lean
 * @version 1.0
 */
@Service
@Import(FeignClientsConfiguration.class)
public class FeignServiceImpl implements IFeignService {
	
	private final Feign.Builder urlBuilder;
    
    private final Feign.Builder nameBuilder;

    @Autowired
    public FeignServiceImpl(Decoder decoder, Encoder encoder, Client client, Contract contract) {
        // nameBuilder直接使用client，它会使用负载均衡
        nameBuilder = Feign.builder()
            .client(client)
            .encoder(new JacksonEncoder())//.encoder(encoder)
            .decoder(new JacksonDecoder())//.decoder(decoder)
            .contract(contract);
        
        if (client instanceof LoadBalancerFeignClient) { 
        	// 无需均衡负载
            client = ((LoadBalancerFeignClient)client).getDelegate();
        }
        //url的无需负载均衡
        urlBuilder = Feign.builder()
            .client(client)
            .encoder(encoder)
            .decoder(decoder)
            .contract(contract);
    }
	
	@Override
	public <T> T newInstanceByUrl(Class<T> feignClientClazz, String url) {
		return urlBuilder.target(feignClientClazz, url);
	}

	@Override
	public <T> T newInstanceByName(Class<T> feignClientClazz, String name) {
		return nameBuilder.target(feignClientClazz, "http://"+name);
	}

}
