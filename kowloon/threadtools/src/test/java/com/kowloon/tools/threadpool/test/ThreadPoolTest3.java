package com.kowloon.tools.threadpool.test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 
 * ClassName：com.kowloon.tools.threadpool.test.ThreadPoolTest2　　<br/>
 * Description：<br/>
 * Date：2019年3月5日 下午4:52:27<br/>
 * @author lean
 * @version 1.0
 */
public class ThreadPoolTest3 {
	
	public static void main(String[] args) {
		try {
			ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 
        			10, 
        			60, 
        			TimeUnit.SECONDS,
                	new LinkedBlockingQueue<>(10), 
                	new ThreadPoolExecutor.AbortPolicy()
        		);
			
			long start = System.currentTimeMillis();
	        // 发送10次消息
	        for (int i = 0; i < 10; i++) {
	            try {
	            	final int index = i;
	            	threadPool.execute(new Runnable() {
						@Override
						public void run() {
							System.out.println(String.format("打印消息%s", index));
						}
					});
	                System.out.println("第"+i+"条");
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        System.out.println(String.format("共计耗时{%s}毫秒", System.currentTimeMillis() - start));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
