
/**   
 * Title：RedisTemplate.java 　<br/>
 * Package：com.kowloon.tools.redis 　<br/>
 * Description：<br/>
 * Data：2019年1月17日 下午2:35:07<br/>
 * @author lean
 * @copyright  Corporation 2019    
 * @version v1.0 
 */
package com.kowloon.tools.redis.proxy;

import redis.clients.jedis.JedisCommands;
import redis.clients.jedis.JedisPubSub;

/**
 * 
 * ClassName：com.kowloon.tools.redis.proxy.IRedisProxy　　<br/>
 * Description：Redis模版代理接口 <br/>
 * Date：2019年1月17日 下午2:45:49<br/>
 * @author lean
 * @version 1.0
 */
public interface IRedisProxy extends JedisCommands {
	
	Long publish(String channel, String message);
    
    void subscribe(JedisPubSub jedisPubSub, String... channels);
    
    void psubscribe(JedisPubSub jedisPubSub, String... patterns);
}
