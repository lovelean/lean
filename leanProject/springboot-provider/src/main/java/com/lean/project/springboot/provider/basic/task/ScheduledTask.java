package com.lean.project.springboot.provider.basic.task;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * ClassName：com.bosssoft.itfinance.citizen.wallet.demo.basic.task.ScheduledTask　　<br/>
 * Description：定时任务类 <br/>
 * Date：2018年9月27日 下午4:13:07<br/>
 * @author lean
 * @version 1.0
 */
@Component
@Slf4j
public class ScheduledTask {
	
	/**
	 * 
	 * Description：自动扫描 <br/>
	 * Date：2018年8月22日 下午5:52:57　<br/>
	 * Author：lean <br/>
	 */
	@Async("scheduledPoolTaskExecutor")
	@Scheduled(cron="${boot.provider.cron}")
	public void autoSettleTask (){
		log.info("定时任务执行开始:" + getNowDateTime());
		log.info("定时任务执行结束:" + getNowDateTime());
	}
	
	public static String getNowDateTime(){
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
        return format.format(date);
    }
}
