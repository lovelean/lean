package com.bosssoft.itfinance.citizen.tools.string;

import java.text.MessageFormat;
import org.apache.commons.lang3.StringUtils;

/**
 * 
 * ClassName：com.bosssoft.itfinance.citizen.tools.StringUtilsExt　　<br/>
 * Description：字符串处理拓展类 <br/>
 * Date：2018年10月24日 上午8:55:36<br/>
 * @author lean
 * @version 1.0
 */
public class StringUtilsExt extends StringUtils {

    public static String toString(Object obj) {
        return toString(obj, "");
    }

    public static String toString(Object obj, String def) {
        return obj == null ? def : obj.toString();
    }

    public static String blankToString(Object obj, String def) {
        String str = toString(obj);
        return isBlank(str) ? def : str;
    }

    /**
     * 
     * Description：检查指定的字符串列表是否不为空。  <br/>
     * Date：2018年10月24日 上午8:55:55　<br/>
     * Author：lean <br/>
     * @param values
     * @return
     */
    public static boolean areNotEmpty(String... values) {
        boolean result = true;
        if (values == null || values.length == 0) {
            result = false;
        } else {
            for (String value : values) {
                result &= !isEmpty(value);
            }
        }
        return result;
    }

    /**
	 * 
	 * Description：检查指定的字符串是否为空。
	 *  SysUtils.isEmpty(null) = true
	 *  SysUtils.isEmpty("") = true
	 *  SysUtils.isEmpty("   ") = true
	 *  SysUtils.isEmpty("abc") = false<br/>
	 * Date：2018年4月19日 上午8:34:04　<br/>
	 * Author：lean <br/>
	 * @param value 待检查的字符串
	 * @return true/false
	 */
	public static boolean isEmpty(String value) {
		int strLen;
		if (value == null || (strLen = value.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if ((Character.isWhitespace(value.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * Description：检查指定的字符串是否为非空 <br/>
	 * Date：2018年4月19日 上午10:04:16　<br/>
	 * Author：lean <br/>
	 * @param value
	 * @return
	 */
	public static boolean isNotEmpty(String value) {
		return !isEmpty(value);
	}
    
    /**
     * 
     * Description：替换{0}{1}为指定的字符串 args <br/>
     * Date：2018年10月24日 上午8:56:16　<br/>
     * Author：lean <br/>
     * @param pattern
     * @param args
     * @return
     */
    public static String formatString(String pattern, Object... args) {
        return MessageFormat.format(pattern, args);
    }
}
