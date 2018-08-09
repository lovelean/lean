package com.kowloon.tools.httpclient4.httpClient;

import org.apache.http.message.BasicHeader;

import java.nio.charset.Charset;

/**
 * 
 * ClassName：com.kowloon.tools.httpclient.common.BsHttpClientConfig　　<br/>
 * Description：httpClient配置类<br/>
 * Date：2018年7月23日 下午2:50:16<br/>
 * @author lean
 * @version 1.0
 */
public class HttpClientConfig {
    private BasicHeader formContentType;
    private BasicHeader bodyJsonContentType;

    public HttpClientConfig(Charset charset){
        formContentType = new BasicHeader("Content-Type","application/x-www-form-urlencoded; charset="+charset.name());
        bodyJsonContentType = new BasicHeader("Content-Type","application/json; charset="+charset.name());
    }

    public BasicHeader getFormContentType() {
        return formContentType;
    }

    public BasicHeader getBodyJsonContentType() {
        return bodyJsonContentType;
    }

}
