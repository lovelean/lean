package com.kowloon.tools.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.kowloon.tools.threadpool.config.ThreadPoolConfig;

/**
 * 
 * ClassName：com.kowloon.tools.redis.ThreadPoolTools　　<br/>
 * Description：线程池管理器(单例)<br/>
 * Date：2019年3月5日 下午2:18:51<br/>
 * @author lean
 * @version 1.0
 */
public class ThreadPoolManager {
	
	//线程池单例对象
	public static ThreadPoolExecutor threadPool;
	//线程池配置对象
	private static ThreadPoolConfig threadPoolConfig = new ThreadPoolConfig();
	
	/**
	 * 
	 * Description：无返回值直接执行 <br/>
	 * Date：2019年3月5日 下午2:38:13　<br/>
	 * Author：lean <br/>
	 * @param runnable
	 */
    public static void execute(Runnable runnable){
    	getThreadPoolExecutor().execute(runnable);
    }
    
    /**
     * 
     * Description：返回值直接执行 <br/>
     * Date：2019年3月5日 下午2:38:23　<br/>
     * Author：lean <br/>
     * @param callable
     * @return
     */
    public  static <T> Future<T> submit(Callable<T> callable){
    	return getThreadPoolExecutor().submit(callable);
    }

    /**
     * 
     * Description：获取线程池对象,单例 <br/>
     * Date：2019年3月5日 下午2:37:38　<br/>
     * Author：lean <br/>
     * @return
     */
    public static ThreadPoolExecutor getThreadPoolExecutor() {
        if (threadPool != null) {
            return threadPool;
        } else {
            synchronized (ThreadPoolManager.class) {
            	//防止进来后又一次构建所以再判断一次
            	if (threadPool == null) {
                    threadPool = new ThreadPoolExecutor(threadPoolConfig.getCorePoolSize(), 
                    			threadPoolConfig.getMaximumPoolSize(), 
                    			threadPoolConfig.getKeepAliveTime(), 
                    			TimeUnit.SECONDS,
                            	new LinkedBlockingQueue<>(threadPoolConfig.getQueueCapacity()), 
                            	new ThreadPoolExecutor.AbortPolicy()
                    		);
                }
                return threadPool;
            }
        }
    }
    
    /**
     * 
     * Description： 初始化线程池配置 <br/>
     * Date：2019年3月5日 下午3:25:10　<br/>
     * Author：lean <br/>
     * @param setThreadPoolConfig
     */
    public static void initThreadPoolConfig(ThreadPoolConfig setThreadPoolConfig) {
    	threadPoolConfig = setThreadPoolConfig;
    }
    
    /**
     * 
     * Description：初始化线程池配置 <br/>
     * Date：2019年3月5日 下午3:26:55　<br/>
     * Author：lean <br/>
     * @param corePoolSize 核心线程数
     * @param maximumPoolSize 最大线程数
     * @param keepAliveTime 非核心线程空闲等待新任务的最长时间.秒
     * @param queueCapacity 堵塞队列容量
     */
    public static void initThreadPoolConfig(int corePoolSize, int maximumPoolSize, long keepAliveTime, int queueCapacity) {
    	threadPoolConfig.setCorePoolSize(corePoolSize);
    	threadPoolConfig.setKeepAliveTime(keepAliveTime);
    	threadPoolConfig.setMaximumPoolSize(maximumPoolSize);
    	threadPoolConfig.setQueueCapacity(queueCapacity);
    }
}
