package com.kowloon.tools.httpclient3.enums;

/**
 * 
 * ClassName：com.kowloon.tools.enums.CharSet　　<br/>
 * Description：字符集枚举 <br/>
 * Date：2018年7月26日 上午11:43:37<br/>
 * @author lean
 * @version 1.0
 */
public enum CharSet {
    UTF8("UTF-8","UTF-8"),
    GBK("GBK","GBK");
	
	private String code;
    private String msg;

    CharSet(String code, String msg) {
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
