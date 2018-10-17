package com.lean.project.springboot.consumer.basic.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * ClassName：com.lean.project.springboot.consumer.basic.config.BootConsumerConfig　　<br/>
 * Description：基础配置 <br/>
 * Date：2018年9月29日 下午5:14:46<br/>
 * @author lean
 * @version 1.0
 */
@Component
public class BootConsumerConfig {
	
    /** 版本号*/
	@Value("${boot.consumer.version}")
    private String version;

    /** 字符集*/
	@Value("${boot.consumer.encoding}")
    private String encoding;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
}
