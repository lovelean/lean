package com.kowloon.tools.httpclient3.exception;

/**
 * 
 * ClassName：com.kowloon.tools.httpclient3.exception.HttpCommonError　　<br/>
 * Description：异常错误<br/>
 * Date：2018年8月3日 下午2:36:29<br/>
 * @author lean
 * @version 1.0
 */
public enum HttpCommonError {

    INIT_ERROR("0101001", "初始化异常"),
    HAS_INIT_ERROR("0101002", "已初始化,不能重复初始化"),
    IO_ERROR("0101003", "请求异常"),
    TIMEOUT_ERROR("0101004", "网关响应超时"),
    CONNECTION_ERROR("0101005", "网关连接超时"),
    RESPONSE_ERROR("0101006", "响应异常");
	
    private String code;

    private String msg;

    HttpCommonError(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
