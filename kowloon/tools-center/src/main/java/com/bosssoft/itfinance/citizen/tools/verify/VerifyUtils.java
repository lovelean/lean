package com.bosssoft.itfinance.citizen.tools.verify;

import java.util.regex.Pattern;

/**
 * 
 * ClassName：com.bosssoft.itfinance.citizen.tools.verify.VerifyUtils　　<br/>
 * Description：校验工具类 <br/>
 * Date：2018年10月24日 上午9:35:18<br/>
 * @author lean
 * @version 1.0
 */
public class VerifyUtils {

    /**
     * 正则表达式：只能输入数字
     */
    private static final String REGEX_NUMBER = "^\\d+$";

    /**
     * 正则表达式：只能输入n个数字
     */
    private static final String REGEX_NUMBER_LENGTH = "^\\d{%d}$";

    /**
     * 正则表达式：只能由英文、数字、下划线组成
     */
    private static final String REGEX_USERNAME = "^\\w+$";

    /**
     * 正则表达式：验证密码
     */
    private static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,16}$";

    /**
     * 正则表达式：验证手机号....只验证11位1开头的数字
     */
    //private static final String REGEX_MOBILE = "^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$";
    private static final String REGEX_MOBILE = "^[1][0-9]{10}$";
    /**
     * 正则表达式：验证邮箱
     */
    private static final String REGEX_EMAIL = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";

    /**
     * 正则表达式：验证汉字
     */
    private static final String REGEX_CHINESE = "^[\u4e00-\u9fa5],{0,}$";

    /**
     * 正则表达式：验证身份证
     */
    private static final String REGEX_ID_CARD = "^(^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$)|(^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])((\\d{4})|\\d{3}[Xx])$)$";

    /**
     * 正则表达式：验证URL
     */
    private static final String REGEX_URL = "^https?:\\/\\/(([a-zA-Z0-9_-])+(\\.)?)*(:\\d+)?(\\/((\\.)?(\\?)?=?&?[a-zA-Z0-9_-](\\?)?)*)*$";

    /**
     * 正则表达式：验证IP地址
     */
    private static final String REGEX_IP_ADDR = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";

    /**
     * 正则表达式：邮编
     */
    private static final String REGEX_ZIPCODE = "^[1-9]\\d{5}(?!\\d)$";

    /**
     * 正则表达式：日期 yyyyMMdd
     */
    private static final String REGEX_DATE = "^\\d{4}((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3([0|1])))$";

    /**
     * 正则表达式：时间
     */
    private static final String REGEX_TIME = "(([01]\\d)|(2[0-3]))[0-5]\\d([0-5]\\d)?";

    /**
     * 正则表达式：日期时间
     */
    private static final String REGEX_DATETIME = "^\\d{4}((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3([0|1])))((0[0-9])|([1-2][0-9]))((0[0-9])|([1-5][0-9]))((0[0-9])|([1-5][0-9]))$";

    /**
     * 
     * Description：校验是否为空 <br/>
     * Date：2018年10月24日 上午9:37:02　<br/>
     * Author：lean <br/>
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        return str==null||"".equals(str)||"null".equals(str);
    }
    /**
     * 
     * Description：校验用户名 <br/>
     * Date：2018年10月24日 上午9:36:55　<br/>
     * Author：lean <br/>
     * @param username
     * @return
     */
    public static boolean isUsername(String username) {
        return Pattern.matches(REGEX_USERNAME, username);
    }

    /**
     * 
     * Description： 校验密码 <br/>
     * Date：2018年10月24日 上午9:36:47　<br/>
     * Author：lean <br/>
     * @param password
     * @return
     */
    public static boolean isPassword(String password) {
        return Pattern.matches(REGEX_PASSWORD, password);
    }

    /**
     * 
     * Description：校验手机号 <br/>
     * Date：2018年10月24日 上午9:36:41　<br/>
     * Author：lean <br/>
     * @param mobile
     * @return
     */
    public static boolean isMobile(String mobile) {
        return Pattern.matches(REGEX_MOBILE, mobile);
    }

    /**
     * 
     * Description：校验邮箱 <br/>
     * Date：2018年10月24日 上午9:36:35　<br/>
     * Author：lean <br/>
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        return Pattern.matches(REGEX_EMAIL, email);
    }

    /**
     * 
     * Description：校验汉字 <br/>
     * Date：2018年10月24日 上午9:36:30　<br/>
     * Author：lean <br/>
     * @param chinese
     * @return
     */
    public static boolean isChinese(String chinese) {
        return Pattern.matches(REGEX_CHINESE, chinese);
    }

    /**
     * 
     * Description：校验身份证 <br/>
     * Date：2018年10月24日 上午9:36:24　<br/>
     * Author：lean <br/>
     * @param idCard
     * @return
     */
    public static boolean isIDCard(String idCard) {
        return Pattern.matches(REGEX_ID_CARD, idCard);
    }

    /**
     * 
     * Description：校验URL <br/>
     * Date：2018年10月24日 上午9:36:19　<br/>
     * Author：lean <br/>
     * @param url
     * @return
     */
    public static boolean isUrl(String url) {
        return Pattern.matches(REGEX_URL, url);
    }

    /**
     * 
     * Description：校验IP地址 <br/>
     * Date：2018年10月24日 上午9:36:13　<br/>
     * Author：lean <br/>
     * @param ipAddr
     * @return
     */
    public static boolean isIPAddr(String ipAddr) {
        return Pattern.matches(REGEX_IP_ADDR, ipAddr);
    }


    /**
     * 
     * Description：校验数字 <br/>
     * Date：2018年10月24日 上午9:36:07　<br/>
     * Author：lean <br/>
     * @param number
     * @return
     */
    public static boolean isNumber(String number){
        return Pattern.matches(REGEX_NUMBER,number);
    }

    /**
     * 
     * Description： 校验N个数字 <br/>
     * Date：2018年10月24日 上午9:36:01　<br/>
     * Author：lean <br/>
     * @param number
     * @param length
     * @return
     */
    public static boolean isNumberLength(String number,int length){
        return Pattern.matches(String.format(REGEX_NUMBER_LENGTH,length), number);
    }

    /**
     * 
     * Description： 校验邮编 <br/>
     * Date：2018年10月24日 上午9:35:54　<br/>
     * Author：lean <br/>
     * @param zipCode
     * @return
     */
    public static boolean isZipCode(String zipCode){
        return Pattern.matches(REGEX_ZIPCODE,zipCode);
    }

    /**
     * 
     * Description： 校验日期格式 <br/>
     * Date：2018年10月24日 上午9:35:47　<br/>
     * Author：lean <br/>
     * @param date
     * @return
     */
    public static boolean isDate(String date){
        return Pattern.matches(REGEX_DATE, date);
    }

    /**
     * 
     * Description：校验时间格式 <br/>
     * Date：2018年10月24日 上午9:35:42　<br/>
     * Author：lean <br/>
     * @param time
     * @return
     */
    public static boolean isTime(String time){
        return Pattern.matches(REGEX_TIME, time);
    }

    /**
     * 
     * Description：校验日期时间格式 <br/>
     * Date：2018年10月24日 上午9:35:36　<br/>
     * Author：lean <br/>
     * @param dateTime
     * @return
     */
    public static boolean isDateTime(String dateTime){
        return Pattern.matches(REGEX_DATETIME, dateTime);
    }
}
