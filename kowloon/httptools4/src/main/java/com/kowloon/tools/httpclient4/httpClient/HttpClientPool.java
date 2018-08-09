package com.kowloon.tools.httpclient4.httpClient;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;

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
    private static PoolingHttpClientConnectionManager cm;
    /** 链接工具实例 */
    private static CloseableHttpClient closeableHttpClient;

    /**
     * 
     * Description：初始化默认值 <br/>
     * Date：2018年7月23日 下午3:07:00　<br/>
     * Author：lean <br/>
     * @throws Exception
     */
    private static void init() throws Exception{
        if(cm != null){
            throw new Exception("已初始化，不能重复初始化");
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
    public static void init(HttpClientPoolConfig httpClientPoolConfig) throws Exception{
        if(cm != null){
            throw new Exception("已初始化，不能重复初始化");
        }

        LayeredConnectionSocketFactory sslsf = null;
        if(httpClientPoolConfig.getIgnoreSSL()){
            SSLContextBuilder builder = new SSLContextBuilder();
            // 全部信任 不做身份鉴定
            builder.loadTrustMaterial(null, new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                    return true;
                }
            });
            sslsf = new SSLConnectionSocketFactory(builder.build(), new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.2", "TLSv1.1"}, null, NoopHostnameVerifier.INSTANCE);
        }else{
            sslsf = new SSLConnectionSocketFactory(SSLContext.getDefault());
        }

        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create()
                .register("https", sslsf)
                .register("http", new PlainConnectionSocketFactory())
                .build();
        cm =new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        cm.setMaxTotal(httpClientPoolConfig.getPoolMaxTotal());
        cm.setDefaultMaxPerRoute(httpClientPoolConfig.getMaxPerRoute());

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(httpClientPoolConfig.getConnectionTimeout())
                .setConnectionRequestTimeout(httpClientPoolConfig.getRequestConnectionTimeout())
                .setSocketTimeout(httpClientPoolConfig.getSocketTimeout())
                // 默认允许自动重定向
                .setRedirectsEnabled(true).build();

        closeableHttpClient = HttpClients.custom()
                .setConnectionManager(cm)
                .setDefaultRequestConfig(requestConfig)
                .build();
    }

    /**
     * 
     * Description：返回链接工具
     * 此处没有对工具特殊设置，并且本身是线程安全 <br/>
     * Date：2018年7月23日 下午3:06:44　<br/>
     * Author：lean <br/>
     * @return
     * @throws Exception
     */
    public static CloseableHttpClient getCloseableHttpClient() throws Exception{
        if(cm == null){
            init();
        }
        return closeableHttpClient;
    }

}
