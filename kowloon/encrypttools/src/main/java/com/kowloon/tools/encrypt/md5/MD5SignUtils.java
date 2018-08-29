
/**   
 * Title：RsaUtils.java 　<br/>
 * Package：com.kowloon.tools.encrypt.rsa 　<br/>
 * Description：<br/>
 * Data：2018年8月28日 下午6:25:02<br/>
 * @author lean
 * @copyright  Corporation 2018    
 * @version v1.0 
 */
package com.kowloon.tools.encrypt.md5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;

import com.kowloon.tools.encrypt.code.CodeUtils;
import com.kowloon.tools.encrypt.exception.EncryptCommonError;
import com.kowloon.tools.encrypt.exception.EncryptCommonException;

/**
 * 
 * ClassName：com.kowloon.tools.encrypt.rsa.RsaSignUtils　　<br/>
 * Description：md5签名类 <br/>
 * Date：2018年8月29日 上午9:26:19<br/>
 * @author lean
 * @version 1.0
 */
public class MD5SignUtils {
	
	public static final String CHARSET_ALG = "UTF-8";
	//签名相关属性值
    public static final String SIGN = "sign";
    public static final String SIGN_TYPE = "sign_type";
    
    /**
     * 
     * Description：md5签名[结果base64加密] <br/>
     * Date：2018年8月29日 上午11:15:25　<br/>
     * Author：lean <br/>
     * @param data 待签名对象Map<String, Object>
     * @param key 密钥
     * @param charset 字符集
     * @return
     * @throws EncryptCommonException
     */
    public static String md5SignBase64MapObject(Map<String, Object> data, String key, String charset) throws EncryptCommonException {
    	return CodeUtils.encodeBase64String(md5SignMapObject(data, key, charset));
    }
    
    /**
     * 
     * Description：md5签名[结果base64加密] <br/>
     * Date：2018年8月29日 上午11:15:25　<br/>
     * Author：lean <br/>
     * @param data 待签名对象Map<String, String>
     * @param key 密钥
     * @param charset 字符集
     * @return
     * @throws EncryptCommonException
     */
    public static String md5SignBase64MapString(Map<String, String> data, String key, String charset) throws EncryptCommonException {
    	return CodeUtils.encodeBase64String(md5SignMapString(data, key, charset));
    }
    
    /**
     * 
     * Description：md5签名[结果base64加密] <br/>
     * Date：2018年8月29日 上午11:15:25　<br/>
     * Author：lean <br/>
     * @param content 待签名串String
     * @param key 密钥
     * @param charset 字符集
     * @return
     * @throws EncryptCommonException
     */
    public static String md5SignBase64String(String content, String key, String charset) throws EncryptCommonException {
    	return CodeUtils.encodeBase64String(md5SignString(content, key, charset));
    }
    
    /**
     * 
     * Description：md5签名 <br/>
     * Date：2018年8月29日 上午11:15:25　<br/>
     * Author：lean <br/>
     * @param data 待签名对象Map<String, Object>
     * @param key 密钥
     * @param charset 字符集
     * @return
     * @throws EncryptCommonException
     */
    public static String md5SignMapObject(Map<String, Object> data, String key, String charset) throws EncryptCommonException {
    	if(StringUtils.isEmpty(charset)) charset = CHARSET_ALG;
    	return md5SignMapString(paramsFilter(data), key, charset);
    }
    
    /**
     * 
     * Description：md5签名 <br/>
     * Date：2018年8月29日 上午11:15:25　<br/>
     * Author：lean <br/>
     * @param data 待签名对象Map<String, String>
     * @param key 密钥
     * @param charset 字符集
     * @return
     * @throws EncryptCommonException
     */
    public static String md5SignMapString(Map<String, String> data, String key, String charset) throws EncryptCommonException {
    	if(StringUtils.isEmpty(charset)) charset = CHARSET_ALG;
    	return md5SignString(createSignContent(data), key, charset);
    }
    
    /**
     * 
     * Description：md5签名 <br/>
     * Date：2018年8月29日 上午11:15:25　<br/>
     * Author：lean <br/>
     * @param content 待签名串String
     * @param key 密钥
     * @param charset 字符集
     * @return
     * @throws EncryptCommonException
     */
    public static String md5SignString(String content, String key, String charset) throws EncryptCommonException {
    	if(StringUtils.isEmpty(charset)) charset = CHARSET_ALG;
    	return MD5Utils.MD5Encode(connectContentAndKey(content, key), charset);
    }
	
    /**
     * 
     * Description：组装签名串 <br/>
     * Date：2018年8月29日 上午11:12:07　<br/>
     * Author：lean <br/>
     * @param content 参数内容
     * @param priKey 密钥
     * @return
     * @throws EncryptCommonException
     */
    public static String connectContentAndKey(String content, String key) throws EncryptCommonException {
		try {
			if (StringUtils.isEmpty(content) || StringUtils.isEmpty(key)) return "";
	        return String.format("%s&key=%s", content, key);
        } catch (Exception e) {
            throw new EncryptCommonException(EncryptCommonError.SIGN_RSA_CONTENT_GET_ERROR);
        }
    }
    
	/**
	 * 
	 * Description：组装签名串[空值不计入] <br/>
	 * Date：2018年8月28日 下午6:37:38　<br/>
	 * Author：lean <br/>
	 * @param params 参数
	 * @return
	 * @throws EncryptCommonException 
	 */
	public static String createSignContent(Map<String, String> params) throws EncryptCommonException {
		try {
			if (params == null || params.size() <= 0) return "";
	        Map<String, String> sortedParams = new TreeMap<String, String>();
	        sortedParams.putAll(params);
	        ArrayList<String> keys = new ArrayList<String>(sortedParams.keySet());
	        Collections.sort(keys);
	        StringBuffer sb = new StringBuffer();
	        int keyLastNum = keys.size() - 1;
	        for (int i = 0; i < keys.size(); ++i) {
	            String key = keys.get(i);
	            String value = String.valueOf(params.get(key));
	            if (isNotEmpty(key, value)) {
	            	sb.append(key).append("=").append(value);
	                if (i != keyLastNum) sb.append("&");
	            }
	        }
	        return sb.toString();
        } catch (Exception e) {
            throw new EncryptCommonException(EncryptCommonError.SIGN_RSA_CONTENT_GET_ERROR);
        }
    }
	
	/**
	 * 
	 * Description：参数过滤 <br/>
	 * Date：2018年8月28日 下午6:40:35　<br/>
	 * Author：lean <br/>
	 * @param params
	 * @return
	 * @throws EncryptCommonException 
	 */
	private static Map<String, String> paramsFilter(Map<String, Object> params) throws EncryptCommonException {
		try {
			Map<String, String> result = new HashMap<>();
	        if (params == null || params.size() == 0) return result;
	        for (Map.Entry<String, Object> entry : params.entrySet()) {
	            if (entry.getValue() == null || SIGN.equals(entry.getKey()) || SIGN_TYPE.equals(entry.getKey())) {
	                continue;
	            }
	            result.put(entry.getKey(), String.valueOf(entry.getValue()));
	        }
	        return result;
        } catch (Exception e) {
            throw new EncryptCommonException(EncryptCommonError.SIGN_RSA_PARAM_FILTER_ERROR);
        }
    }
	
	
	/**
	 * 
	 * Description：检查指定的字符串列表是否不为空 <br/>
	 * Date：2018年8月28日 下午6:47:09　<br/>
	 * Author：lean <br/>
	 * @param values
	 * @return
	 */
    public static boolean isNotEmpty(String... values) {
        boolean result = true;
        if (values == null || values.length == 0) {
            result = false;
        } else {
            for (String value : values) {
                result &= !StringUtils.isEmpty(value);
            }
        }
        return result;
    }
    
	public static void main(String[] args) {

	}

}
