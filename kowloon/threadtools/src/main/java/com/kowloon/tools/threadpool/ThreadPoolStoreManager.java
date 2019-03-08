package com.kowloon.tools.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
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
public class ThreadPoolStoreManager {
	
	//线程池集合
	public static ConcurrentMap<String, ThreadPoolExecutor> threadPoolStore = new ConcurrentHashMap<>();
	//线程池配置对象
	private static ThreadPoolConfig threadPoolConfig = new ThreadPoolConfig();
	
	/**
	 * 
	 * Description：无返回值直接执行 <br/>
	 * Date：2019年3月5日 下午3:29:57　<br/>
	 * Author：lean <br/>
	 * @param key
	 * @param runnable
	 */
    public static void execute(String key, Runnable runnable) {
    	getThreadPoolExecutor(key).execute(runnable);
    }
    
    /**
     * 
     * Description：返回值直接执行 <br/>
     * Date：2019年3月5日 下午3:30:32　<br/>
     * Author：lean <br/>
     * @param key
     * @param callable
     * @return
     */
    public  static <T> Future<T> submit(String key, Callable<T> callable){
    	return getThreadPoolExecutor(key).submit(callable);
    }

    /**
     * 
     * Description：获取线程池对象 <br/>
     * Date：2019年3月5日 下午3:14:19　<br/>
     * Author：lean <br/>
     * @param key
     * @return
     */
    public static ThreadPoolExecutor getThreadPoolExecutor(String key) {
    	if(threadPoolStore.get(key) == null) {
    		synchronized (ThreadPoolStoreManager.class) {
    			//防止进来后又一次构建所以再判断一次
        		if(threadPoolStore.get(key) == null) {
        			ThreadPoolExecutor newThreadPoolExecutor = new ThreadPoolExecutor(threadPoolConfig.getCorePoolSize(), 
                			threadPoolConfig.getMaximumPoolSize(), 
                			threadPoolConfig.getKeepAliveTime(), 
                			TimeUnit.SECONDS,
                        	new LinkedBlockingQueue<>(threadPoolConfig.getQueueCapacity()), 
                        	new ThreadPoolExecutor.AbortPolicy()
                		);
        			threadPoolStore.put(key, newThreadPoolExecutor);
        			return newThreadPoolExecutor;
        		}else {
        			return threadPoolStore.get(key);
        		}
            }
    	}else {
    		return threadPoolStore.get(key);
    	}
    }
}
