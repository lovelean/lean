package com.kowloon.tools.threadpool.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import com.kowloon.tools.threadpool.ThreadPoolManager;
import com.kowloon.tools.threadpool.callable.BaseCallable;

/**
 * 
 * ClassName：com.kowloon.tools.threadpool.test.ThreadPoolTest　　<br/>
 * Description：<br/>
 * Date：2019年3月5日 下午2:20:10<br/>
 * @author lean
 * @version 1.0
 */
public class ThreadPoolTest {
	
	public static void main(String[] args) {
		try {
			long start = System.currentTimeMillis();
			List<Future<String>> futureList = new ArrayList<Future<String>>();
	        // 发送10次消息
	        for (int i = 0; i < 10; i++) {
	            try {
	            	ThreadPoolManager.initThreadPoolConfig(5, 10, 60, 10);
	                Future<String> messageFuture = ThreadPoolManager.submit(new BaseCallable(String.format("一轮第{%s}条消息", i)));
	                futureList.add(messageFuture);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        
	        for (Future<String> message : futureList) {
	            System.out.println(message.get());
	        }
	        System.out.println(String.format("共计耗时{%s}毫秒", System.currentTimeMillis() - start));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
