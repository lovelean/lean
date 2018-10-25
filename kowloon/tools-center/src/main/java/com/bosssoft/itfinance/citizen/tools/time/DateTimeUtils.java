package com.bosssoft.itfinance.citizen.tools.time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bosssoft.itfinance.citizen.tools.exception.ToolsCommonError;
import com.bosssoft.itfinance.citizen.tools.exception.ToolsCommonException;

/**
 * 
 * ClassName：com.bosssoft.itfinance.citizen.tools.time.DateTimeUtils　　<br/>
 * Description：时间格式化工具类 <br/>
 * Date：2018年10月24日 上午9:08:50<br/>
 * @author lean
 * @version 1.0
 */
public class DateTimeUtils {

	private final static Logger logger = LoggerFactory.getLogger(DateTimeUtils.class);
	
    /**
     * 
     * Description：获取某个时间间隔前后的时间 <br/>
     * Date：2018年7月4日 下午4:21:26　<br/>
     * Author：lean <br/>
     * @param start 参考时间串
     * @param srcFormat 时间格式
     * @param type 增减类型
     * @param interval 增减量
     * @return
     * @throws ToolsCommonException 
     */
    public static String getTime(String start, String srcFormat, String type, int interval) throws ToolsCommonException{
    	if(start == null || "".equals(start)) start = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        if(srcFormat == null || "".equals(srcFormat)) srcFormat = "yyyyMMddHHmmss";
    	try {
            SimpleDateFormat format = new SimpleDateFormat(srcFormat);
            Date sDate = format.parse(start);
            Calendar calender = Calendar.getInstance();
            calender.setTime(sDate);
            switch (type) {
			case "YEAR":
				calender.add(Calendar.YEAR, interval);
				break;
			case "MONTH":
				calender.add(Calendar.MONTH, interval);
				break;
			case "DATE":
				calender.add(Calendar.DATE, interval);
				break;
			default:
				calender.add(Calendar.DATE, interval);
				break;
			}
            return format.format(calender.getTime());
        }catch (Exception e){
        	logger.error("error:"+e.getMessage());
        	throw new ToolsCommonException(ToolsCommonError.SYS_FORMAT_DATETIME_ERROR);
        }
    }
    
    /**
     * 
     * Description：获取日期 <br/>
     * Date：2018年10月24日 上午9:34:26　<br/>
     * Author：lean <br/>
     * @param startDate 开始时间
     * @param interval 0 今天；正数n：延迟n天，负数n：提前n天
     * @return 延迟后日期
     * @throws ToolsCommonException 
     */
    public static String getDay(String startDate,int interval) throws ToolsCommonException{
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            Date sDate = format.parse(startDate);
            Calendar calender = Calendar.getInstance();
            calender.setTime(sDate);
            calender.add(Calendar.DATE, interval);
            return format.format(calender.getTime());
        }catch (Exception e){
        	logger.error("error:"+e.getMessage());
            throw new ToolsCommonException(ToolsCommonError.SYS_FORMAT_DATETIME_ERROR);
        }
    }

    /**
     * 
     * Description：获取间隔时间 <br/>
     * Date：2018年10月24日 上午9:34:39　<br/>
     * Author：lean <br/>
     * @param startDate yyyyMMdd
     * @param endDate yyyyMMdd
     * @return
     * @throws ToolsCommonException 
     */
    public static int getIntervalDays(String startDate,String endDate) throws ToolsCommonException{
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
            Date sDate = df.parse(startDate);
            Date eDate = df.parse(endDate);
            Long betweenDays = (eDate.getTime()-sDate.getTime())/ (1000 * 60 * 60 *24);
            return betweenDays.intValue();
        }catch (Exception e){
        	logger.error("error:"+e.getMessage());
        	throw new ToolsCommonException(ToolsCommonError.SYS_FORMAT_DATETIME_ERROR);
        }
    }

    /**
     * 
     * Description：获取时间 <br/>
     * Date：2018年10月24日 上午9:34:53　<br/>
     * Author：lean <br/>
     * @param srcFormat yyyy-MM-dd HH:mm:ss
     * @param interval 0 今天；正数n：延迟n天，负数n：提前n天
     * @return 延迟后时间
     * @throws ToolsCommonException 
     */
    public static String getTime(String srcFormat,int interval) throws ToolsCommonException{
        try {
	    	Calendar calender = Calendar.getInstance();
	        calender.add(Calendar.DATE, interval);
	        SimpleDateFormat format = new SimpleDateFormat(srcFormat); // HH一定要大写，小写的话，变成12小时日期制
	        String datetime = format.format(calender.getTime());
	        return datetime;
        }catch (Exception e){
        	logger.error("error:"+e.getMessage());
        	throw new ToolsCommonException(ToolsCommonError.SYS_FORMAT_DATETIME_ERROR);
        }
    }

    /**
     * 
     * Description： 格式化时间 <br/>
     * Date：2018年10月24日 上午9:33:21　<br/>
     * Author：lean <br/>
     * @param time 时间字符
     * @param srcFormat 原格式：yyyyMMddHHmmss
     * @param aimFormat 目标格式：yyyy-MM-dd HH:mm:ss
     * @return 格式化完的时间
     * @throws ToolsCommonException 
     */
    public static String formatTime(String time,String srcFormat,String aimFormat) throws ToolsCommonException{
        try {
            SimpleDateFormat sdfa = new SimpleDateFormat(aimFormat);
            SimpleDateFormat sdfs = new SimpleDateFormat(srcFormat);
            return sdfa.format(sdfs.parse(time));
        }catch (Exception e) {
        	logger.error("error:"+e.getMessage());
        	throw new ToolsCommonException(ToolsCommonError.SYS_FORMAT_DATETIME_ERROR);
        }
    }

    /**
     * 
     * Description：获取当前时间 <br/>
     * Date：2018年10月24日 上午9:33:02　<br/>
     * Author：lean <br/>
     * @return yyyyMMddHHmmss
     * @throws ToolsCommonException 
     */
    public static String getNowDateTime() throws ToolsCommonException{
        try {
	    	Date date=new Date();
	        DateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
	        return format.format(date);
        }catch (Exception e){
        	logger.error("error:"+e.getMessage());
        	throw new ToolsCommonException(ToolsCommonError.SYS_FORMAT_DATETIME_ERROR);
        }
    }

    /**
     * 
     * Description：获取当前日期 <br/>
     * Date：2018年10月24日 上午9:32:53　<br/>
     * Author：lean <br/>
     * @return yyyyMMdd
     * @throws ToolsCommonException 
     */
    public static String getNowDate() throws ToolsCommonException{
        try {
	    	Date date=new Date();
	        DateFormat format=new SimpleDateFormat("yyyyMMdd");
	        return format.format(date);
        }catch (Exception e){
        	logger.error("error:"+e.getMessage());
        	throw new ToolsCommonException(ToolsCommonError.SYS_FORMAT_DATETIME_ERROR);
        }
    }

    /**
     * 
     * Description：获取当前时间 <br/>
     * Date：2018年10月24日 上午9:32:42　<br/>
     * Author：lean <br/>
     * @return HHmmss
     * @throws ToolsCommonException 
     */
    public static String getNowTime() throws ToolsCommonException{
        try {
	    	Date date=new Date();
	        DateFormat format=new SimpleDateFormat("HHmmss");
	        return format.format(date);
        }catch (Exception e){
        	logger.error("error:"+e.getMessage());
        	throw new ToolsCommonException(ToolsCommonError.SYS_FORMAT_DATETIME_ERROR);
        }
    }
    
    public static void main(String[] args) {

    }
}
