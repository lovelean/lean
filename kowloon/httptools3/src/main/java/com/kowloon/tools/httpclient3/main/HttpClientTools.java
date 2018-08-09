package com.kowloon.tools.httpclient3.main;

import java.io.File;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.ConnectTimeoutException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.FilePartSource;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.commons.httpclient.params.HttpMethodParams;

import com.alibaba.fastjson.JSON;
import com.kowloon.tools.httpclient3.entity.HttpReq;
import com.kowloon.tools.httpclient3.entity.HttpResp;
import com.kowloon.tools.httpclient3.enums.CharSet;
import com.kowloon.tools.httpclient3.exception.HttpCommonError;
import com.kowloon.tools.httpclient3.exception.HttpCommonException;


/**
 * 
 * ClassName：com.kowloon.tools.main.HttpClientTools　　<br/>
 * Description：工具类 <br/>
 * Date：2018年7月26日 上午11:47:33<br/>
 * @author lean
 * @version 1.0
 */
public class HttpClientTools {
    
    private static HttpClientConfig httpClientConfig = new HttpClientConfig(CharSet.UTF8);

    /**
     * 
     * Description：get 请求 <br/>
     * Date：2018年7月16日 上午10:37:38　<br/>
     * Author：lean <br/>
     * @param url 请求地址
     * @return
     * @throws HttpCommonException 
     */
    public static HttpResp getGet(String url) throws HttpCommonException {
        HttpReq httpReq = new HttpReq(url);
        return sendGet(httpReq);
    }
    
    /**
     * 
     * Description：get 请求 <br/>
     * Date：2018年7月16日 上午10:37:49　<br/>
     * Author：lean <br/>
     * @param httpReq 请求对象
     * @return
     * @throws HttpCommonException 
     * @throws  
     * @throws HttpException 
     * @throws Exception 
     */
    public static HttpResp sendGet(HttpReq httpReq) throws HttpCommonException{
    	GetMethod method = new GetMethod(httpReq.getUrl());
        method.addRequestHeader(httpClientConfig.getUserAgent());
        method.getParams().setCredentialCharset(httpClientConfig.getChatSet().getMsg());
		try {
			int status = HttpClientPool.getHttpClient().executeMethod(method);
			if(status == 200){
				HttpResp httpResp = new HttpResp();
		        httpResp.setStatus(status);
		        httpResp.setHeaders(method.getResponseHeaders());
		        httpResp.setBodyByte(method.getResponseBody());
		        return httpResp;
			}else{
				throw new HttpCommonException(HttpCommonError.RESPONSE_ERROR);
			}
		} catch (ConnectTimeoutException e){ 
			throw new HttpCommonException(HttpCommonError.CONNECTION_ERROR);
		} catch (SocketTimeoutException e){ 
			throw new HttpCommonException(HttpCommonError.TIMEOUT_ERROR);
		} catch (IOException e) {
			throw new HttpCommonException(HttpCommonError.IO_ERROR);
		} finally {
			method.releaseConnection();
		}
    }
    
    /**
     * 
     * Description：post[json请求] <br/>
     * Date：2018年7月16日 上午10:38:23　<br/>
     * Author：lean <br/>
     * @param url 请求地址
     * @param object 参数对象
     * @return
     * @throws HttpCommonException 
     * @throws Exception 
     */
    public static HttpResp sendPost(String url, Object object) throws HttpCommonException{
    	PostMethod postMethod = new PostMethod(url);
        try {
            RequestEntity requestEntity = new StringRequestEntity(JSON.toJSONString(object), httpClientConfig.getJsonContentType(), httpClientConfig.getChatSet().getMsg());
            postMethod.setRequestEntity(requestEntity);
            int status = HttpClientPool.getHttpClient().executeMethod(postMethod);
            if(status == 200){
	            HttpResp httpResp = new HttpResp();
	            httpResp.setStatus(status);
	            httpResp.setHeaders(postMethod.getResponseHeaders());
	            httpResp.setBodyByte(postMethod.getResponseBody());
	            return httpResp;
            }else{
				throw new HttpCommonException(HttpCommonError.RESPONSE_ERROR);
			}
        } catch (ConnectTimeoutException e){ 
			throw new HttpCommonException(HttpCommonError.CONNECTION_ERROR);
		} catch (SocketTimeoutException e){ 
			throw new HttpCommonException(HttpCommonError.TIMEOUT_ERROR);
		} catch (IOException e) {
			throw new HttpCommonException(HttpCommonError.IO_ERROR);
		} finally {
            postMethod.releaseConnection();
        }
    }
    
    /**
     * 
     * Description： post 请求 <br/>
     * Date：2018年7月16日 上午10:38:06　<br/>
     * Author：lean <br/>
     * @param url 请求地址
     * @param params 请求参数
     * @return
     * @throws HttpCommonException 
     * @throws Exception 
     */
    public static HttpResp sendPost(String url, Map<String,String> params) throws HttpCommonException {
        HttpReq httpReq = new HttpReq(url);
        httpReq.setParams(params);
        return sendPost(httpReq);
    }
    
    /**
     * 
     * Description：post 请求 <br/>
     * Date：2018年7月16日 上午10:38:55　<br/>
     * Author：lean <br/>
     * @param httpReq 请求对象
     * @return
     * @throws HttpCommonException 
     */
    public static HttpResp sendPost(HttpReq httpReq) throws HttpCommonException{
    	PostMethod postMethod = new PostMethod(httpReq.getUrl());
        postMethod.addRequestHeader(httpClientConfig.getUserAgent());
        try {
        	if(httpReq.getFiles() == null){
                postMethod.addRequestHeader(httpClientConfig.getFormContentType());
                postMethod.addParameters(mapToNameValuePairs(httpReq.getParams()));
            }else{
                List<Part> parts = new ArrayList<Part>();
                for (String key:httpReq.getParams().keySet()) {
                    parts.add(new StringPart(key, httpReq.getParams().get(key), httpClientConfig.getChatSet().getMsg()));
                }
                for(File file:httpReq.getFiles()){
                    //增加文件参数，strParaFileName是参数名，使用本地文件
                    parts.add(new FilePart(file.getName(), new FilePartSource(file)));
                }
                // 设置请求体
                postMethod.setRequestEntity(new MultipartRequestEntity(parts.toArray(new Part[0]), new HttpMethodParams()));
            }
            int status = HttpClientPool.getHttpClient().executeMethod(postMethod);
            if(status == 200){
            	HttpResp httpResp = new HttpResp();
                httpResp.setStatus(status);
                httpResp.setHeaders(postMethod.getResponseHeaders());
                httpResp.setBodyByte(postMethod.getResponseBody());
                return httpResp;
            }else{
				throw new HttpCommonException(HttpCommonError.RESPONSE_ERROR);
			}
        } catch (ConnectTimeoutException e){ 
			throw new HttpCommonException(HttpCommonError.CONNECTION_ERROR);
		} catch (SocketTimeoutException e){ 
			throw new HttpCommonException(HttpCommonError.TIMEOUT_ERROR);
		} catch (IOException e) {
			throw new HttpCommonException(HttpCommonError.IO_ERROR);
		} finally {
			postMethod.releaseConnection();
        }
    }

    /**
     * 
     * Description：MAP类型数组转换成NameValuePair类型 <br/>
     * Date：2018年7月16日 上午10:39:18　<br/>
     * Author：lean <br/>
     * @param properties MAP类型数组
     * @return NameValuePair类型数组
     */
    private static NameValuePair[] mapToNameValuePairs(Map<String, String> properties) {
        NameValuePair[] nameValuePair = new NameValuePair[properties.size()];
        int i = 0;
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            nameValuePair[i++] = new NameValuePair(entry.getKey(), entry.getValue());
        }
        return nameValuePair;
    }
}
