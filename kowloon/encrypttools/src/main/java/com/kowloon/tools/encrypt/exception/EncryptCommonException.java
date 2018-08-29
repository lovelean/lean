package com.kowloon.tools.encrypt.exception;

import java.io.Serializable;

/**
 * 
 * ClassName：com.kowloon.tools.httpclient3.exception.EncryptCommonException　　<br/>
 * Description：<br/>
 * Date：2018年8月28日 下午4:22:22<br/>
 * @author lean
 * @version 1.0
 */
public class EncryptCommonException extends Exception implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 异常代码
     */
    private String code;

    /**
     * 异常信息
     */
    private String msg;

    public EncryptCommonException() {
    }

    public EncryptCommonException(EncryptCommonError encryptCommonError) {
    	super(encryptCommonError.getCode()+":"+encryptCommonError.getMsg());
    	this.code = encryptCommonError.getCode();
    	this.msg = encryptCommonError.getMsg();
    }
    
    public EncryptCommonException(String code, String msg) {
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
		return "EncryptCommonException [code=" + code + ", msg=" + msg + "]";
	}
}
