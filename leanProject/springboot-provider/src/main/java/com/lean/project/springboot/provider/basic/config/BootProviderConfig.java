package com.lean.project.springboot.provider.basic.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * ClassName：com.lean.project.springboot.provide.basic.config.BootProviderConfig　　<br/>
 * Description：基础配置 <br/>
 * Date：2018年9月27日 下午5:32:45<br/>
 * @author lean
 * @version 1.0
 */
@Component
public class BootProviderConfig {
	
    /** 版本号*/
	@Value("${boot.provider.version}")
    private String version;

    /** 字符集*/
	@Value("${boot.provider.encoding}")
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
