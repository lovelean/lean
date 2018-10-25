package com.bosssoft.itfinance.citizen.tools.verify;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * ClassName：com.bosssoft.itfinance.citizen.tools.verify.Check　　<br/>
 * Description：注解校验 <br/>
 * Date：2018年10月24日 上午9:39:17<br/>
 * @author lean
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Check {

    /** 是否必填 */
    boolean required();

    /** 描述  */
    String name();

    /** 校验类型 */
    CheckType type() default CheckType.DEFAULT;

    /** 最小长度 */
    int minLength() default 0;

    /** 最大长度 */
    int maxLength() default 0;

    /** 长度 */
    int length() default 0;

}
