package com.bosssoft.itfinance.citizen.tools.exception;

/**
 * 
 * ClassName：com.bosssoft.itfinance.citizen.tools.exception.ToolsCommonError　　<br/>
 * Description：<br/>
 * Date：2018年10月24日 上午10:13:59<br/>
 * @author lean
 * @version 1.0
 */
public enum ToolsCommonError {

	SYS_INIT_ERROR("T001001", "初始化异常"),
    SYS_("T001002", "已初始化,不能重复初始化"),
    SYS_FORMAT_JSON_ERROR("T001003","JSON格式化异常"),
    SYS_CHARSET_UNSUPPORTED_ERROR("T001004","字符集类型不支持"),
    SYS_FORMAT_DATETIME_ERROR("T001005","日期时间格式化异常"),
    SYS_FORMAT_MONEY_ERROR("T001006","金额格式化异常"),
    
    CODE_ENCODE_ERROR("T002001","编码异常"), 
    CODE_DECODE_ERROR("T002002","解码异常"),
    CODE_BASE64_ENCODE_ERROR("T002003","base64编码异常"), 
    CODE_BASE64_DECODE_ERROR("T002004","base64解码异常"),
    CODE_MD5_ERROR("T001005","md5加密异常"),
    
    SIGN_SIGNATURE_ERROR("T003001","签名异常"),
    SIGN_TYPE_NOT_EXIST_ERROR("T003002","签名类型不存在"),
    SIGN_RSA_PRIKEY_GET_ERROR("T003003","获取RSA私钥异常"),
    SIGN_RSA_PRIKEY_FORMATTER_ERROR("T003004","RSA私钥格式不正确"),
    SIGN_RSA_PRIKEY_INVALID_ERROR("T003005","RSA私钥无效"),
    SIGN_RSA_CONTENT_GET_ERROR("T003006","待签名内容组装异常"),
    SIGN_RSA_PARAM_FILTER_ERROR("T003007","过滤待签名参数异常"),
    
    VERIFY_SIGNATURE_ERROR("T004001","验签异常"),
    VERIFY_TYPE_NOT_EXIST_ERROR("T004002","签名类型不存在"),
    VERIFY_RSA_PUBKEY_GET_ERROR("T004003","获取RSA公钥异常"),
    VERIFY_RSA_PUBKEY_FORMATTER_ERROR("T004004","RSA公钥格式不正确"),
    VERIFY_RSA_PUBKEY_INVALID_ERROR("T004005","RSA公钥无效"),
    VERIFY_RSA_CONTENT_GET_ERROR("T004006","待验签内容组装异常"),
    VERIFY_RSA_PARAM_FILTER_ERROR("T004007","过滤待验签参数异常"),
    
    POJO_MAP_TO_BEAN("T005001","map对象转bean异常"),
    POJO_BEAN_TO_MAP("T005002","bean对象转map异常"),
    POJO_XML_TO_BEAN("T005003","xml对象转bean异常"),
    POJO_BEAN_TO_XML("T005004","bean对象转xml异常"),
    
    CHECK_PARAMS_ERROR("T006001","参数异常,传入参数有误"),
    CHECK_PARAMS_NULL_ERROR("T006002","参数异常,传入参数为空"),
    CHECK_PARAMS_CHECK_ERROR("T006003","参数异常,参数校验失败"),
    CHECK_PARAMS_ATTR_ERROR("T006004","参数异常,属性错误");
	
    private String code;

    private String msg;

    ToolsCommonError(String code, String msg) {
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
