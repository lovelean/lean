package com.kowloon.tools.httpclient3.main;

import org.apache.commons.httpclient.Header;

import com.kowloon.tools.httpclient3.enums.CharSet;

/**
 * 
 * ClassName：com.kowloon.tools.HttpClientConfig　　<br/>
 * Description：httpClient配置类<br/>
 * Date：2018年7月26日 上午11:51:15<br/>
 * @author lean
 * @version 1.0
 */
public class HttpClientConfig {
	private CharSet charSet;
	private Header userAgent;
    private Header formContentType;
    private String jsonContentType;

    public HttpClientConfig(CharSet charset){
    	charSet = charset;
    	userAgent = new Header("User-Agent", "Mozilla/4.0");
        formContentType = new Header("Content-Type","application/x-www-form-urlencoded; text/html; charset="+charset.getMsg());
        jsonContentType = "application/json";
    }

    public CharSet getChatSet() {
        return charSet;
    }
    
    public Header getUserAgent() {
		return userAgent;
	}
    
    public Header getFormContentType() {
        return formContentType;
    }

    public String getJsonContentType() {
        return jsonContentType;
    }

}
