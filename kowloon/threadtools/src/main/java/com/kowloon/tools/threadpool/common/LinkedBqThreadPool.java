
/**   
 * Title：LinkedBqThreadPool.java 　<br/>
 * Package：com.bosssoft.itfinance.citizen.channel.monitor.api.thread 　<br/>
 * Description：<br/>
 * Data：2019年3月5日 上午11:24:57<br/>
 * @author lean
 * @copyright  Corporation 2019    
 * @version v1.0 
 */
package com.kowloon.tools.threadpool.common;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;


/**
 * ClassName：com.bosssoft.itfinance.citizen.channel.monitor.api.thread.LinkedBqThreadPool　　<br/>
 * Description：<br/>
 * Date：2019年3月5日 上午11:24:57<br/>
 * @author lean
 * @version 1.0
 */
public class LinkedBqThreadPool extends ThreadPoolExecutor {

	protected Logger logger = Logger.getLogger(LinkedBqThreadPool.class);
	
	//正在执行任务数量
    private AtomicInteger taskNum = new AtomicInteger(0);
	
	/**
	 * 
	 * <p>Description：构造函数(指定BlockingQueue)</p>
	 * @param corePoolSize 池中所保存的核心线程数
	 * @param maximumPoolSize 池中允许的最大线程数
	 * @param keepActiveTime 非核心线程空闲等待新任务的最长时间
	 * @param timeunit keepActiveTime参数的时间单位
	 * @param blockingqueue 任务队列
	 */
    public LinkedBqThreadPool(int corePoolSize, int maximumPoolSize, long keepActiveTime, TimeUnit timeunit,
            BlockingQueue<Runnable> blockingqueue) {
        super(corePoolSize, maximumPoolSize, keepActiveTime, timeunit, blockingqueue);
    }
    
    /**
	 * 
	 * <p>Description：构造函数(指定BlockingQueue)</p>
	 * @param corePoolSize 池中所保存的核心线程数
	 * @param maximumPoolSize 池中允许的最大线程数
	 * @param keepActiveTime 非核心线程空闲等待新任务的最长时间.单位秒
	 * @param blockingqueue 任务队列
	 */
    public LinkedBqThreadPool(int corePoolSize, int maximumPoolSize, long keepActiveTime, 
            BlockingQueue<Runnable> blockingqueue) {
        this(corePoolSize, maximumPoolSize, keepActiveTime, TimeUnit.SECONDS, blockingqueue);
    }
    
    /**
     * 
     * <p>Description：构造函数(基于已链接节点的、范围任意的BlockingQueue)</p>
     * @param corePoolSize 池中所保存的核心线程数
     * @param maximumPoolSize 池中允许的最大线程数
     * @param keepActiveTime 非核心线程空闲等待新任务的最长时间.单位秒
     */
    public LinkedBqThreadPool(int corePoolSize, int maximumPoolSize, long keepActiveTime) {
        this(corePoolSize, maximumPoolSize, keepActiveTime, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
    }
    
    /**
     * 
     * <p>Description：构造函数(单线程的线程池)</p>
     */
    public LinkedBqThreadPool() {
        this(1, 1, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
    }

    /**
     * 执行
     */
    public void execute(Runnable task) {
        taskNum.getAndIncrement();
        super.execute(task);
    }

    /**
     * 任务执行之后
     */
    public void afterExecute(Runnable task, Throwable throwable) {
        taskNum.decrementAndGet();
        logger.debug("task : " + task.getClass().getSimpleName() 
                +  " completed,Throwable:" + throwable + ",taskNum:" + getTaskNum());
        synchronized(this) {
            notifyAll();
        }
    }
    
    /**
     * 挂起当前线程，直到所有任务执行完成
     */
    public void waitComplete() {
        try {
            synchronized(this){
                while(getTaskNum() > 0){
                    wait(500);
                }
            }
        } catch (InterruptedException e) {
        	logger.error(e + ", taskNum:" + getTaskNum());
        }
    }
    
    /**
     * @return    未执行的任务数
     */
    public int getTaskNum() {
        return taskNum.get();
    }

    /**
     * 
     * Description： 非核心线程空闲等待新任务的最长时间(单位：秒) <br/>
     * Date：2019年3月5日 上午11:34:09　<br/>
     * Author：lean <br/>
     * @param time
     */
    public void setKeepAliveTime(int time) {
        super.setKeepAliveTime(time, TimeUnit.SECONDS);
    }

    /**
     * 池中所保存的核心线程数
     */
    public void setCorePoolSize(int size) {
        super.setCorePoolSize(size);
    }
    
    /**
     * 池中允许的最大线程数
     */
    public void setMaximumPoolSize(int size) {
        super.setMaximumPoolSize(size);
    }
}
