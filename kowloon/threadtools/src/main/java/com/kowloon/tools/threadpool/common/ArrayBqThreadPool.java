package com.kowloon.tools.threadpool.common;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;

/**
 * 
 * ClassName：com.kowloon.tools.threadpool.common.ArrayBqThreadPool　　<br/>
 * Description：<br/>
 * Date：2019年3月5日 下午2:20:50<br/>
 * @author lean
 * @version 1.0
 */
public class ArrayBqThreadPool extends ThreadPoolExecutor {

	protected Logger logger = Logger.getLogger(ArrayBqThreadPool.class);
	
    //待执行任务数量
    private AtomicInteger taskNum = new AtomicInteger(0);

    /**
     * 
     * <p>Description：构造函数</p>
     * @param corePoolSize 池中所保存的核心线程数
     * @param maximumPoolSize 池中允许的最大线程数
     * @param keepActiveTime 非核心线程空闲等待新任务的最长时间(单位：秒)
     * @param queueCapacity 队列容量，即等待执行任务数
     */
    public ArrayBqThreadPool(int corePoolSize, int maximumPoolSize, long keepActiveTime, int queueCapacity) {
        super(corePoolSize, maximumPoolSize, keepActiveTime, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(queueCapacity));
    }
    
    /**
     * 
     * <p>Description：构造函数(单线程的线程池)</p>
     * @param queueCapacity
     */
    public ArrayBqThreadPool(int queueCapacity) {
        this(1, 1, 1, queueCapacity);
    }
    
    /**
     * 任务执行，以原子方式将当前值加 1
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
     * 
     * Description：待执行的任务数 <br/>
     * Date：2019年3月5日 上午11:40:58　<br/>
     * Author：lean <br/>
     * @return
     */
    public int getTaskNum() {
        return taskNum.get();
    }

    /**
     * 
     * Description：非核心线程空闲等待新任务的最长时间(单位：秒) <br/>
     * Date：2019年3月5日 上午11:41:04　<br/>
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
