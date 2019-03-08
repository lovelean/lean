
/**   
 * Title：ThreadPoolConfig.java 　<br/>
 * Package：com.kowloon.tools.threadpool.config 　<br/>
 * Description：<br/>
 * Data：2019年3月5日 下午2:41:33<br/>
 * @author lean
 * @copyright  Corporation 2019    
 * @version v1.0 
 */
package com.kowloon.tools.threadpool.config;


/**
 * ClassName：com.kowloon.tools.threadpool.config.ThreadPoolConfig　　<br/>
 * Description：<br/>
 * Date：2019年3月5日 下午2:41:33<br/>
 * @author lean
 * @version 1.0
 */
public class ThreadPoolConfig {

	//核心线程数
	private int corePoolSize = 10;
	
	//最大线程数
	private int maximumPoolSize = Integer.MAX_VALUE;
	
	//非核心线程空闲等待新任务的最长时间.秒
	private long keepAliveTime = 60;
	
	//堵塞队列容量
	private int queueCapacity = Integer.MAX_VALUE;

	public int getCorePoolSize() {
		return corePoolSize;
	}

	public void setCorePoolSize(int corePoolSize) {
		this.corePoolSize = corePoolSize;
	}

	public int getMaximumPoolSize() {
		return maximumPoolSize;
	}

	public void setMaximumPoolSize(int maximumPoolSize) {
		this.maximumPoolSize = maximumPoolSize;
	}

	public long getKeepAliveTime() {
		return keepAliveTime;
	}

	public void setKeepAliveTime(long keepAliveTime) {
		this.keepAliveTime = keepAliveTime;
	}

	public int getQueueCapacity() {
		return queueCapacity;
	}

	public void setQueueCapacity(int queueCapacity) {
		this.queueCapacity = queueCapacity;
	}
}
