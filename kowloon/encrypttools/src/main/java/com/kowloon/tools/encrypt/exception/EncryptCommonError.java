package com.kowloon.tools.encrypt.exception;

/**
 * 
 * ClassName：com.kowloon.tools.httpclient3.exception.EncryptCommonError　　<br/>
 * Description：<br/>
 * Date：2018年8月28日 下午4:22:04<br/>
 * @author lean
 * @version 1.0
 */
public enum EncryptCommonError {

	SYS_INIT_ERROR("E001001", "初始化异常"),
    SYS_("E001002", "已初始化,不能重复初始化"),
    SYS_FORMAT_JSON_ERROR("E001003","JSON格式化异常"),
    SYS_CHARSET_UNSUPPORTED_ERROR("E001004","字符集类型不支持"),
    
    CODE_ENCODE_ERROR("E002001","编码异常"), 
    CODE_DECODE_ERROR("E002002","解码异常"),
    CODE_BASE64_ENCODE_ERROR("E002003","base64编码异常"), 
    CODE_BASE64_DECODE_ERROR("E002004","base64解码异常"),
    CODE_MD5_ERROR("E001005","md5加密异常"),
    
    SIGN_SIGNATURE_ERROR("E003001","签名异常"),
    SIGN_TYPE_NOT_EXIST_ERROR("E003002","签名类型不存在"),
    SIGN_RSA_PRIKEY_GET_ERROR("E003003","获取RSA私钥异常"),
    SIGN_RSA_PRIKEY_FORMATTER_ERROR("E003004","RSA私钥格式不正确"),
    SIGN_RSA_PRIKEY_INVALID_ERROR("E003005","RSA私钥无效"),
    SIGN_RSA_CONTENT_GET_ERROR("E003006","待签名内容组装异常"),
    SIGN_RSA_PARAM_FILTER_ERROR("E003007","过滤待签名参数异常"),
    
    VERIFY_SIGNATURE_ERROR("E004001","验签异常"),
    VERIFY_TYPE_NOT_EXIST_ERROR("E004002","签名类型不存在"),
    VERIFY_RSA_PUBKEY_GET_ERROR("E004003","获取RSA公钥异常"),
    VERIFY_RSA_PUBKEY_FORMATTER_ERROR("E004004","RSA公钥格式不正确"),
    VERIFY_RSA_PUBKEY_INVALID_ERROR("E004005","RSA公钥无效"),
    VERIFY_RSA_CONTENT_GET_ERROR("E004006","待验签内容组装异常"),
    VERIFY_RSA_PARAM_FILTER_ERROR("E004007","过滤待验签参数异常");
	
    private String code;

    private String msg;

    EncryptCommonError(String code, String msg) {
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
