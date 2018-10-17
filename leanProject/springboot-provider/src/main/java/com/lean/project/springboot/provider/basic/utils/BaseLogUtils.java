/**
 *
 * Licensed Property to China UnionPay Co., Ltd.
 * 
 * (C) Copyright of China UnionPay Co., Ltd. 2010
 *     All Rights Reserved.
 *
 * 
 * Modification History:
 * =============================================================================
 *   Author         Date          Description
 *   ------------ ---------- ---------------------------------------------------
 *   xshu       2014-05-28       日志打印工具类
 * =============================================================================
 */
package com.lean.project.springboot.provider.basic.utils;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * ClassName：com.bosssoft.itfinance.citizen.wallet.demo.basic.utils.BaseLogUtils　　<br/>
 * Description：日志工具 <br/>
 * Date：2018年9月27日 下午4:13:32<br/>
 * @author lean
 * @version 1.0
 */
public class BaseLogUtils {

	/**
	 * 
	 * Description：消息日志 <br/>
	 * Date：2018年3月20日 上午11:21:42　<br/>
	 * Author：lean <br/>
	 * @param logId 日志标识
	 * @param moudleName 模块名
	 * @param actionName 动作名
	 * @param object 对象
	 */
	public static String info(String logId, Date begin, String moudleName, String actionName, Object object) {
		return formatString("[{0}][{1}ms][{2}][{3}]:{4}", logId, (new Date().getTime()-begin.getTime()), moudleName, actionName, object);
	}

	/**
	 * 
	 * Description：错误日志 <br/>
	 * Date：2018年3月20日 下午9:26:18　<br/>
	 * Author：lean <br/>
	 * @param logId 日志标识
	 * @param moudleName 模块名
	 * @param actionName 动作名
	 * @param errorCode 错误编码
	 * @param errorMsg 错误信息
	 * @param object 输出对象
	 */
	public static String error(String logId, Date begin, String moudleName, String actionName, String errorCode, String errorMsg, Object object) {
		return formatString("[{0}][{1}ms][{2}][{3}]:{4}-{5}-{6}", logId, (new Date().getTime()-begin.getTime()), moudleName, actionName, errorCode, errorMsg, object);
	}
	
	/**
	 * 
	 * Description： 错误日志<br/>
	 * Date：2018年3月20日 下午9:24:57　<br/>
	 * Author：lean <br/>
	 * @param logId 日志标识
	 * @param moudleName 模块名
	 * @param actionName 动作名
	 * @param errorMsg 错误信息
	 */
	public static String error(String logId, Date begin, String moudleName, String actionName, String errorMsg) {
		return formatString("[{0}][{1}ms][{2}][{3}]:{4}", logId, (new Date().getTime()-begin.getTime()), moudleName, actionName, errorMsg);
	}
	
	/**
	 * 
	 * Description：获取当前时间 <br/>
	 * Date：2018年3月20日 上午11:08:18　<br/>
	 * Author：lean <br/>
	 * @return
	 */
	public static String getNowDateTime(){
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
	
	/**
	 * 
	 * Description：格式化字符串 <br/>
	 * Date：2018年7月26日 下午4:18:59　<br/>
	 * Author：lean <br/>
	 * @param pattern 标准串
	 * @param args 替换值
	 * @return 替换后的值。。替换{0}{1}为指定的字符串 args
	 */
	public static String formatString(String pattern, Object... args) {
		return MessageFormat.format(pattern, args);
	}
}
