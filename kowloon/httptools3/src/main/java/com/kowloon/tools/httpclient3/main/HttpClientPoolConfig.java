package com.kowloon.tools.httpclient3.main;

/**
 * 
 * ClassName：com.kowloon.tools.httpclient.common.HttpClientPoolConfig　　<br/>
 * Description：httpClient链接池参数配置<br/>
 * Date：2018年7月23日 下午2:51:02<br/>
 * @author lean
 * @version 1.0
 */
public class HttpClientPoolConfig {
    /** 链接创建超时时间 毫秒*/
    private static int defaultConnectionTimeout = 10000;
    /** 等待响应超时时间（两次响应间隔时间） 默认值10秒, httpclient机制10秒会进行重试*/
    private static int defaultSocketTimeout = 10000;
    /** 等待ConnectionManager释放connection的时间 毫秒*/
    private static int defaultConnectionManagerTimeout = 60000;
    /** 闲置连接超时时间, 由bean factory设置，缺省为60秒钟 */
    private static int defaultIdleConnTimeout = 60000;
    /** 链接池最大链接数 */
    private static int defaultPoolMaxTotal = 200;
    /** 每个路由最大连接数（链接主机和端口组成一个路由） */
    private static int defaultMaxPerRoute = 20;

    /** 链接创建超时时间 毫秒*/
    private Integer connectionTimeout;

    /** 等待响应超时时间（两次响应间隔时间） 毫秒*/
    private Integer socketTimeout;

    /** 从链接池获取链接超时时间 毫秒*/
    private Integer connectionManagerTimeout;

    /** 闲置连接超时时间 毫秒*/
    private Integer idleConnTimeout;
    
    /** 链接池最大链接数*/
    private Integer poolMaxTotal;

    /** 每个路由最大连接数（链接主机和端口组成一个路由）*/
    private Integer maxPerRoute;

    
    public HttpClientPoolConfig() {
		
	}
    
    /**
     * 
     * <p>Description：构造函数</p>
     * @param connectionTimeout 创建连接超时时间 毫秒
     * @param socketTimeout 等待响应超时时间 毫秒
     */
    public HttpClientPoolConfig(Integer connectionTimeout, Integer socketTimeout){
    	this.connectionTimeout = connectionTimeout;
    	this.socketTimeout = socketTimeout;
    }
    
    /**
     * 
     * <p>Description：构造函数</p>
     * @param connectionTimeout 创建连接超时时间 毫秒
     * @param socketTimeout 等待响应超时时间 毫秒
     * @param connectionManagerTimeout 获取链接超时时间 毫秒
     * @param idleConnTimeout 闲置连接超时时间 毫秒
     * @param poolMaxTotal 链接池最大链接数
     * @param maxPerRoute 单主机路由最大连接数
     */
    public HttpClientPoolConfig(Integer connectionTimeout, Integer socketTimeout, Integer connectionManagerTimeout, 
    		Integer idleConnTimeout, Integer poolMaxTotal, Integer maxPerRoute){
    	this.connectionTimeout = connectionTimeout;
    	this.socketTimeout = socketTimeout;
    	this.connectionManagerTimeout = idleConnTimeout;
    	this.idleConnTimeout = idleConnTimeout;
    	this.poolMaxTotal = poolMaxTotal;
    	this.maxPerRoute = maxPerRoute;
    }
    
    public Integer getConnectionTimeout() {
        return connectionTimeout==null?defaultConnectionTimeout:connectionTimeout;
    }

    public void setConnectionTimeout(Integer connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public Integer getSocketTimeout() {
        return socketTimeout == null?defaultSocketTimeout:socketTimeout;
    }

    public void setSocketTimeout(Integer socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public Integer getConnectionManagerTimeout() {
        return connectionManagerTimeout == null?defaultConnectionManagerTimeout:connectionManagerTimeout;
    }

    public void setConnectionManagerTimeout(Integer connectionManagerTimeout) {
        this.connectionManagerTimeout = connectionManagerTimeout;
    }

    public Integer getIdleConnTimeout() {
        return idleConnTimeout == null?defaultIdleConnTimeout:idleConnTimeout;
    }

    public void setIdleConnTimeout(Integer idleConnTimeout) {
        this.idleConnTimeout = idleConnTimeout;
    }
    
    public Integer getPoolMaxTotal() {
        return poolMaxTotal==null?defaultPoolMaxTotal:poolMaxTotal;
    }

    public void setPoolMaxTotal(Integer poolMaxTotal) {
        this.poolMaxTotal = poolMaxTotal;
    }

    public Integer getMaxPerRoute() {
        return maxPerRoute==null?defaultMaxPerRoute:maxPerRoute;
    }

    public void setMaxPerRoute(Integer maxPerRoute) {
        this.maxPerRoute = maxPerRoute;
    }

	@Override
	public String toString() {
		return "HttpClientPoolConfig [connectionTimeout=" + connectionTimeout + ", socketTimeout=" + socketTimeout
				+ ", connectionManagerTimeout=" + connectionManagerTimeout + ", idleConnTimeout=" + idleConnTimeout
				+ ", poolMaxTotal=" + poolMaxTotal + ", maxPerRoute=" + maxPerRoute + "]";
	}
}
