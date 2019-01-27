
/**   
 * Title：MonitorAnnotation.java 　<br/>
 * Package：com.lean.project.springboot.monitor.api.aop 　<br/>
 * Description：<br/>
 * Data：2019年1月25日 下午3:36:43<br/>
 * @author lean
 * @copyright  Corporation 2019    
 * @version v1.0 
 */
package com.lean.project.springboot.monitor.api.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * ClassName：com.lean.project.springboot.monitor.api.aop.MonitorAnnotation　　<br/>
 * Description：监控器注解 <br/>
 * Date：2019年1月27日 下午4:18:32<br/>
 * @author lean
 * @version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MonitorAnnotation {

	/**
	 * 
	 * Description：接口超时时间,单位毫秒.默认值100毫秒 <br/>
	 * Date：2019年1月25日 下午3:37:18　<br/>
	 * Author：lean <br/>
	 * @return 设置的超时时间
	 */
    int timeout() default 400;
 
    /**
     * 
     * Description：当接口响应超时时,是否需要处理.默认处理 <br/>
     * Date：2019年1月25日 下午3:37:33　<br/>
     * Author：lean <br/>
     * @return 返回ture需要发送邮件
     */
    boolean dealIfTimeout() default true;
}
