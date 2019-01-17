
/**   
 * Title：RedisTest.java 　<br/>
 * Package：com.kowloon.tools.redis.test 　<br/>
 * Description：<br/>
 * Data：2019年1月17日 下午3:03:32<br/>
 * @author lean
 * @copyright  Corporation 2019    
 * @version v1.0 
 */
package com.kowloon.tools.redis.test;

import org.junit.Before;
import org.junit.Test;

import com.kowloon.tools.redis.RedisInitialize;
import com.kowloon.tools.redis.config.RedisConfigurationBean;
import com.kowloon.tools.redis.proxy.IRedisProxy;

import redis.clients.jedis.JedisPubSub;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

/**
 * ClassName：com.kowloon.tools.redis.test.RedisTest　　<br/>
 * Description：<br/>
 * Date：2019年1月17日 下午3:03:32<br/>
 * @author lean
 * @version 1.0
 */
public class RedisTest {

	private IRedisProxy redisProxy;
	
	private static String key = "888888_888888";
    
    @Before
    public void before() {
    	RedisConfigurationBean config = RedisConfigurationBean.Builder()
    			.addHost("172.18.169.18", 16379)
                .setPassword("bs123456").setDbIndex(15);
        RedisInitialize redisInitialize = new RedisInitialize();
        redisProxy = redisInitialize.init(config);
        redisProxy.del(key);
    }
    
    /**
     * 
     * Description：对redis的基本结构进行测试  <br/>
     * Date：2019年1月17日 下午3:05:12　<br/>
     * Author：lean <br/>
     */
    @Test
    public void test() {
        // KEY
    	System.out.println("redisProxy.del(key):"+(long) redisProxy.del(key));
    	System.out.println("redisProxy.get(key):"+redisProxy.get(key));
    	System.out.println("redisProxy.set(key, \"abc\"):"+redisProxy.set(key, "abc"));
    	System.out.println("(boolean) redisProxy.exists(key):"+(boolean) redisProxy.exists(key));
    	System.out.println("redisProxy.get(key):"+redisProxy.get(key));
    	System.out.println("(long) redisProxy.del(key):"+(long) redisProxy.del(key));
        // 集合
    	System.out.println("(long) redisProxy.sadd(key, \"11\", \"22\", \"33\"):"+(long) redisProxy.sadd(key, "11", "22", "33"));
        ScanResult<String> scanResult = null;
        ScanParams params = new ScanParams();
        params.count(10);
        String cursor = "0";
        scanResult = redisProxy.sscan(key, cursor, params);
    	System.out.println("scanResult.getResult().size():"+scanResult.getResult().size());
        // 发布订阅
        new Thread(new Runnable() {
            @Override
            public void run() {
                redisProxy.subscribe(new TradeSubscriber(), "aaaaa");
            }
        }).start();
        redisProxy.publish("aaaaa", "helloWorld!!!");
    }
    
    class TradeSubscriber extends JedisPubSub {
        @Override
        public void onMessage(String channel, String message) {
            System.out.println("收到消息：" + message);
        }
    }
}
