
/**   
 * Title：RedisInitialize.java 　<br/>
 * Package：com.kowloon.tools.redis 　<br/>
 * Description：<br/>
 * Data：2019年1月17日 下午2:47:01<br/>
 * @author lean
 * @copyright  Corporation 2019    
 * @version v1.0 
 */
package com.kowloon.tools.redis;

import java.lang.reflect.Proxy;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.kowloon.tools.redis.config.RedisConfigurationBean;
import com.kowloon.tools.redis.config.RedisHostAndPort;
import com.kowloon.tools.redis.handler.RedisClusterInvocationHandler;
import com.kowloon.tools.redis.handler.RedisSingleInvocationHandler;
import com.kowloon.tools.redis.proxy.IRedisProxy;
import com.kowloon.tools.redis.proxy.impl.RedisProxy;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisPoolConfig;

/**
 * ClassName：com.kowloon.tools.redis.RedisInitialize　　<br/>
 * Description：Redis初始化类 <br/>
 * Date：2019年1月17日 下午2:47:01<br/>
 * @author lean
 * @version 1.0
 */
public class RedisInitialize {

	// JedisPoolConfig默认配置
    private int     maxIdle                       = 10;
    private int     maxTotal                      = 30;
    private int     maxWaitMillis                 = 10000;
    private boolean testOnBorrow                  = false;
    private boolean testOnReturn                  = false;
    private int     timeBetweenEvictionRunsMillis = 30000;
    private boolean testWhileIdle                 = false;
    
    /**
     * 
     * Description：初始化 <br/>
     * Date：2019年1月17日 下午2:53:44　<br/>
     * Author：lean <br/>
     * @param redisConfigurationBean
     * @return
     */
    public IRedisProxy init(RedisConfigurationBean redisConfigurationBean) {
        if (redisConfigurationBean.getJedisPoolConfig() == null) {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxIdle(maxIdle);
            config.setMaxTotal(maxTotal);
            config.setMaxWaitMillis(maxWaitMillis);
            config.setTestOnBorrow(testOnBorrow);
            config.setTestOnReturn(testOnReturn);
            config.setTestWhileIdle(testWhileIdle);// Idle时进行连接扫描
            config.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
            redisConfigurationBean.setJedisPoolConfig(config);
        }
        List<RedisHostAndPort> hosts = redisConfigurationBean.getRedisHostAndPorts();
        if (hosts.isEmpty()) {
            throw new RuntimeException("Redis-错误的Redis地址");
        } else if (hosts.size() == 1) {
            IRedisProxy redisProxy = (IRedisProxy) Proxy.newProxyInstance(RedisProxy.class.getClassLoader(),
            		RedisProxy.class.getInterfaces(),
                    new RedisSingleInvocationHandler(hosts.get(0).getHost(), 
                    		hosts.get(0).getPort(),
                            redisConfigurationBean.getConnectionTimeOut(), 
                            redisConfigurationBean.getPassword(), 
                            redisConfigurationBean.getDbIndex(),
                            redisConfigurationBean.getJedisPoolConfig()));
            return redisProxy;
        } else {
            Set<HostAndPort> nodes = new LinkedHashSet<HostAndPort>();
            for (RedisHostAndPort redisHostAndPort : hosts) {
                nodes.add(new HostAndPort(redisHostAndPort.getHost(), redisHostAndPort.getPort()));
            }
            IRedisProxy redisProxy = (IRedisProxy) Proxy.newProxyInstance(RedisProxy.class.getClassLoader(),
            		RedisProxy.class.getInterfaces(),
                    new RedisClusterInvocationHandler(nodes,
                            redisConfigurationBean.getConnectionTimeOut(), 
                            redisConfigurationBean.getSoTimeOut(),
                            redisConfigurationBean.getPassword(), 
                            redisConfigurationBean.getJedisPoolConfig()));
            return redisProxy;
        }
    }
}
