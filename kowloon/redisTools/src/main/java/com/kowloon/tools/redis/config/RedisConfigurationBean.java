
/**   
 * Title：RedisConfigurationBean.java 　<br/>
 * Package：com.kowloon.tools.redis.config 　<br/>
 * Description：<br/>
 * Data：2019年1月17日 下午2:16:01<br/>
 * @author lean
 * @copyright  Corporation 2019    
 * @version v1.0 
 */
package com.kowloon.tools.redis.config;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.JedisPoolConfig;

/**
 * ClassName：com.kowloon.tools.redis.config.RedisConfigurationBean　　<br/>
 * Description：Redis配置bean<br/>
 * Date：2019年1月17日 下午2:16:01<br/>
 * @author lean
 * @version 1.0
 */
public class RedisConfigurationBean {

	private List<RedisHostAndPort> redisHostAndPorts = new ArrayList<>();
    private JedisPoolConfig jedisPoolConfig;
    private String password;
    private int dbIndex = 0;
    private int connectionTimeOut = 30000;// 连接超时，默认30秒
    private int soTimeOut = 30000;// Socket超时，默认30秒
    
    private RedisConfigurationBean() {
        
    }
    
    /**
     * 
     * Description： <br/>
     * Date：2019年1月17日 下午2:22:20　<br/>
     * Author：lean <br/>
     * @return
     */
    public static RedisConfigurationBean Builder() {
        return new RedisConfigurationBean();
    }
    
    public List<RedisHostAndPort> getRedisHostAndPorts() {
		return redisHostAndPorts;
	}

	public RedisConfigurationBean setRedisHostAndPorts(List<RedisHostAndPort> redisHostAndPorts) {
		this.redisHostAndPorts = redisHostAndPorts;
		return this;
	}

	public JedisPoolConfig getJedisPoolConfig() {
		return jedisPoolConfig;
	}

	public RedisConfigurationBean setJedisPoolConfig(JedisPoolConfig jedisPoolConfig) {
		this.jedisPoolConfig = jedisPoolConfig;
        return this;
	}

	public String getPassword() {
		return password;
	}

	public RedisConfigurationBean setPassword(String password) {
		this.password = password;
        return this;
	}

	public int getDbIndex() {
		return dbIndex;
	}

	public RedisConfigurationBean setDbIndex(int dbIndex) {
		this.dbIndex = dbIndex;
        return this;
	}

	public int getConnectionTimeOut() {
		return connectionTimeOut;
	}

	public RedisConfigurationBean setConnectionTimeOut(int connectionTimeOut) {
		this.connectionTimeOut = connectionTimeOut;
        return this;
	}

	public int getSoTimeOut() {
		return soTimeOut;
	}

	public RedisConfigurationBean setSoTimeOut(int soTimeOut) {
		this.soTimeOut = soTimeOut;
        return this;
	}

	/**
	 * 
	 * Description：新增主机端口 <br/>
	 * Date：2019年1月17日 下午2:22:41　<br/>
	 * Author：lean <br/>
	 * @param host 
	 * @param port
	 * @return
	 */
	public RedisConfigurationBean addHost(String host, int port) {
        this.redisHostAndPorts.add(new RedisHostAndPort(host, port));
        return this;
    }
}
