package com.lean.project.springboot.monitor.api.httpclient;

import org.apache.http.message.BasicHeader;

import java.nio.charset.Charset;

/**
 * 
 * ClassName：com.lean.project.springboot.monitor.api.httpclient.HttpClientConfig　　<br/>
 * Description：httpClient配置类 <br/>
 * Date：2019年1月27日 下午4:19:10<br/>
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
