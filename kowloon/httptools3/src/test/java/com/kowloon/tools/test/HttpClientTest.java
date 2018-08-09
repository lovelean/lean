
/**   
 * Title：HttpClientTest.java 　<br/>
 * Package：com.kowloon.tools.test 　<br/>
 * Description：<br/>
 * Data：2018年7月26日 下午3:41:17<br/>
 * @author lean
 * @copyright  Corporation 2018    
 * @version v1.0 
 */
package com.kowloon.tools.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.kowloon.tools.httpclient3.entity.HttpResp;
import com.kowloon.tools.httpclient3.exception.HttpCommonException;
import com.kowloon.tools.httpclient3.main.HttpClientTools;

/**
 * ClassName：com.kowloon.tools.test.HttpClientTest　　<br/>
 * Description：<br/>
 * Date：2018年7月26日 下午3:41:17<br/>
 * @author lean
 * @version 1.0
 */
public class HttpClientTest {

	/** 
	 * Description： <br/>
	 * Date：2018年7月26日 下午3:41:17　<br/>
	 * Author：lean <br/>
	 * @param args
	 */
	public static void main(String[] args) {
		//域名cdn 10秒会掐断一次，导致请求重发3次，第3次失败抛Connection reset ip则不会重试，直接返回read time out
		String url = "http://testbs.ggjfw.com/channel-gateway/inner/method/testTimeOut.do";
		Map<String, String> map = new HashMap<String, String>();
		map.put("timeout", "10000");
		System.out.println("准备发请求:"+getNowDateTime());
		try {
			HttpResp httpResp = HttpClientTools.sendPost(url, map);
			System.out.println("收到响应:"+getNowDateTime());
			if (httpResp != null && httpResp.isSuccess()){
				System.out.println(getNowDateTime());
				System.out.println("成功了");
			}else{
				System.out.println(getNowDateTime());
				System.out.println("失败了");
			}
		} catch (HttpCommonException e) {
			System.out.println(e.getCode()+"-"+e.getMsg());
		}
	}

	/**
     * 获取当前时间
     * @return yyyyMMddHHmmss
     */
    public static String getNowDateTime(){
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
        return format.format(date);
    }
}
