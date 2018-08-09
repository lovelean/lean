package com.kowloon.tools.httpclient3.main;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.util.IdleConnectionTimeoutThread;

import com.kowloon.tools.httpclient3.exception.HttpCommonError;
import com.kowloon.tools.httpclient3.exception.HttpCommonException;

/**
 * 
 * ClassName：com.kowloon.tools.httpclient.common.HttpClientPool　　<br/>
 * Description：httpClient连接池<br/>
 * Date：2018年7月23日 下午2:50:46<br/>
 * @author lean
 * @version 1.0
 */
public class HttpClientPool {
    /** 连接池管理 */
    private static HttpConnectionManager cm;
    /** 链接工具实例 */
    private static HttpClient httpClient;

    /**
     * 
     * Description：初始化默认值 <br/>
     * Date：2018年7月23日 下午3:07:00　<br/>
     * Author：lean <br/>
     * @throws Exception
     */
    private static void init() throws HttpCommonException{
        if(cm != null){
            throw new HttpCommonException(HttpCommonError.HAS_INIT_ERROR);
        }
        HttpClientPoolConfig httpClientPoolConfig = new HttpClientPoolConfig();
        init(httpClientPoolConfig);
    }

    /**
     * 
     * Description：初始化指定配置值 <br/>
     * Date：2018年7月23日 下午3:07:12　<br/>
     * Author：lean <br/>
     * @param httpClientPoolConfig 指定httpClient连接池配置
     * @throws Exception
     */
    public static void init(HttpClientPoolConfig httpClientPoolConfig) throws HttpCommonException{
        if(cm != null){
        	throw new HttpCommonException(HttpCommonError.HAS_INIT_ERROR);
        }
        try{
        	cm = new MultiThreadedHttpConnectionManager();
            //单主机最大活动链接数
            cm.getParams().setDefaultMaxConnectionsPerHost(httpClientPoolConfig.getMaxPerRoute());
            //最大连接数
            cm.getParams().setMaxTotalConnections(httpClientPoolConfig.getPoolMaxTotal());

            IdleConnectionTimeoutThread ict = new IdleConnectionTimeoutThread();
            ict.addConnectionManager(cm);
            //闲置连接超时时间
            ict.setConnectionTimeout(httpClientPoolConfig.getIdleConnTimeout());
            ict.start();
            
            HttpClient hc = new HttpClient(cm);
            // 设置连接超时
            hc.getHttpConnectionManager().getParams().setConnectionTimeout(httpClientPoolConfig.getConnectionTimeout());
            // 设置回应超时
            hc.getHttpConnectionManager().getParams().setSoTimeout(httpClientPoolConfig.getSocketTimeout());
            // 设置等待ConnectionManager释放connection的时间
            hc.getParams().setConnectionManagerTimeout(httpClientPoolConfig.getConnectionManagerTimeout());
            httpClient = hc;
        }catch(Exception e){
        	throw new HttpCommonException(HttpCommonError.INIT_ERROR);
        }
    }
    
    /**
     * 
     * Description：重载httpClient的配置 <br/>
     * Date：2018年8月9日 上午9:47:02　<br/>
     * Author：lean <br/>
     * @param httpClientPoolConfig
     * @throws HttpCommonException
     */
    public static void reload(HttpClientPoolConfig httpClientPoolConfig) throws HttpCommonException {
    	if(cm != null) cm = null;
    	init(httpClientPoolConfig);
	}

    /**
     * 
     * Description：返回链接工具 <br/>
     * Date：2018年7月23日 下午3:06:44　<br/>
     * Author：lean <br/>
     * @return
     * @throws Exception
     */
    public static HttpClient getHttpClient() throws HttpCommonException{
        if(cm == null){
            init();
        }
        return httpClient;
    }

    /**
     * 
     * Description：返回链接工具[基础配置改为传入的参数] <br/>
     * Date：2018年7月26日 下午3:38:04　<br/>
     * Author：lean <br/>
     * @param httpClientPoolConfig
     * @return
     * @throws Exception
     */
    public static HttpClient getHttpClient(HttpClientPoolConfig httpClientPoolConfig) throws HttpCommonException {
    	if(cm != null) cm = null;
    	init(httpClientPoolConfig);
        return httpClient;
	}
}
