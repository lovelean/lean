package com.kowloon.tools.httpclient3.entity;

import org.apache.commons.httpclient.Header;

/**
 * 
 * ClassName：com.kowloon.tools.entity.HttpResp　　<br/>
 * Description：http响应对象 <br/>
 * Date：2018年7月26日 上午11:44:37<br/>
 * @author lean
 * @version 1.0
 */
public class HttpResp {

    private int status;
    private Header[] headers;
    private byte[] bodyByte;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Header[] getHeaders() {
        return headers;
    }

    public void setHeaders(Header[] headers) {
        this.headers = headers;
    }

    public byte[] getBodyByte() {
        return bodyByte;
    }

    public void setBodyByte(byte[] bodyByte) {
        this.bodyByte = bodyByte;
    }

    public String getBodyString() {
        return new String(this.bodyByte);
    }

    public boolean isSuccess(){
        return this.status == 200;
    }
}
