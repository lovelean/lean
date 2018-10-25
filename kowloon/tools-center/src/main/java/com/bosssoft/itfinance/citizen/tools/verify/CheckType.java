package com.bosssoft.itfinance.citizen.tools.verify;

/**
 * 
 * ClassName：com.bosssoft.itfinance.citizen.tools.verify.CheckType　　<br/>
 * Description：校验类型<br/>
 * Date：2018年10月24日 上午9:40:34<br/>
 * @author lean
 * @version 1.0
 */
public enum CheckType {
    /** 默认*/
    DEFAULT,
    /** 枚举*/
    ENUM,
    /** 电子邮箱*/
    EMAIL,
    /** 手机号*/
    PHONE,
    /** 邮编*/
    ZIPCODE,
    /** 密码*/
    PASSWORD,
    /** 正数*/
    POSITIVE,
    /** 日期(yyyyMMdd)*/
    DATE,
    /** 时间(HHmmss)*/
    TIME,
    /** 日期时间(yyyyMMddHHmmss)*/
    DATETIME
}
