
/**   
 * Title：ExecutorsCommon.java 　<br/>
 * Package：com.bosssoft.itfinance.citizen.channel.monitor.api.threadpool 　<br/>
 * Description：<br/>
 * Data：2019年3月5日 上午10:47:07<br/>
 * @author lean
 * @copyright  Corporation 2019    
 * @version v1.0 
 */
package com.kowloon.tools.threadpool.common;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 
 * ClassName：com.kowloon.tools.threadpool.common.ExecutorsCommon　　<br/>
 * Description：<br/>
 * Date：2019年3月5日 下午2:25:37<br/>
 * @author lean
 * @version 1.0
 */
public class ExecutorsCommon {

	/**
	 * 
	 * Description：默认线程池 <br/>
	 * Date：2019年3月5日 下午2:04:50　<br/>
	 * Author：lean <br/>
	 * @param corePoolSize
	 * @return
	 */
	public static ExecutorService newFixedThreadPool(int corePoolSize) {
		return new ThreadPoolExecutor(corePoolSize, corePoolSize, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
	}
	
	/**
	 * 
	 * Description： 默认线程池<br/>
	 * Date：2019年3月5日 下午2:04:21　<br/>
	 * Author：lean <br/>
	 * @param corePoolSize 核心线程数
	 * @param queueCapacity 堵塞队列容量
	 * @return
	 */
	public static ExecutorService newFixedThreadPool(int corePoolSize, int queueCapacity) {
		return new ThreadPoolExecutor(corePoolSize, corePoolSize, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(queueCapacity));
	}
	
	/**
	 * 
	 * Description：自定义线程池(任意的BlockingQueue) <br/>
	 * Date：2019年3月5日 上午10:55:18　<br/>
	 * Author：lean <br/>
	 * @param corePoolSize 核心线程数
	 * @param maximumPoolSize 最大线程数
	 * @param keepAliveTime 线程空闲时间.单位秒
	 * @return
	 */
	public static LinkedBqThreadPool newLinkedBqThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime) {
		return new LinkedBqThreadPool(corePoolSize, maximumPoolSize, keepAliveTime);
	}
	
	/**
	 * 
	 * Description：自定义线程池(ArrayBlockingQueue) <br/>
	 * Date：2019年3月5日 上午11:48:57　<br/>
	 * Author：lean <br/>
	 * @param corePoolSize 核心线程数
	 * @param maximumPoolSize 最大线程数
	 * @param keepAliveTime 线程空闲时间.单位秒
	 * @param queueCapacity 堵塞队列容量
	 * @return
	 */
	public static ArrayBqThreadPool newArrayBqThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, int queueCapacity) {
		return new ArrayBqThreadPool(corePoolSize, maximumPoolSize, keepAliveTime, queueCapacity);
	}
}
