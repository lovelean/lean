package com.kowloon.tools.encrypt.md5;

import java.security.MessageDigest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import com.kowloon.tools.encrypt.exception.EncryptCommonError;
import com.kowloon.tools.encrypt.exception.EncryptCommonException;


/**
 * 
 * ClassName：com.kowloon.tools.encrypt.md5.MD5Utils　　<br/>
 * Description：MD5工具类 <br/>
 * Date：2018年8月29日 上午11:00:39<br/>
 * @author lean
 * @version 1.0
 */
public class MD5Utils {
	
	public static final String CHARSET_ALG = "UTF-8";

    public static String sha1(String data) {
        return DigestUtils.sha1Hex(data);
    }

    public static String sha1(byte[] data) {
        return DigestUtils.sha1Hex(data);
    }

    public static String md5(byte[] data) throws EncryptCommonException {
        try{
        	return DigestUtils.md5Hex(data);
		}catch(Exception e){
			throw new EncryptCommonException(EncryptCommonError.CODE_MD5_ERROR);
		}
    }

    public static String md5(String data) throws EncryptCommonException {
        try{
        	return DigestUtils.md5Hex(data);
		}catch(Exception e){
			throw new EncryptCommonException(EncryptCommonError.CODE_MD5_ERROR);
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
	public static String MD5Encode(String origin, String charset) throws EncryptCommonException {
		if(StringUtils.isEmpty(charset)) charset = CHARSET_ALG;
		try{
			String resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToHexString(md.digest(resultString.getBytes(charset)));
			return resultString;
		}catch(Exception e){
			throw new EncryptCommonException(EncryptCommonError.CODE_MD5_ERROR);
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
}
