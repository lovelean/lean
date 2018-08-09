package com.kowloon.tools.httptools.test;

import java.nio.charset.Charset;

import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * ClassName：com.kowloon.tools.httptools.test.HttpClientDefault　　<br/>
 * Description：<br/>
 * Date：2018年7月23日 下午2:57:17<br/>
 * @author lean
 * @version 1.0
 */
public class HttpClientDefault {
    private static Logger logger = LoggerFactory.getLogger(HttpClientDefault.class);
    private static Charset DEFAULT_CHARSET = Consts.UTF_8;
    private final static int HTTP_OK = 200;

    private void sendReq(String url,CloseableHttpClient httpClient) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        BasicHeader header = new BasicHeader("Content-Type","application/x-www-form-urlencoded; charset=utf-8");
        httpPost.addHeader(header);
        HttpResponse httpResponse = httpClient.execute(httpPost);
        if (httpResponse == null) {
            throw new Exception("http调用异常，response返回空");
        }

        int httpCode = httpResponse.getStatusLine().getStatusCode();
        String rst;
        if (httpCode == HTTP_OK) {
            rst = EntityUtils.toString(httpResponse.getEntity(), DEFAULT_CHARSET);
            logger.debug("http调用成功,url={},rst={}",url,rst);
        } else {
            rst = EntityUtils.toString(httpResponse.getEntity(), DEFAULT_CHARSET);
            logger.warn("http调用失败,code={},url={},rst={}",httpCode,url,rst);
            throw new Exception("http请求失败,返回code="+httpCode+",msg="+rst);
        }
        //System.out.println("===="+rst);
    }

    private CloseableHttpClient defaultClient() throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        return httpClient;
    }

    private CloseableHttpClient defaultNullPoolClient() throws Exception {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(30000)
                .setConnectionRequestTimeout(60000)
                .setSocketTimeout(5000)
                // 默认允许自动重定向
                .setRedirectsEnabled(true).build();
        CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .build();
        return httpClient;
    }

    private CloseableHttpClient defaultPoolClient() throws Exception {
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create()
                .register("http", new PlainConnectionSocketFactory())
                .build();
        PoolingHttpClientConnectionManager cm =new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        cm.setMaxTotal(200);
        cm.setDefaultMaxPerRoute(20);
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(30000)
                .setConnectionRequestTimeout(60000)
                .setSocketTimeout(5000)
                // 默认允许自动重定向
                .setRedirectsEnabled(true).build();
        CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .setConnectionManager(cm)
                .build();
        return httpClient;
    }

    @Test
    public void test() throws Exception {
        final String url = "http://172.18.169.21:8081/myapp/myServlet";
        //final CloseableHttpClient httpClient = defaultClient();
        final CloseableHttpClient httpClient = defaultNullPoolClient();
        //final CloseableHttpClient httpClient = defaultPoolClient();
/*        for(int i=0;i<1000;i++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {
                        sendReq(url,httpClient);
                        //defaultNullPoolClient(url);
                        //defaultPoolClient(url,httpClient);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            thread.start();
        }
        Thread.sleep(50000000);*/
    }
}
