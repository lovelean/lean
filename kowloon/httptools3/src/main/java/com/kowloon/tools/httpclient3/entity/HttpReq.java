package com.kowloon.tools.httpclient3.entity;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.kowloon.tools.httpclient3.enums.CharSet;

/**
 * 
 * ClassName：com.kowloon.tools.entity.HttpReq　　<br/>
 * Description：http请求对象<br/>
 * Date：2018年7月26日 上午11:43:55<br/>
 * @author lean
 * @version 1.0
 */
public class HttpReq {

    private String url;
    private CharSet charset;
    private Map<String,String> params;
    private List<File> files;

    public HttpReq() {
    }

    public HttpReq(String url) {
        this.url = url;
    }

    public HttpReq(String url, Map<String, String> params) {
        this.url = url;
        this.params = params;
    }

    public HttpReq(String url, Map<String, String> params, List<File> files) {
        this.url = url;
        this.params = params;
        this.files = files;
    }

    public HttpReq(String url, List<File> files) {
        this.url = url;
        this.files = files;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public CharSet getCharset() {
        return charset;
    }

    public void setCharset(CharSet charset) {
        this.charset = charset;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

}
