
/**   
 * Title：RsaUtils.java 　<br/>
 * Package：com.kowloon.tools.encrypt.rsa 　<br/>
 * Description：<br/>
 * Data：2018年8月28日 下午6:25:02<br/>
 * @author lean
 * @copyright  Corporation 2018    
 * @version v1.0 
 */
package com.kowloon.tools.encrypt.rsa;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
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
 * Description：<br/>
 * Date：2018年8月29日 上午9:26:19<br/>
 * @author lean
 * @version 1.0
 */
public class RsaVerifyUtils {
	
	public static final String CHARSET_ALG = "UTF-8";
	
	//签名相关属性值
    public static final String SIGN = "sign";
    public static final String SIGN_TYPE = "VERIFY_type";
    public static final String SIGN_TYPE_RSA = "RSA";
    /** sha256WithRsa 算法请求类型 */
    public static final String SIGN_TYPE_RSA2 = "RSA2";
    public static final String SIGN_ALGORITHMS = "SHA1WithRSA";
    public static final String SIGN_SHA256RSA_ALGORITHMS = "SHA256WithRSA";
    
    /**
     * 
     * Description：验签[参考签名base64加密] <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待验签对象Map<String, Object>
     * @param base64Sign 参考签名Base64串String
     * @param publicKey 公钥
     * @param charset 字符集
     * @param signType 签名方式
     * @return 
     * @throws EncryptCommonException
     */
    public static boolean rsaVerifyBase64MapObject(Map<String, Object> data, String base64Sign, String publicKey, String charset, String signType)
            throws EncryptCommonException {
    	switch (signType) {
		case SIGN_TYPE_RSA:
			return rsaVerifyBase64MapObject(data, base64Sign, publicKey, charset);
		case SIGN_TYPE_RSA2:
			return rsa256VerifyBase64MapObject(data, base64Sign, publicKey, charset);
		default:
			throw new EncryptCommonException(EncryptCommonError.VERIFY_TYPE_NOT_EXIST_ERROR);
		}
    }
    
    /**
     * 
     * Description：rsa验签[参考签名base64加密] <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待验签对象Map<String, Object>
     * @param base64Sign 参考签名Base64串String
     * @param publicKey 公钥
     * @param charset 字符集
     * @return 
     * @throws EncryptCommonException
     */
    public static boolean rsaVerifyBase64MapObject(Map<String, Object> data, String base64Sign, String publicKey, String charset)
            throws EncryptCommonException {
    	if(StringUtils.isEmpty(charset)) charset = CHARSET_ALG;
		return rsaVerifyMapObject(data, CodeUtils.decodeBase64Byte(base64Sign), publicKey, charset);
    }
    
    /**
     * 
     * Description：rsa256验签[参考签名base64加密] <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待验签对象Map<String, Object>
     * @param base64Sign 参考签名串String
     * @param publicKey 公钥
     * @param charset 字符集
     * @return 
     * @throws EncryptCommonException
     */
    public static boolean rsa256VerifyBase64MapObject(Map<String, Object> data, String base64Sign, String publicKey, String charset)
            throws EncryptCommonException {
    	if(StringUtils.isEmpty(charset)) charset = CHARSET_ALG;
		return rsa256VerifyMapObject(data, CodeUtils.decodeBase64Byte(base64Sign), publicKey, charset);
    }
    
    /**
     * 
     * Description：验签[参考签名base64加密] <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待验签对象Map<String, String>
     * @param base64Sign 参考签名Base64串String
     * @param publicKey 公钥
     * @param charset 字符集
     * @param signType 签名方式
     * @return 
     * @throws EncryptCommonException
     */
    public static boolean rsaVerifyBase64MapString(Map<String, String> data, String base64Sign, String publicKey, String charset, String signType)
            throws EncryptCommonException {
    	switch (signType) {
		case SIGN_TYPE_RSA:
			return rsaVerifyBase64MapString(data, base64Sign, publicKey, charset);
		case SIGN_TYPE_RSA2:
			return rsa256VerifyBase64MapString(data, base64Sign, publicKey, charset);
		default:
			throw new EncryptCommonException(EncryptCommonError.VERIFY_TYPE_NOT_EXIST_ERROR);
		}
    }
    
    /**
     * 
     * Description：rsa验签[参考签名base64加密] <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待验签对象Map<String, String>
     * @param base64Sign 参考签名Base64串String
     * @param publicKey 公钥
     * @param charset 字符集
     * @return 
     * @throws EncryptCommonException
     */
    public static boolean rsaVerifyBase64MapString(Map<String, String> data, String base64Sign, String publicKey, String charset)
            throws EncryptCommonException {
    	if(StringUtils.isEmpty(charset)) charset = CHARSET_ALG;
		return rsaVerifyMapString(data, CodeUtils.decodeBase64Byte(base64Sign), publicKey, charset);
    }
    
    /**
     * 
     * Description：rsa256验签[参考签名base64加密] <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待验签对象Map<String, String>
     * @param base64Sign 参考签名串String
     * @param publicKey 公钥
     * @param charset 字符集
     * @return 
     * @throws EncryptCommonException
     */
    public static boolean rsa256VerifyBase64MapString(Map<String, String> data, String base64Sign, String publicKey, String charset)
            throws EncryptCommonException {
    	if(StringUtils.isEmpty(charset)) charset = CHARSET_ALG;
		return rsa256VerifyMapString(data, CodeUtils.decodeBase64Byte(base64Sign), publicKey, charset);
    }
    
    /**
     * 
     * Description：验签[参考签名base64加密] <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param content 待验签串String
     * @param base64Sign 参考签名Base64串String
     * @param publicKey 公钥
     * @param charset 字符集
     * @param signType 签名方式
     * @return 
     * @throws EncryptCommonException
     */
    public static boolean rsaVerifyBase64String(String content, String base64Sign, String publicKey, String charset, String signType)
            throws EncryptCommonException {
    	switch (signType) {
		case SIGN_TYPE_RSA:
			return rsaVerifyBase64String(content, base64Sign, publicKey, charset);
		case SIGN_TYPE_RSA2:
			return rsa256VerifyBase64String(content, base64Sign, publicKey, charset);
		default:
			throw new EncryptCommonException(EncryptCommonError.VERIFY_TYPE_NOT_EXIST_ERROR);
		}
    }
    
    /**
     * 
     * Description：rsa验签[参考签名base64加密] <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param content 待验签串String
     * @param base64Sign 参考签名Base64串String
     * @param publicKey 公钥
     * @param charset 字符集
     * @return 
     * @throws EncryptCommonException
     */
    public static boolean rsaVerifyBase64String(String content, String base64Sign, String publicKey, String charset)
            throws EncryptCommonException {
    	if(StringUtils.isEmpty(charset)) charset = CHARSET_ALG;
		return rsaVerifyString(content, CodeUtils.decodeBase64Byte(base64Sign), publicKey, charset);
    }
    
    /**
     * 
     * Description：rsa256验签[参考签名base64加密] <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param content 待验签串String
     * @param base64Sign 参考签名Base64串String
     * @param publicKey 公钥
     * @param charset 字符集
     * @return 
     * @throws EncryptCommonException
     */
    public static boolean rsa256VerifyBase64String(String content, String base64Sign, String publicKey, String charset)
            throws EncryptCommonException {
    	if(StringUtils.isEmpty(charset)) charset = CHARSET_ALG;
		return rsa256VerifyString(content, CodeUtils.decodeBase64Byte(base64Sign), publicKey, charset);
    }
    
    /**
     * 
     * Description：验签 <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待验签对象Map<String, Object>
     * @param sign 参考签名串String
     * @param publicKey 公钥
     * @param charset 字符集
     * @param signType 签名方式
     * @return 
     * @throws EncryptCommonException
     */
    public static boolean rsaVerifyMapObject(Map<String, Object> data, String sign, String publicKey, String charset, String signType)
            throws EncryptCommonException {
    	switch (signType) {
		case SIGN_TYPE_RSA:
			return rsaVerifyMapObject(data, sign, publicKey, charset);
		case SIGN_TYPE_RSA2:
			return rsa256VerifyMapObject(data, sign, publicKey, charset);
		default:
			throw new EncryptCommonException(EncryptCommonError.VERIFY_TYPE_NOT_EXIST_ERROR);
		}
    }
    
    /**
     * 
     * Description：rsa验签 <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待验签对象Map<String, Object>
     * @param sign 参考签名串String
     * @param publicKey 公钥
     * @param charset 字符集
     * @return 
     * @throws EncryptCommonException
     */
    public static boolean rsaVerifyMapObject(Map<String, Object> data, String sign, String publicKey, String charset)
            throws EncryptCommonException {
    	return rsaVerifyMapString(paramsFilter(data), getByteFromString(sign, charset), publicKey, charset);
    }
    
    /**
     * 
     * Description：rsa256验签 <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待验签对象Map<String, Object>
     * @param sign 参考签名串String
     * @param publicKey 公钥
     * @param charset 字符集
     * @return 
     * @throws EncryptCommonException
     */
    public static boolean rsa256VerifyMapObject(Map<String, Object> data, String sign, String publicKey, String charset)
            throws EncryptCommonException {
    	return rsa256VerifyMapString(paramsFilter(data), getByteFromString(sign, charset), publicKey, charset);
    }
    
	/**
     * 
     * Description：验签 <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待验签对象Map<String, Object>
     * @param sign 参考签名byte[]
     * @param publicKey 公钥
     * @param charset 字符集
     * @param signType 签名方式
     * @return 
     * @throws EncryptCommonException
     */
    public static boolean rsaVerifyMapObject(Map<String, Object> data, byte[] sign, String publicKey, String charset, String signType)
            throws EncryptCommonException {
    	switch (signType) {
		case SIGN_TYPE_RSA:
			return rsaVerifyMapObject(data, sign, publicKey, charset);
		case SIGN_TYPE_RSA2:
			return rsa256VerifyMapObject(data, sign, publicKey, charset);
		default:
			throw new EncryptCommonException(EncryptCommonError.VERIFY_TYPE_NOT_EXIST_ERROR);
		}
    }
    
    /**
     * 
     * Description：rsa验签 <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待验签对象Map<String, Object>
     * @param sign 参考签名byte[]
     * @param publicKey 公钥
     * @param charset 字符集
     * @return 
     * @throws EncryptCommonException
     */
    public static boolean rsaVerifyMapObject(Map<String, Object> data, byte[] sign, String publicKey, String charset) throws EncryptCommonException {
    	return rsaVerifyMapString(paramsFilter(data), sign, publicKey, charset);
    }
    
    /**
     * 
     * Description：rsa256验签 <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待验签对象Map<String, Object>
     * @param sign 参考签名byte[]
     * @param publicKey 公钥
     * @param charset 字符集
     * @return 
     * @throws EncryptCommonException
     */
	public static boolean rsa256VerifyMapObject(Map<String, Object> data, byte[] sign, String publicKey, String charset) throws EncryptCommonException {
    	return rsa256VerifyMapString(paramsFilter(data), sign, publicKey, charset);
    }
    
    /**
     * 
     * Description：验签 <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待验签对象Map<String, String>
     * @param sign 参考签名串String
     * @param publicKey 公钥
     * @param charset 字符集
     * @param signType 签名方式
     * @return 
     * @throws EncryptCommonException
     */
    public static boolean rsaVerifyMapString(Map<String, String> data, String sign, String publicKey, String charset, String signType)
            throws EncryptCommonException {
    	switch (signType) {
		case SIGN_TYPE_RSA:
			return rsaVerifyMapString(data, sign, publicKey, charset);
		case SIGN_TYPE_RSA2:
			return rsa256VerifyMapString(data, sign, publicKey, charset);
		default:
			throw new EncryptCommonException(EncryptCommonError.VERIFY_TYPE_NOT_EXIST_ERROR);
		}
    }
    
    /**
     * 
     * Description：rsa验签 <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待验签对象Map<String, String>
     * @param sign 参考签名串String
     * @param publicKey 公钥
     * @param charset 字符集
     * @return 
     * @throws EncryptCommonException
     */
    public static boolean rsaVerifyMapString(Map<String, String> data, String sign, String publicKey, String charset)
            throws EncryptCommonException {
    	return rsaVerifyString(createVerifyContent(data), getByteFromString(sign, charset), publicKey, charset);
    }
    
    /**
     * 
     * Description：rsa256验签 <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待验签对象Map<String, String>
     * @param sign 参考签名串String
     * @param publicKey 公钥
     * @param charset 字符集
     * @return 
     * @throws EncryptCommonException
     */
    public static boolean rsa256VerifyMapString(Map<String, String> data, String sign, String publicKey, String charset)
            throws EncryptCommonException {
    	return rsa256VerifyString(createVerifyContent(data), getByteFromString(sign, charset), publicKey, charset);
    }
    
	/**
     * 
     * Description：验签 <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待验签对象Map<String, String>
     * @param sign 参考签名byte[]
     * @param publicKey 公钥
     * @param charset 字符集
     * @param signType 签名方式
     * @return 
     * @throws EncryptCommonException
     */
    public static boolean rsaVerifyMapString(Map<String, String> data, byte[] sign, String publicKey, String charset, String signType)
            throws EncryptCommonException {
    	switch (signType) {
		case SIGN_TYPE_RSA:
			return rsaVerifyMapString(data, sign, publicKey, charset);
		case SIGN_TYPE_RSA2:
			return rsa256VerifyMapString(data, sign, publicKey, charset);
		default:
			throw new EncryptCommonException(EncryptCommonError.VERIFY_TYPE_NOT_EXIST_ERROR);
		}
    }
    
    /**
     * 
     * Description：rsa验签 <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待验签对象Map<String, String>
     * @param sign 参考签名byte[]
     * @param publicKey 公钥
     * @param charset 字符集
     * @return 
     * @throws EncryptCommonException
     */
    public static boolean rsaVerifyMapString(Map<String, String> data, byte[] sign, String publicKey, String charset) throws EncryptCommonException {
    	return rsaVerifyString(createVerifyContent(data), sign, publicKey, charset);
    }
    
    /**
     * 
     * Description：rsa256验签 <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待验签对象Map<String, String>
     * @param sign 参考签名byte[]
     * @param publicKey 公钥
     * @param charset 字符集
     * @return 
     * @throws EncryptCommonException
     */
	public static boolean rsa256VerifyMapString(Map<String, String> data, byte[] sign, String publicKey, String charset) throws EncryptCommonException {
    	return rsa256VerifyString(createVerifyContent(data), sign, publicKey, charset);
    }
    
    /**
     * 
     * Description：验签 <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param content 待验签串String
     * @param sign 参考签名串String
     * @param publicKey 公钥
     * @param charset 字符集
     * @param signType 签名方式
     * @return 
     * @throws EncryptCommonException
     */
    public static boolean rsaVerifyString(String content, String sign, String publicKey, String charset, String signType)
            throws EncryptCommonException {
    	switch (signType) {
		case SIGN_TYPE_RSA:
			return rsaVerifyString(content, sign, publicKey, charset);
		case SIGN_TYPE_RSA2:
			return rsa256VerifyString(content, sign, publicKey, charset);
		default:
			throw new EncryptCommonException(EncryptCommonError.VERIFY_TYPE_NOT_EXIST_ERROR);
		}
    }
    
    /**
     * 
     * Description：rsa验签 <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param content 待验签串String
     * @param sign 参考签名串String
     * @param publicKey 公钥
     * @param charset 字符集
     * @return 
     * @throws EncryptCommonException
     */
    public static boolean rsaVerifyString(String content, String sign, String publicKey, String charset)
            throws EncryptCommonException {
    	return rsaVerifyString(content, getByteFromString(sign, charset), publicKey, charset);
    }
    
    /**
     * 
     * Description：rsa256验签 <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param content 待验签串String
     * @param sign 参考签名串String
     * @param publicKey 公钥
     * @param charset 字符集
     * @return 
     * @throws EncryptCommonException
     */
    public static boolean rsa256VerifyString(String content, String sign, String publicKey, String charset)
            throws EncryptCommonException {
    	return rsa256VerifyString(content, getByteFromString(sign, charset), publicKey, charset);
    }
    
	/**
     * 
     * Description：验签 <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param content 待验签串String
     * @param sign 参考签名byte[]
     * @param publicKey 公钥
     * @param charset 字符集
     * @param signType 签名方式
     * @return 
     * @throws EncryptCommonException
     */
    public static boolean rsaVerifyString(String content, byte[] sign, String publicKey, String charset, String signType)
            throws EncryptCommonException {
    	switch (signType) {
		case SIGN_TYPE_RSA:
			return rsaVerifyString(content, sign, publicKey, charset);
		case SIGN_TYPE_RSA2:
			return rsa256VerifyString(content, sign, publicKey, charset);
		default:
			throw new EncryptCommonException(EncryptCommonError.VERIFY_TYPE_NOT_EXIST_ERROR);
		}
    }
    
    /**
     * 
     * Description：rsa验签 <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param content 待验签串String
     * @param sign 参考签名byte[]
     * @param publicKey 公钥
     * @param charset 字符集
     * @return 
     * @throws EncryptCommonException
     */
    public static boolean rsaVerifyString(String content, byte[] sign, String publicKey, String charset) throws EncryptCommonException {
    	if(StringUtils.isEmpty(charset)) charset = CHARSET_ALG;
    	PublicKey pubKey = getPublicKeyFromX509(SIGN_TYPE_RSA, publicKey);
		try {
			java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);
			signature.initVerify(pubKey);
	        if (StringUtils.isEmpty(charset)) {
	            signature.update(content.getBytes());
	        } else {
	            signature.update(content.getBytes(charset));
	        }
	        return signature.verify(sign);
		} catch (NoSuchAlgorithmException e) {
			throw new EncryptCommonException(EncryptCommonError.VERIFY_TYPE_NOT_EXIST_ERROR);
		} catch (InvalidKeyException e) {
			throw new EncryptCommonException(EncryptCommonError.VERIFY_RSA_PUBKEY_INVALID_ERROR);
		} catch (SignatureException e) {
			throw new EncryptCommonException(EncryptCommonError.VERIFY_SIGNATURE_ERROR);
		} catch (UnsupportedEncodingException e) {
			throw new EncryptCommonException(EncryptCommonError.SYS_CHARSET_UNSUPPORTED_ERROR);
		}
    }
    
    /**
     * 
     * Description：rsa256验签 <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param content 待验签串String
     * @param sign 参考签名byte[]
     * @param publicKey 公钥
     * @param charset 字符集
     * @return 
     * @throws EncryptCommonException
     */
	public static boolean rsa256VerifyString(String content, byte[] sign, String publicKey, String charset) throws EncryptCommonException {
		if(StringUtils.isEmpty(charset)) charset = CHARSET_ALG;
		PublicKey pubKey = getPublicKeyFromX509(SIGN_TYPE_RSA2, publicKey);
		try {
			java.security.Signature signature = java.security.Signature.getInstance(SIGN_SHA256RSA_ALGORITHMS);
			signature.initVerify(pubKey);
	        if (StringUtils.isEmpty(charset)) {
	            signature.update(content.getBytes());
	        } else {
	            signature.update(content.getBytes(charset));
	        }
	        return signature.verify(sign);
		} catch (NoSuchAlgorithmException e) {
			throw new EncryptCommonException(EncryptCommonError.VERIFY_TYPE_NOT_EXIST_ERROR);
		} catch (InvalidKeyException e) {
			throw new EncryptCommonException(EncryptCommonError.VERIFY_RSA_PUBKEY_INVALID_ERROR);
		} catch (SignatureException e) {
			throw new EncryptCommonException(EncryptCommonError.VERIFY_SIGNATURE_ERROR);
		} catch (UnsupportedEncodingException e) {
			throw new EncryptCommonException(EncryptCommonError.SYS_CHARSET_UNSUPPORTED_ERROR);
		}
    }
	
	/**
	 * 
	 * Description：获取公钥 <br/>
	 * Date：2018年8月28日 下午6:29:40　<br/>
	 * Author：lean <br/>
	 * @param algorithm
	 * @param publicKey
	 * @return
	 * @throws EncryptCommonException
	 */
	public static PublicKey getPublicKeyFromX509(String algorithm, String publicKey) throws EncryptCommonException {
		if (StringUtils.isEmpty(algorithm) || StringUtils.isEmpty(publicKey)) return null;
		try {
			KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
			byte[] encodedKey = CodeUtils.decodeBase64Byte(publicKey);
	        return keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
		} catch (NoSuchAlgorithmException e) {
			throw new EncryptCommonException(EncryptCommonError.VERIFY_TYPE_NOT_EXIST_ERROR);
		} catch (InvalidKeySpecException e1) {
			throw new EncryptCommonException(EncryptCommonError.VERIFY_RSA_PUBKEY_INVALID_ERROR);
		} catch (Exception e2) {
			throw new EncryptCommonException(EncryptCommonError.VERIFY_RSA_PUBKEY_GET_ERROR);
		}
    }
	
	/**
	 * 
	 * Description：组装待验签值[空值不计入] <br/>
	 * Date：2018年8月28日 下午6:37:38　<br/>
	 * Author：lean <br/>
	 * @param params
	 * @return
	 * @throws EncryptCommonException 
	 */
	public static String createVerifyContent(Map<String, String> params) throws EncryptCommonException {
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
            throw new EncryptCommonException(EncryptCommonError.VERIFY_RSA_CONTENT_GET_ERROR);
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
            throw new EncryptCommonException(EncryptCommonError.VERIFY_RSA_PARAM_FILTER_ERROR);
        }
    }
	
	/**
	 * 
	 * Description：字符串转数组 <br/>
	 * Date：2018年8月29日 上午9:59:57　<br/>
	 * Author：lean <br/>
	 * @param content
	 * @param charset
	 * @return
	 * @throws EncryptCommonException
	 */
	private static byte[] getByteFromString(String content, String charset) throws EncryptCommonException {
    	if(StringUtils.isEmpty(charset)) charset = CHARSET_ALG;
    	try {
			return content.getBytes(charset);
		} catch (UnsupportedEncodingException e) {
			throw new EncryptCommonException(EncryptCommonError.SYS_CHARSET_UNSUPPORTED_ERROR);
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
