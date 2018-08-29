
/**   
 * Title：verifyTools.java 　<br/>
 * Package：com.kowloon.tools.encrypt.main 　<br/>
 * Description：<br/>
 * Data：2018年8月28日 下午7:35:33<br/>
 * @author lean
 * @copyright  Corporation 2018    
 * @version v1.0 
 */
package com.kowloon.tools.encrypt.main;

import java.util.Map;

import com.kowloon.tools.encrypt.exception.EncryptCommonException;
import com.kowloon.tools.encrypt.md5.MD5VerifyUtils;
import com.kowloon.tools.encrypt.rsa.RsaVerifyUtils;

/**
 * ClassName：com.kowloon.tools.encrypt.main.verifyTools　　<br/>
 * Description：验签工具类 <br/>
 * Date：2018年8月28日 下午7:35:33<br/>
 * @author lean
 * @version 1.0
 */
public class verifyTools {
	
	/**
     * 
     * Description：验签[参考签名base64加密] <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待验签对象Map<String, Object>
     * @param base64Sign 参考签名Base64串String
     * @param publicKey 密钥
     * @param charset 字符集
     * @param signType 签名方式
     * @return 
     * @throws EncryptCommonException
     */
    public static boolean rsaVerifyBase64MapObject(Map<String, Object> data, String base64Sign, String publicKey, String charset, String signType)
            throws EncryptCommonException {
    	switch (signType) {
		case "MD5":
			return MD5VerifyUtils.md5VerifyBase64MapObject(data, base64Sign, publicKey, charset);
		default:
			return RsaVerifyUtils.rsaVerifyBase64MapObject(data, base64Sign, publicKey, charset, signType);
		}
    }
    
    /**
     * 
     * Description：验签[参考签名base64加密] <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待验签对象Map<String, String>
     * @param base64Sign 参考签名Base64串String
     * @param publicKey 密钥
     * @param charset 字符集
     * @param signType 签名方式
     * @return 
     * @throws EncryptCommonException
     */
    public static boolean rsaVerifyBase64MapString(Map<String, String> data, String base64Sign, String publicKey, String charset, String signType)
            throws EncryptCommonException {
    	switch (signType) {
		case "MD5":
			return MD5VerifyUtils.md5VerifyBase64MapString(data, base64Sign, publicKey, charset);
		default:
			return RsaVerifyUtils.rsaVerifyBase64MapString(data, base64Sign, publicKey, charset, signType);
		}
    }
    
    /**
     * 
     * Description：验签[参考签名base64加密] <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待验签对象Map<String, Object>
     * @param base64Sign 参考签名Base64串String
     * @param publicKey 密钥
     * @param charset 字符集
     * @param signType 签名方式
     * @return 
     * @throws EncryptCommonException
     */
    public static boolean rsaVerifyBase64String(String content, String base64Sign, String publicKey, String charset, String signType)
            throws EncryptCommonException {
    	switch (signType) {
		case "MD5":
			return MD5VerifyUtils.md5VerifyBase64String(content, base64Sign, publicKey, charset);
		default:
			return RsaVerifyUtils.rsaVerifyBase64String(content, base64Sign, publicKey, charset, signType);
		}
    }
    
    /**
     * 
     * Description：验签[参考签名base64加密] <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待验签对象Map<String, Object>
     * @param sign 参考签名串String
     * @param publicKey 密钥
     * @param charset 字符集
     * @param signType 签名方式
     * @return 
     * @throws EncryptCommonException
     */
    public static boolean rsaVerifyMapObject(Map<String, Object> data, String sign, String publicKey, String charset, String signType)
            throws EncryptCommonException {
    	switch (signType) {
		case "MD5":
			return MD5VerifyUtils.md5VerifyMapObject(data, sign, publicKey, charset);
		default:
			return RsaVerifyUtils.rsaVerifyMapObject(data, sign, publicKey, charset, signType);
		}
    }
    
    /**
     * 
     * Description：验签[参考签名base64加密] <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待验签对象Map<String, String>
     * @param sign 参考签名串String
     * @param publicKey 密钥
     * @param charset 字符集
     * @param signType 签名方式
     * @return 
     * @throws EncryptCommonException
     */
    public static boolean rsaVerifyMapString(Map<String, String> data, String sign, String publicKey, String charset, String signType)
            throws EncryptCommonException {
    	switch (signType) {
		case "MD5":
			return MD5VerifyUtils.md5VerifyMapString(data, sign, publicKey, charset);
		default:
			return RsaVerifyUtils.rsaVerifyMapString(data, sign, publicKey, charset, signType);
		}
    }
    
    /**
     * 
     * Description：验签[参考签名base64加密] <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待验签对象Map<String, Object>
     * @param sign 参考签名串String
     * @param publicKey 密钥
     * @param charset 字符集
     * @param signType 签名方式
     * @return 
     * @throws EncryptCommonException
     */
    public static boolean rsaVerifyString(String content, String sign, String publicKey, String charset, String signType)
            throws EncryptCommonException {
    	switch (signType) {
		case "MD5":
			return MD5VerifyUtils.md5VerifyString(content, sign, publicKey, charset);
		default:
			return RsaVerifyUtils.rsaVerifyString(content, sign, publicKey, charset, signType);
		}
    }
    
	public static void main(String[] args) {

	}

}
