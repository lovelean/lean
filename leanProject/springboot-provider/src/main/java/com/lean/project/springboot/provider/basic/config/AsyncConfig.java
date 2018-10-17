package com.lean.project.springboot.provider.basic.config;

import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 
 * ClassName：com.bosssoft.itfinance.citizen.wallet.demo.basic.config.AsyncConfig　　<br/>
 * Description：<br/>
 * Date：2018年9月27日 下午4:12:25<br/>
 * @author lean
 * @version 1.0
 */
@Configuration
@EnableAsync
@EnableScheduling
public class AsyncConfig {
    
	/**
	 * 
	 * Description： 配置线程池 <br/>
	 * Date：2018年8月22日 下午5:48:10　<br/>
	 * Author：lean <br/>
	 * @return
	 */
	@Bean(name = "scheduledPoolTaskExecutor")
	public ThreadPoolTaskExecutor getAsyncThreadPoolTaskExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(20);
		taskExecutor.setMaxPoolSize(200);
		taskExecutor.setQueueCapacity(25);
		taskExecutor.setKeepAliveSeconds(200);
		taskExecutor.setThreadNamePrefix("boot-provider-Scheduled-");
		// 线程池对拒绝任务（无线程可用）的处理策略，目前只支持AbortPolicy、CallerRunsPolicy；默认为后者
		taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		// 调度器shutdown被调用时等待当前被调度的任务完成
		taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
		// 等待时长
		taskExecutor.setAwaitTerminationSeconds(60);
		taskExecutor.initialize();
		return taskExecutor;
	}
}
