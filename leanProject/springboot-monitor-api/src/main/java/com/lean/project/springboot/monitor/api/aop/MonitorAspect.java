
/**   
 * Title：MonitorAspect.java 　<br/>
 * Package：com.lean.project.springboot.monitor.api.aop 　<br/>
 * Description：<br/>
 * Data：2019年1月25日 下午3:39:41<br/>
 * @author lean
 * @copyright  Corporation 2019    
 * @version v1.0 
 */
package com.lean.project.springboot.monitor.api.aop;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.lean.project.springboot.monitor.api.config.MonitorConfig;
import com.lean.project.springboot.monitor.api.httpclient.HttpClientTool;

/**
 * 
 * ClassName：com.lean.project.springboot.monitor.api.aop.MonitorAspect　　<br/>
 * Description：监控器切点类 <br/>
 * Date：2019年1月27日 下午4:18:50<br/>
 * @author lean
 * @version 1.0
 */
@Aspect
@Component
public class MonitorAspect {

	private final Logger logger = LoggerFactory.getLogger(MonitorAspect.class);
	
	@Pointcut("@annotation(MonitorAnnotation)")
    public void monitor() {
    }

	@Before("monitor()&&@annotation(MonitorAnnotation)")
	public void doBefore(JoinPoint joinPoint) {
		//拦截执行前处理
	}
	
    @Around("monitor()&&@annotation(MonitorAnnotation)")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) {
        Object result = null;
        try {
        	Object[] args = proceedingJoinPoint.getArgs();
        	long start = System.currentTimeMillis();
        	result = proceedingJoinPoint.proceed(args);
            long finish = System.currentTimeMillis();
            long useTime = finish - start;
            /** 接口响应时间监控 */
            interfaceUseTimeMonitor(proceedingJoinPoint.getTarget().getClass(), proceedingJoinPoint.getSignature().getName(), args, useTime);
		} catch (Throwable e) {
			//处理你的异常
			logger.info("出异常了:"+e.getMessage());
		}finally {
			//处理其他
			logger.info("其他业务处理");
		}
        return result;
    }

    @After("monitor()&&@annotation(MonitorAnnotation)")
    public void doAfter() {
        //拦截后的逻辑
    }
    
    /**
     * 
     * Description：接口响应时间监控  <br/>
     * Date：2019年1月25日 下午3:58:09　<br/>
     * Author：lean <br/>
     * @param targetClass 接口实现class
     * @param methodName 接口方法
     * @param args 接口入参
     * @param useTime 调用接口实际使用时间
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	private void interfaceUseTimeMonitor(Class targetClass, String methodName, Object[] args, long useTime) {
    	logger.info("与接口注解最高用时做比较,符合条件做处理。usertime==="+useTime);
        try {
            Class[] classArray = new Class[args.length];
            for(int i = 0; i < args.length ; ++i) {
                classArray[i] = args[i].getClass();
            }
            Method method = targetClass.getMethod(methodName, classArray);
            if(method.isAnnotationPresent(MonitorAnnotation.class)) {
            	MonitorAnnotation monitorAnnotation = method.getAnnotation(MonitorAnnotation.class);
                if(useTime >= monitorAnnotation.timeout()) {
                	logger.info(new String("接口超时,interface:[{"+targetClass.getSimpleName() + "." + methodName+"}].useTime:[{"+useTime+"}].settingUseTime:[{"+monitorAnnotation.timeout()+"}]"));
                	Map<String,Object> params = new HashMap<>();
                	params.put("version","1.0.0");   
                	params.put("info",new String("接口超时,interface:[{"+targetClass.getSimpleName() + "." + methodName+"}].useTime:[{"+useTime+"}].settingUseTime:[{"+monitorAnnotation.timeout()+"}]"));       	
                	try {
                		String result = HttpClientTool.sendForm(MonitorConfig.monitorCenterUrl, params);
                    	logger.info(result);
					} catch (Exception e) {
						logger.error("post error:"+e.getMessage());
					}
                }
            }
        } catch(Throwable e) {
            /** 监控逻辑处理错误什么都不做 */
        }
    }
}
