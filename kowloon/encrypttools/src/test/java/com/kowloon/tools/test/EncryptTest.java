
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

/**
 * 
 * ClassName：com.kowloon.tools.test.EncryptTest　　<br/>
 * Description：<br/>
 * Date：2018年8月28日 下午4:24:34<br/>
 * @author lean
 * @version 1.0
 */
public class EncryptTest {

	/** 
	 * Description： <br/>
	 * Date：2018年7月26日 下午3:41:17　<br/>
	 * Author：lean <br/>
	 * @param args
	 */
	public static void main(String[] args) {
		
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
