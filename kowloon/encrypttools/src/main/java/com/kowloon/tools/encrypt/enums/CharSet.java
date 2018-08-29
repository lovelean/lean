package com.kowloon.tools.encrypt.enums;

/**
 * 
 * ClassName：com.kowloon.tools.encrypt.enums.CharSet　　<br/>
 * Description：字符集枚举 <br/>
 * Date：2018年8月28日 下午4:23:02<br/>
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
