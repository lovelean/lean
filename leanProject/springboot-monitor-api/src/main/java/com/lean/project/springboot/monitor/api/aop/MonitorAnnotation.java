
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

import com.lean.project.springboot.monitor.api.enums.RecordMode;

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
	 * Description：服务名称 <br/>
	 * Date：2019年1月28日 下午4:32:57　<br/>
	 * Author：lean <br/>
	 * @return 服务名称,为空则用类名
	 */
	String serverName() default "";
	
	/**
	 * 
	 * Description：方法名称 <br/>
	 * Date：2019年1月28日 下午4:33:21　<br/>
	 * Author：lean <br/>
	 * @return 方法名称,为空则用方法名
	 */
	String methodName() default "";
	
	/**
	 * 
	 * Description：监控中心服务地址 <br/>
	 * Date：2019年1月28日 下午4:30:06　<br/>
	 * Author：lean <br/>
	 * @return 监控中心服务地址,为空则用全局的地址
	 */
	String monitorCenterUrl() default "";
	
	/**
	 * 
	 * Description： 记录模式 <br/>
	 * Date：2019年1月29日 上午10:23:20　<br/>
	 * Author：lean <br/>
	 * @return 记录消息的模式,默认本地记录
	 */
	RecordMode recordMode() default RecordMode.LOCAL_LOG;

	/**
	 * 
	 * Description：接口超时时间[毫秒] <br/>
	 * Date：2019年1月25日 下午3:37:18　<br/>
	 * Author：lean <br/>
	 * @return 设置的超时时间,默认值5000毫秒
	 */
    int timeout() default 5000;
 
    /**
     * 
     * Description：当接口响应超时时,是否需要处理. <br/>
     * Date：2019年1月25日 下午3:37:33　<br/>
     * Author：lean <br/>
     * @return 返回ture需要处理,默认处理
     */
    boolean dealIfTimeout() default true;
}
