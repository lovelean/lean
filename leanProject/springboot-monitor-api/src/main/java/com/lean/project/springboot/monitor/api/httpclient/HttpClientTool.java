package com.lean.project.springboot.monitor.api.httpclient;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

/**
 * 
 * ClassName：com.lean.project.springboot.monitor.api.httpclient.HttpClientTool　　<br/>
 * Description：httpClient工具包 <br/>
 * Date：2019年1月27日 下午4:19:34<br/>
 * @author lean
 * @version 1.0
 */
public class HttpClientTool {
	
    private static Logger logger = LoggerFactory.getLogger(HttpClientTool.class);
    private static Charset DEFAULT_CHARSET = Consts.UTF_8;
    private final static int HTTP_OK = 200;
    private static HttpClientConfig httpClientConfig = new HttpClientConfig(DEFAULT_CHARSET);

    /**
     * 
     * Description：FORM表单POST方式提交请求 <br/>
     * Date：2018年7月23日 下午2:46:42　<br/>
     * Author：lean <br/>
     * @param url 请求地址
     * @param param 参数
     * @return
     * @throws Exception
     */
    public static String sendForm(String url, Map<String,Object> params) throws Exception {
        return sendForm(url,params,null);
    }

    /**
     * 
     * Description：FORM表单POST方式提交请求 <br/>
     * Date：2018年7月23日 下午2:47:12　<br/>
     * Author：lean <br/>
     * @param url 请求地址
     * @param param 参数
     * @param proxyHost 代理服务器信息 HttpHost proxy = new HttpHost("127.0.0.1", 8888, "http");
     * @return
     * @throws Exception
     */
    public static String sendForm(String url, Map<String,Object> params, HttpHost proxyHost) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        if(proxyHost != null){
            RequestConfig requestConfig = RequestConfig.custom()
                    .setProxy(proxyHost)
                    .build();
            httpPost.setConfig(requestConfig);
        }
        httpPost.addHeader(httpClientConfig.getFormContentType());
        if (params != null && !params.isEmpty()) {
            List<NameValuePair> formParams = new ArrayList<>();
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                formParams.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue())));
            }
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(formParams, DEFAULT_CHARSET);
            httpPost.setEntity(urlEncodedFormEntity);
        }
        return sendPost(httpPost,url,JSON.toJSONString(params));
    }

    /**
     * 
     * Description：BODY字符串JSON格式POST方式提交请求 <br/>
     * Date：2018年7月23日 下午2:47:52　<br/>
     * Author：lean <br/>
     * @param url 请求地址
     * @param jsonStr 内容json串
     * @return
     * @throws Exception
     */
    public static String sendBody(String url,String jsonStr) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader(httpClientConfig.getBodyJsonContentType());
        httpPost.setEntity(new StringEntity(jsonStr,DEFAULT_CHARSET));
        return sendPost(httpPost,url,jsonStr);
    }

    /**
     * 
     * Description：post请求 <br/>
     * Date：2018年7月23日 下午2:49:04　<br/>
     * Author：lean <br/>
     * @param httpPost post请求对象
     * @param url 地址
     * @param paramStr 参数
     * @return
     * @throws Exception
     */
    private static String sendPost(HttpPost httpPost,String url,String paramStr) throws Exception{
        String rst;
        CloseableHttpClient httpClient= HttpClientPool.getCloseableHttpClient();
        HttpResponse httpResponse = httpClient.execute(httpPost);
        if (httpResponse == null) {
            throw new Exception("http调用异常，response返回空");
        }
        int httpCode = httpResponse.getStatusLine().getStatusCode();
        if (httpCode == HTTP_OK) {
            rst = EntityUtils.toString(httpResponse.getEntity(), DEFAULT_CHARSET);
            logger.debug("http调用成功,url={},params={},rst={}",url, paramStr,rst);
            return rst;
        } else {
            rst = EntityUtils.toString(httpResponse.getEntity(), DEFAULT_CHARSET);
            logger.warn("http调用失败,code={},url={},params={},rst={}",httpCode,url,paramStr,rst);
            throw new Exception("http请求失败,返回code="+httpCode+",msg="+rst);
        }
    }
}
