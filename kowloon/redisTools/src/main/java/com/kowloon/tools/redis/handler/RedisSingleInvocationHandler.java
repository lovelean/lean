
/**   
 * Title：RedisSingleInvocationHandler.java 　<br/>
 * Package：com.kowloon.tools.redis.proxy 　<br/>
 * Description：<br/>
 * Data：2019年1月17日 下午2:31:32<br/>
 * @author lean
 * @copyright  Corporation 2019    
 * @version v1.0 
 */
package com.kowloon.tools.redis.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 
 * ClassName：com.kowloon.tools.redis.handler.RedisSingleInvocationHandler　　<br/>
 * Description：Redis单点代理调用处理 <br/>
 * Date：2019年1月17日 下午2:44:48<br/>
 * @author lean
 * @version 1.0
 */
public class RedisSingleInvocationHandler implements InvocationHandler {

	private JedisPool jedisPool;
    private int       dbIndex;
    
    /**
     * 
     * <p>Description：构造函数</p>
     * @param host
     * @param port
     * @param connectionTimeOut
     * @param password
     * @param dbIndex
     * @param config
     */
    public RedisSingleInvocationHandler(String host, int port, int connectionTimeOut, String password, int dbIndex, JedisPoolConfig config) {
        if (password == null || password.isEmpty()) password = null;
        this.dbIndex = dbIndex;
        this.jedisPool = new JedisPool(config, host, port, connectionTimeOut, password);
    }
    
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		try (Jedis jedis = jedisPool.getResource()) {
            if (dbIndex != 0) {
                jedis.select(dbIndex);
            }
            if (method.getName().equals("publish") || method.getName().equals("subscribe") || method.getName().equals("psubscribe")) {
                Method method2 = Jedis.class.getMethod(method.getName(), method.getParameterTypes());
                Object result = method2.invoke(jedis, args);
                return result;
            } else {
                Object result = method.invoke(jedis, args);
                return result;
            }
        }
	}

}
