
/**   
 * Title：RedisHostAndPort.java 　<br/>
 * Package：com.kowloon.tools.redis.config 　<br/>
 * Description：<br/>
 * Data：2019年1月17日 下午4:50:01<br/>
 * @author lean
 * @copyright  Corporation 2019    
 * @version v1.0 
 */
package com.kowloon.tools.redis.config;


/**
 * ClassName：com.kowloon.tools.redis.config.RedisHostAndPort　　<br/>
 * Description：主机及端口信息类<br/>
 * Date：2019年1月17日 下午4:50:01<br/>
 * @author lean
 * @version 1.0
 */
public class RedisHostAndPort {

	private String host;
    private int    port;
    
    public RedisHostAndPort(String host, int port) {
        this.host = host;
        this.port = port;
    }
    
    public String getHost() {
        return host;
    }
    
    public int getPort() {
        return port;
    }
}
