
/**   
 * Title：RedisClusterInvocationHandler.java 　<br/>
 * Package：com.kowloon.tools.redis.proxy 　<br/>
 * Description：<br/>
 * Data：2019年1月17日 下午2:24:00<br/>
 * @author lean
 * @copyright  Corporation 2019    
 * @version v1.0 
 */
package com.kowloon.tools.redis.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 
 * ClassName：com.kowloon.tools.redis.handler.RedisClusterInvocationHandler　　<br/>
 * Description：Redis集群代理调用处理 <br/>
 * Date：2019年1月17日 下午2:44:40<br/>
 * @author lean
 * @version 1.0
 */
public class RedisClusterInvocationHandler implements InvocationHandler {

	private JedisCluster jedisCluster;
    
	/**
	 * 
	 * <p>Description：构造函数</p>
	 * @param nodes
	 * @param connectionTimeOut
	 * @param soTimeOut
	 * @param password
	 * @param config
	 */
    public RedisClusterInvocationHandler(Set<HostAndPort> nodes, int connectionTimeOut, int soTimeOut, String password, JedisPoolConfig config) {
        if (password == null || password.isEmpty())  password = null;
        jedisCluster = new JedisCluster(nodes, connectionTimeOut, connectionTimeOut, 10, password, config);
    }
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] arg2) throws Throwable {
		if (method.getName().equals("publish") || method.getName().equals("subscribe") || method.getName().equals("psubscribe")) {
            Method method2 = JedisCluster.class.getMethod(method.getName(), method.getParameterTypes());
            Object result = method2.invoke(jedisCluster, arg2);
            return result;
        } else {
            Object result = method.invoke(jedisCluster, arg2);
            return result;
        }
	}

}
