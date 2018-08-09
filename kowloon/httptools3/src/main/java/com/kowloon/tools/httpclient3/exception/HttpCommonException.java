package com.kowloon.tools.httpclient3.exception;

import java.io.Serializable;

/**
 * 
 * ClassName：com.kowloon.tools.httpclient3.exception.HttpCommonException　　<br/>
 * Description：<br/>
 * Date：2018年8月3日 下午2:35:02<br/>
 * @author lean
 * @version 1.0
 */
public class HttpCommonException extends Exception implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 异常代码
     */
    private String code;

    /**
     * 异常信息
     */
    private String msg;

    public HttpCommonException() {
    }

    public HttpCommonException(HttpCommonError httpCommonError) {
    	super(httpCommonError.getCode()+":"+httpCommonError.getMsg());
    	this.code = httpCommonError.getCode();
    	this.msg = httpCommonError.getMsg();
    }
    
    public HttpCommonException(String code, String msg) {
        super(code+":"+msg);
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

	@Override
	public String toString() {
		return "HttpCommonException [code=" + code + ", msg=" + msg + "]";
	}
}
