package com.kowloon.tools.threadpool.test;

import com.kowloon.tools.threadpool.ThreadPoolManager;

/**
 * 
 * ClassName：com.kowloon.tools.threadpool.test.ThreadPoolTest2　　<br/>
 * Description：<br/>
 * Date：2019年3月5日 下午4:52:27<br/>
 * @author lean
 * @version 1.0
 */
public class ThreadPoolTest2 {
	
	public static void main(String[] args) {
		try {
			long start = System.currentTimeMillis();
	        // 发送10次消息
	        for (int i = 0; i < 10; i++) {
	            try {
	            	ThreadPoolManager.initThreadPoolConfig(5, 10, 60, 10);
	            	final int index = i;
	                ThreadPoolManager.execute(new Runnable() {
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
