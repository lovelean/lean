package com.bosssoft.itfinance.citizen.tools.exception;

import java.io.Serializable;

/**
 * 
 * ClassName：com.bosssoft.itfinance.citizen.tools.exception.ToolsCommonException　　<br/>
 * Description：<br/>
 * Date：2018年10月24日 上午10:13:51<br/>
 * @author lean
 * @version 1.0
 */
public class ToolsCommonException extends Exception implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 异常代码
     */
    private String code;

    /**
     * 异常信息
     */
    private String msg;

    public ToolsCommonException() {
    }

    public ToolsCommonException(ToolsCommonError ToolsCommonError) {
    	super(ToolsCommonError.getCode()+":"+ToolsCommonError.getMsg());
    	this.code = ToolsCommonError.getCode();
    	this.msg = ToolsCommonError.getMsg();
    }
    
    public ToolsCommonException(String code, String msg) {
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
		return "ToolsCommonException [code=" + code + ", msg=" + msg + "]";
	}
}
