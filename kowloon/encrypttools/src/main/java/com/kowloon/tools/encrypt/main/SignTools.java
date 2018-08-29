
/**   
 * Title：RsaUtils.java 　<br/>
 * Package：com.kowloon.tools.encrypt.rsa 　<br/>
 * Description：<br/>
 * Data：2018年8月28日 下午6:25:02<br/>
 * @author lean
 * @copyright  Corporation 2018    
 * @version v1.0 
 */
package com.kowloon.tools.encrypt.main;

import java.util.Map;

import com.kowloon.tools.encrypt.exception.EncryptCommonException;
import com.kowloon.tools.encrypt.md5.MD5SignUtils;
import com.kowloon.tools.encrypt.rsa.RsaSignUtils;

/**
 * 
 * ClassName：com.kowloon.tools.encrypt.main.SignTools　　<br/>
 * Description：签名工具类 <br/>
 * Date：2018年8月28日 下午7:35:48<br/>
 * @author lean
 * @version 1.0
 */
public class SignTools {
	
	/**
	 * 
	 * Description：签名[结果base64加密] <br/>
	 * Date：2018年8月29日 上午11:30:29　<br/>
	 * Author：lean <br/>
	 * @param data 待签名对象Map<String, Object>
	 * @param privateKey 密钥
	 * @param charset 字符集
	 * @param signType 签名方式.MD5/RSA/RSA2
	 * @return base64编码后的签名
	 * @throws EncryptCommonException
	 */
    public static String signBase64MapObject(Map<String, Object> data, String privateKey, String charset, String signType)
            throws EncryptCommonException {
    	switch (signType) {
		case "MD5":
			return MD5SignUtils.md5SignBase64MapObject(data, privateKey, charset);
		default:
			return RsaSignUtils.rsaSignBase64MapObject(data, privateKey, charset, signType);
		}
    }
    
    /**
	 * 
	 * Description：签名[结果base64加密] <br/>
	 * Date：2018年8月29日 上午11:30:29　<br/>
	 * Author：lean <br/>
	 * @param data 待签名对象Map<String, String>
	 * @param privateKey 密钥
	 * @param charset 字符集
	 * @param signType 签名方式.MD5/RSA/RSA2
	 * @return base64编码后的签名
	 * @throws EncryptCommonException
	 */
    public static String signBase64MapString(Map<String, String> data, String privateKey, String charset, String signType)
            throws EncryptCommonException {
    	switch (signType) {
		case "MD5":
			return MD5SignUtils.md5SignBase64MapString(data, privateKey, charset);
		default:
			return RsaSignUtils.rsaSignBase64MapString(data, privateKey, charset, signType);
		}
    }
    
    /**
	 * 
	 * Description：签名[结果base64加密] <br/>
	 * Date：2018年8月29日 上午11:30:29　<br/>
	 * Author：lean <br/>
	 * @param content 待签名串String
	 * @param privateKey 密钥
	 * @param charset 字符集
	 * @param signType 签名方式.MD5/RSA/RSA2
	 * @return base64编码后的签名
	 * @throws EncryptCommonException
	 */
    public static String signBase64String(String content, String privateKey, String charset, String signType)
            throws EncryptCommonException {
    	switch (signType) {
		case "MD5":
			return MD5SignUtils.md5SignBase64String(content, privateKey, charset);
		default:
			return RsaSignUtils.rsaSignBase64String(content, privateKey, charset, signType);
		}
    }
    
    /**
	 * 
	 * Description：签名[结果无base64加密] <br/>
	 * Date：2018年8月29日 上午11:30:29　<br/>
	 * Author：lean <br/>
	 * @param data 待签名对象Map<String, Object>
	 * @param privateKey 密钥
	 * @param charset 字符集
	 * @param signType 签名方式.MD5/RSA/RSA2
	 * @return 签名
	 * @throws EncryptCommonException
	 */
    public static String signMapObject(Map<String, Object> data, String privateKey, String charset, String signType)
            throws EncryptCommonException {
    	switch (signType) {
		case "MD5":
			return MD5SignUtils.md5SignMapObject(data, privateKey, charset);
		default:
			return RsaSignUtils.getStringFromByte(RsaSignUtils.rsaSignMapObject(data, privateKey, charset, signType), charset);
		}
    }
    
    /**
	 * 
	 * Description：签名[结果无base64加密] <br/>
	 * Date：2018年8月29日 上午11:30:29　<br/>
	 * Author：lean <br/>
	 * @param data 待签名对象Map<String, String>
	 * @param privateKey 密钥
	 * @param charset 字符集
	 * @param signType 签名方式.MD5/RSA/RSA2
	 * @return 签名
	 * @throws EncryptCommonException
	 */
    public static String signMapString(Map<String, String> data, String privateKey, String charset, String signType)
            throws EncryptCommonException {
    	switch (signType) {
		case "MD5":
			return MD5SignUtils.md5SignMapString(data, privateKey, charset);
		default:
			return RsaSignUtils.getStringFromByte(RsaSignUtils.rsaSignMapString(data, privateKey, charset, signType), charset);
		}
    }
    
    /**
	 * 
	 * Description：签名[结果无base64加密] <br/>
	 * Date：2018年8月29日 上午11:30:29　<br/>
	 * Author：lean <br/>
	 * @param content 待签名串String
	 * @param privateKey 密钥
	 * @param charset 字符集
	 * @param signType 签名方式.MD5/RSA/RSA2
	 * @return 签名
	 * @throws EncryptCommonException
	 */
    public static String signString(String content, String privateKey, String charset, String signType)
            throws EncryptCommonException {
    	switch (signType) {
		case "MD5":
			return MD5SignUtils.md5SignString(content, privateKey, charset);
		default:
			return RsaSignUtils.getStringFromByte(RsaSignUtils.rsaSignString(content, privateKey, charset, signType), charset);
		}
    }
    
	public static void main(String[] args) {

	}

}
