package com.bosssoft.itfinance.citizen.tools.code;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bosssoft.itfinance.citizen.tools.exception.ToolsCommonError;
import com.bosssoft.itfinance.citizen.tools.exception.ToolsCommonException;


/**
 * 
 * ClassName：com.kowloon.tools.encrypt.code.CodeUtils　　<br/>
 * Description：编解码工具类<br/>
 * Date：2018年8月28日 下午5:06:56<br/>
 * @author lean
 * @version 1.0
 */
public class CodeUtils {
	
	private final static Logger logger = LoggerFactory.getLogger(CodeUtils.class);
	
	public static final String CHARSET_ALG = "UTF-8";

    public static String sha1(String data) {
        return DigestUtils.sha1Hex(data);
    }

    public static String sha1(byte[] data) {
        return DigestUtils.sha1Hex(data);
    }

    public static String md5(byte[] data) throws ToolsCommonException {
        try{
        	return DigestUtils.md5Hex(data);
		}catch(Exception e){
			logger.error("error:"+e.getMessage());
			throw new ToolsCommonException(ToolsCommonError.CODE_MD5_ERROR);
		}
    }

    public static String md5(String data) throws ToolsCommonException {
        try{
        	return DigestUtils.md5Hex(data);
		}catch(Exception e){
			logger.error("error:"+e.getMessage());
			throw new ToolsCommonException(ToolsCommonError.CODE_MD5_ERROR);
		}
    }
    
    /**
	 * 
	 * Description：MD5加密 <br/>
	 * Date：2018年6月27日 上午9:01:43　<br/>
	 * Author：lean <br/>
	 * @param origin 待加密串
	 * @param charset 字符集
	 * @return
	 * @throws Exception 
	 */
	public static String MD5Encode(String origin, String charset) throws ToolsCommonException {
		if(StringUtils.isEmpty(charset)) charset = CHARSET_ALG;
		try{
			String resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToHexString(md.digest(resultString.getBytes(charset)));
			return resultString;
		}catch(Exception e){
			logger.error("error:"+e.getMessage());
			throw new ToolsCommonException(ToolsCommonError.CODE_MD5_ERROR);
		}
	}

	/**
	 * 
	 * Description：字节组转16进制 <br/>
	 * Date：2018年6月27日 上午9:03:56　<br/>
	 * Author：lean <br/>
	 * @param bytes
	 * @return
	 */
	private static String byteArrayToHexString(byte[] bytes) {
		StringBuilder hexString = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			String hex = Integer.toHexString(0xFF & bytes[i]);
			if (hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}
		return hexString.toString();
	}

    /**
     * 
     * Description：base64转码[UTF-8] <br/>
     * Date：2018年8月28日 下午5:23:02　<br/>
     * Author：lean <br/>
     * @param data 待转码内容串
     * @return
     * @throws Exception
     */
    public static String encodeBase64String(String data) throws ToolsCommonException {
        return encodeBase64String(data, CHARSET_ALG);
    }

    /**
     * 
     * Description：base64转码  <br/>
     * Date：2018年8月28日 下午5:23:49　<br/>
     * Author：lean <br/>
     * @param data 待转码内容串
     * @param charSet 字符集
     * @return
     * @throws ToolsCommonException
     */
    public static String encodeBase64String(String data, String charSet) throws ToolsCommonException {
    	if(StringUtils.isEmpty(charSet)) charSet = CHARSET_ALG;
    	try {
            return Base64.encodeBase64String(data.getBytes(charSet));
        } catch (Exception e) {
			logger.error("error:"+e.getMessage());
        	throw new ToolsCommonException(ToolsCommonError.CODE_BASE64_ENCODE_ERROR);
        }
    }

    /**
     * 
     * Description：base64转码  <br/>
     * Date：2018年8月28日 下午5:23:49　<br/>
     * Author：lean <br/>
     * @param data 待转码byte[]
     * @return
     * @throws ToolsCommonException
     */
    public static String encodeBase64String(byte[] data) throws ToolsCommonException {
    	try {
    		return Base64.encodeBase64String(data);
        } catch (Exception e) {
			logger.error("error:"+e.getMessage());
        	throw new ToolsCommonException(ToolsCommonError.CODE_BASE64_ENCODE_ERROR);
        }
    }

    /**
     * 
     * Description：base64转码  <br/>
     * Date：2018年8月28日 下午5:23:49　<br/>
     * Author：lean <br/>
     * @param data 待转码内容串
     * @param charSet 字符集
     * @return
     * @throws ToolsCommonException
     */
    public static byte[] encodeBase64Byte(String data, String charSet) throws ToolsCommonException {
    	if(StringUtils.isEmpty(charSet)) charSet = CHARSET_ALG;
    	try {
            return encodeBase64Byte(data.getBytes(charSet));
        } catch (Exception e) {
			logger.error("error:"+e.getMessage());
        	throw new ToolsCommonException(ToolsCommonError.CODE_BASE64_ENCODE_ERROR);
        }
    }

    /**
     * 
     * Description：base64转码  <br/>
     * Date：2018年8月28日 下午5:23:49　<br/>
     * Author：lean <br/>
     * @param data 待转码byte[]
     * @return
     * @throws ToolsCommonException
     */
    public static byte[] encodeBase64Byte(byte[] data) throws ToolsCommonException {
        try {
        	return Base64.encodeBase64(data);
        } catch (Exception e) {
			logger.error("error:"+e.getMessage());
        	throw new ToolsCommonException(ToolsCommonError.CODE_BASE64_ENCODE_ERROR);
        }
    }
    
    /**
     * 
     * Description：base64反转码[UTF-8] <br/>
     * Date：2018年8月28日 下午5:29:54　<br/>
     * Author：lean <br/>
     * @param data 待反转码字符串
     * @return
     * @throws ToolsCommonException
     */
    public static String decodeBase64String(String data) throws ToolsCommonException {
        return decodeBase64String(data, CHARSET_ALG);
    }

    /**
     * 
     * Description：base64反转码 <br/>
     * Date：2018年8月28日 下午5:15:16　<br/>
     * Author：lean <br/>
     * @param data 待反转码内容
     * @param charSet 字符集
     * @return
     * @throws ToolsCommonException
     */
    public static String decodeBase64String(String data, String charSet) throws ToolsCommonException {
    	if(StringUtils.isEmpty(charSet)) charSet = CHARSET_ALG;
    	try {
            return new String(Base64.decodeBase64(data), charSet);
        } catch (Exception e) {
			logger.error("error:"+e.getMessage());
        	throw new ToolsCommonException(ToolsCommonError.CODE_BASE64_DECODE_ERROR);
        }
    }

    /**
     * 
     * Description：base64反转码[UTF-8] <br/>
     * Date：2018年8月28日 下午5:30:53　<br/>
     * Author：lean <br/>
     * @param data 待反转码byte[]
     * @return
     * @throws ToolsCommonException
     */
    public static String decodeBase64String(byte[] data) throws ToolsCommonException {
        try {
        	return new String(Base64.decodeBase64(data), CHARSET_ALG);
        } catch (Exception e) {
			logger.error("error:"+e.getMessage());
        	throw new ToolsCommonException(ToolsCommonError.CODE_BASE64_DECODE_ERROR);
        }
    }
    
    /**
     * 
     * Description：base64反转码[UTF-8] <br/>
     * Date：2018年8月28日 下午5:30:53　<br/>
     * Author：lean <br/>
     * @param data 待反转码byte[]
     * @param charSet 字符集
     * @return
     * @throws ToolsCommonException
     */
    public static String decodeBase64String(byte[] data, String charSet) throws ToolsCommonException {
    	if(StringUtils.isEmpty(charSet)) charSet = CHARSET_ALG;
    	try {
        	return new String(Base64.decodeBase64(data), charSet);
        } catch (Exception e) {
			logger.error("error:"+e.getMessage());
        	throw new ToolsCommonException(ToolsCommonError.CODE_BASE64_DECODE_ERROR);
        }
    }
    
    /**
     * 
     * Description：base64反转码 <br/>
     * Date：2018年8月28日 下午5:32:49　<br/>
     * Author：lean <br/>
     * @param data 待反转码byte[]
     * @return
     * @throws ToolsCommonException
     */
    public static byte[] decodeBase64Byte(byte[] data) throws ToolsCommonException {
        try {
        	return Base64.decodeBase64(data);
        } catch (Exception e) {
			logger.error("error:"+e.getMessage());
        	throw new ToolsCommonException(ToolsCommonError.CODE_BASE64_DECODE_ERROR);
        }
    }
    
    /**
     * 
     * Description：base64反转码 <br/>
     * Date：2018年8月28日 下午5:42:35　<br/>
     * Author：lean <br/>
     * @param data 待反转码内容串
     * @return
     * @throws ToolsCommonException
     */
    public static byte[] decodeBase64Byte(String data) throws ToolsCommonException {
        try {
        	return Base64.decodeBase64(data);
        } catch (Exception e) {
			logger.error("error:"+e.getMessage());
        	throw new ToolsCommonException(ToolsCommonError.CODE_BASE64_DECODE_ERROR);
        }
    }

    /**
     * 
     * Description：转码[utf-8] <br/>
     * Date：2018年8月28日 下午5:14:30　<br/>
     * Author：lean <br/>
     * @param data 待转码内容
     * @return
     * @throws ToolsCommonException
     */
    public static String encodeString(String data) throws ToolsCommonException {
        return encodeString(data, CHARSET_ALG);
    }

    /**
     * 
     * Description：反转码[utf-8] <br/>
     * Date：2018年8月28日 下午5:13:48　<br/>
     * Author：lean <br/>
     * @param data 待反转码内容
     * @return
     * @throws Exception
     */
    public static String decodeString(String data) throws ToolsCommonException {
        return decodeString(data, CHARSET_ALG);
    }

    /**
     * 
     * Description：转码 <br/>
     * Date：2018年8月28日 下午5:13:19　<br/>
     * Author：lean <br/>
     * @param data 待转码内容
     * @param charSet 字符集
     * @return
     * @throws ToolsCommonException
     */
    public static String encodeString(String data, String charSet) throws ToolsCommonException {
    	if(StringUtils.isEmpty(charSet)) charSet = CHARSET_ALG;
    	try {
            return URLEncoder.encode(data, charSet);
        } catch (Exception e) {
			logger.error("error:"+e.getMessage());
        	throw new ToolsCommonException(ToolsCommonError.CODE_ENCODE_ERROR);
        }
    }

    /**
     * 
     * Description：反转码 <br/>
     * Date：2018年8月28日 下午5:13:04　<br/>
     * Author：lean <br/>
     * @param data 待反转码内容
     * @param charSet 字符集
     * @return
     * @throws ToolsCommonException
     */
    public static String decodeString(String data, String charSet) throws ToolsCommonException {
    	if(StringUtils.isEmpty(charSet)) charSet = CHARSET_ALG;
    	try {
            return URLDecoder.decode(data, charSet);
        } catch (Exception e) {
			logger.error("error:"+e.getMessage());
        	throw new ToolsCommonException(ToolsCommonError.CODE_DECODE_ERROR);
        }
    }
}
