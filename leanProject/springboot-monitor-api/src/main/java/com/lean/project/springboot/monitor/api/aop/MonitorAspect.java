
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

import com.alibaba.fastjson.JSON;
import com.lean.project.springboot.monitor.api.config.MonitorTool;
import com.lean.project.springboot.monitor.api.enums.InfoType;
import com.lean.project.springboot.monitor.api.enums.RecordMode;

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

	@After("monitor()&&@annotation(MonitorAnnotation)")
    public void doAfter() {
        //拦截执行后处理
    }
	
	/**
	 * 
	 * Description：环绕通知 <br/>
	 * Date：2019年1月29日 上午9:44:24　<br/>
	 * Author：lean <br/>
	 * @param proceedingJoinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("monitor()&&@annotation(MonitorAnnotation)")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = null;
        try {
        	long start = System.currentTimeMillis();
        	result = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
            long finish = System.currentTimeMillis();
            long useTime = finish - start;
            monitorCenterDeal(proceedingJoinPoint, InfoType.TIME_OUT, useTime);
		} catch (Throwable e) {
			//处理你的异常.最终直接抛出错误
			monitorCenterDeal(proceedingJoinPoint, InfoType.ERROR, e.getMessage());
			throw e;
		}finally {
			//处理其他业务
		}
        return result;
    }

	/**
	 * 
	 * Description：监控 <br/>
	 * Date：2019年1月28日 上午10:15:58　<br/>
	 * Author：lean <br/>
	 * @param targetClass 接口实现class
     * @param methodName 接口方法
	 * @param errorMsg 异常信息
	 */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	private void monitorCenterDeal(ProceedingJoinPoint proceedingJoinPoint, InfoType infoType, Object info) {
    	try {
    		Object[] args = proceedingJoinPoint.getArgs();
            String methodName = proceedingJoinPoint.getSignature().getName();
            Class targetClass = proceedingJoinPoint.getTarget().getClass();
    		//获取方法
            Class[] classArray = new Class[args.length];
            for(int i = 0; i < args.length ; ++i) classArray[i] = args[i].getClass();
            Method method = targetClass.getMethod(methodName, classArray);
            if(method.isAnnotationPresent(MonitorAnnotation.class)) {
            	//属于MonitorAnnotation注解的进入流程
            	MonitorAnnotation monitorAnnotation = method.getAnnotation(MonitorAnnotation.class);
            	Map<String,Object> params = new HashMap<>();
            	params.put("serviceClass", targetClass.getSimpleName());
            	params.put("method", method.getName());
            	params.put("serverName", isNotEmpty(monitorAnnotation.serverName())?monitorAnnotation.serverName():targetClass.getSimpleName());
            	params.put("methodName", isNotEmpty(monitorAnnotation.methodName())?monitorAnnotation.methodName():method.getName());
            	params.put("recordMode", monitorAnnotation.recordMode().getCode());
            	boolean needSend = false;
            	switch (infoType) {
        		case ERROR:
        			needSend = true;
        			params.put("info",new String("方法执行异常,errorMsg:{"+info+"}"));       	
        			break;
        		case TIME_OUT:
        			long useTime = (long) info;
        			if(useTime >= monitorAnnotation.timeout()) {
                    	needSend = true;
                    	params.put("info",new String("接口超时,settingUseTime:{"+monitorAnnotation.timeout()+"}.useTime:{"+useTime+"}"));       	
                    }
        			break;
        		default:
        			needSend = false;
        			break;
        		}
            	//需要发送消息并且监控中心是可用的则发送
            	if(RecordMode.LOCAL_LOG.equals(monitorAnnotation.recordMode())) {
            		logger.info("监控服务记录:"+JSON.toJSONString(params));
            	}else {
            		if(MonitorTool.isMonitorEnabled() && needSend) {
                		if(isNotEmpty(monitorAnnotation.monitorCenterUrl())) {
                			MonitorTool.sendInfo(monitorAnnotation.monitorCenterUrl(), params);
                		}else {
                			MonitorTool.sendInfo(params);
                		}
                	}
            	}
            }
        } catch(Exception e) {
            /** 监控逻辑处理错误什么都不做 */
        	logger.error("sendInfo exception error:"+e.getMessage());
        }
	}

    /**
     * 
     * Description：是否非空 <br/>
     * Date：2019年1月29日 上午9:56:18　<br/>
     * Author：lean <br/>
     * @param str
     * @return
     */
	private boolean isNotEmpty(String str) {
		if(str != null && !"".equals(str) && str.length() > 0) {
			return true;
		}
		return false;
	}
    
}
