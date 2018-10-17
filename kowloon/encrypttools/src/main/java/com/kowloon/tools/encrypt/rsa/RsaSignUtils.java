
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
import java.security.PrivateKey;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
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
public class RsaSignUtils {
	
	public static final String CHARSET_ALG = "UTF-8";
	
	//签名相关属性值
    public static final String SIGN = "sign";
    public static final String SIGN_TYPE = "sign_type";
    public static final String SIGN_TYPE_RSA = "RSA";
    /** sha256WithRsa 算法请求类型 */
    public static final String SIGN_TYPE_RSA2 = "RSA2";
    public static final String SIGN_ALGORITHMS = "SHA1WithRSA";
    public static final String SIGN_SHA256RSA_ALGORITHMS = "SHA256WithRSA";
	
    /**
     * 
     * Description：签名[结果base64加密] <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待签名对象Map<String, Object>
     * @param privateKey 密钥
     * @param charset 字符集
     * @param signType 签名方式
     * @return base64编码后的签名
     * @throws EncryptCommonException
     */
    public static String rsaSignBase64MapObject(Map<String, Object> data, String privateKey, String charset, String signType)
            throws EncryptCommonException {
        switch (signType) {
		case SIGN_TYPE_RSA:
			return rsaSignBase64MapObject(data, privateKey, charset);
		case SIGN_TYPE_RSA2:
			return rsa256SignBase64MapObject(data, privateKey, charset);
		default:
			throw new EncryptCommonException(EncryptCommonError.SIGN_TYPE_NOT_EXIST_ERROR);
		}
    }
    
    /**
     * 
     * Description：rsa签名[结果base64加密] <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待签名对象Map<String, Object>
     * @param privateKey 密钥
     * @param charset 字符集
     * @param signType 签名方式
     * @return base64编码后的签名
     * @throws EncryptCommonException
     */
    public static String rsaSignBase64MapObject(Map<String, Object> data, String privateKey, String charset) throws EncryptCommonException {
    	if(StringUtils.isEmpty(charset)) charset = CHARSET_ALG;
    	return CodeUtils.encodeBase64String(rsaSignMapObject(data, privateKey, charset));
    }
    
    /**
     * 
     * Description：rsa256签名[结果base64加密] <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待签名对象Map<String, Object>
     * @param privateKey 密钥
     * @param charset 字符集
     * @param signType 签名方式
     * @return base64编码后的签名
     * @throws EncryptCommonException
     */
    public static String rsa256SignBase64MapObject(Map<String, Object> data, String privateKey, String charset) throws EncryptCommonException {
    	if(StringUtils.isEmpty(charset)) charset = CHARSET_ALG;
    	return CodeUtils.encodeBase64String(rsa256SignMapObject(data, privateKey, charset));
    }
    
    /**
     * 
     * Description：签名[结果base64加密] <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待签名对象Map<String, String>
     * @param privateKey 密钥
     * @param charset 字符集
     * @param signType 签名方式
     * @return base64编码后的签名
     * @throws EncryptCommonException
     */
    public static String rsaSignBase64MapString(Map<String, String> data, String privateKey, String charset, String signType)
            throws EncryptCommonException {
        switch (signType) {
		case SIGN_TYPE_RSA:
			return rsaSignBase64MapString(data, privateKey, charset);
		case SIGN_TYPE_RSA2:
			return rsa256SignBase64MapString(data, privateKey, charset);
		default:
			throw new EncryptCommonException(EncryptCommonError.SIGN_TYPE_NOT_EXIST_ERROR);
		}
    }
    
    /**
     * 
     * Description：rsa签名[结果base64加密] <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待签名对象Map<String, String>
     * @param privateKey 密钥
     * @param charset 字符集
     * @param signType 签名方式
     * @return base64编码后的签名
     * @throws EncryptCommonException
     */
    public static String rsaSignBase64MapString(Map<String, String> data, String privateKey, String charset) throws EncryptCommonException {
    	if(StringUtils.isEmpty(charset)) charset = CHARSET_ALG;
    	return CodeUtils.encodeBase64String(rsaSignMapString(data, privateKey, charset));
    }
    
    /**
     * 
     * Description：rsa256签名[结果base64加密] <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待签名对象Map<String, String>
     * @param privateKey 密钥
     * @param charset 字符集
     * @param signType 签名方式
     * @return base64编码后的签名
     * @throws EncryptCommonException
     */
    public static String rsa256SignBase64MapString(Map<String, String> data, String privateKey, String charset) throws EncryptCommonException {
    	if(StringUtils.isEmpty(charset)) charset = CHARSET_ALG;
    	return CodeUtils.encodeBase64String(rsa256SignMapString(data, privateKey, charset));
    }
    
    /**
     * 
     * Description：签名[结果base64加密] <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待签名串String
     * @param privateKey 密钥
     * @param charset 字符集
     * @param signType 签名方式
     * @return base64编码后的签名
     * @throws EncryptCommonException
     */
    public static String rsaSignBase64String(String content, String privateKey, String charset, String signType)
            throws EncryptCommonException {
        switch (signType) {
		case SIGN_TYPE_RSA:
			return rsaSignBase64String(content, privateKey, charset);
		case SIGN_TYPE_RSA2:
			return rsa256SignBase64String(content, privateKey, charset);
		default:
			throw new EncryptCommonException(EncryptCommonError.SIGN_TYPE_NOT_EXIST_ERROR);
		}
    }
    
    /**
     * 
     * Description：rsa签名[结果base64加密] <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param content 待签名串String
     * @param privateKey 密钥
     * @param charset 字符集
     * @param signType 签名方式
     * @return base64编码后的签名
     * @throws EncryptCommonException
     */
    public static String rsaSignBase64String(String content, String privateKey, String charset) throws EncryptCommonException {
    	if(StringUtils.isEmpty(charset)) charset = CHARSET_ALG;
    	return CodeUtils.encodeBase64String(rsaSignString(content, privateKey, charset));
    }
    
    /**
     * 
     * Description：rsa256签名[结果base64加密] <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待签名串String
     * @param privateKey 密钥
     * @param charset 字符集
     * @return base64编码后的签名
     * @throws EncryptCommonException
     */
    public static String rsa256SignBase64String(String content, String privateKey, String charset) throws EncryptCommonException {
    	if(StringUtils.isEmpty(charset)) charset = CHARSET_ALG;
    	return CodeUtils.encodeBase64String(rsa256SignString(content, privateKey, charset));
    }
    
    /**
     * 
     * Description：签名 <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待签名对象Map<String, Object>
     * @param privateKey 密钥
     * @param charset 字符集
     * @param signType 签名方式
     * @return 签名byte[]
     * @throws EncryptCommonException
     */
    public static byte[] rsaSignMapObject(Map<String, Object> data, String privateKey, String charset, String signType)
            throws EncryptCommonException {
    	switch (signType) {
		case SIGN_TYPE_RSA:
			return rsaSignMapObject(data, privateKey, charset);
		case SIGN_TYPE_RSA2:
			return rsa256SignMapObject(data, privateKey, charset);
		default:
			throw new EncryptCommonException(EncryptCommonError.SIGN_TYPE_NOT_EXIST_ERROR);
		}
    }
    
    /**
     * 
     * Description：rsa签名 <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待签名对象Map<String, Object>
     * @param privateKey 密钥
     * @param charset 字符集
     * @param signType 签名方式
     * @return 签名byte[]
     * @throws EncryptCommonException
     */
    public static byte[] rsaSignMapObject(Map<String, Object> data, String privateKey, String charset) throws EncryptCommonException {
    	if(StringUtils.isEmpty(charset)) charset = CHARSET_ALG;
    	return rsaSignMapString(paramsFilter(data), privateKey, charset);
    }
    
    /**
     * 
     * Description：rsa256签名 <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待签名对象Map<String, Object>
     * @param privateKey 密钥
     * @param charset 字符集
     * @param signType 签名方式
     * @return 签名byte[]
     * @throws EncryptCommonException
     */
    public static byte[] rsa256SignMapObject(Map<String, Object> data, String privateKey, String charset) throws EncryptCommonException {
    	if(StringUtils.isEmpty(charset)) charset = CHARSET_ALG;
    	return rsa256SignMapString(paramsFilter(data), privateKey, charset);
    }
    
    /**
     * 
     * Description：签名 <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待签名对象Map<String, String>
     * @param privateKey 密钥
     * @param charset 字符集
     * @param signType 签名方式
     * @return 签名byte[]
     * @throws EncryptCommonException
     */
    public static byte[] rsaSignMapString(Map<String, String> data, String privateKey, String charset, String signType)
            throws EncryptCommonException {
        switch (signType) {
		case SIGN_TYPE_RSA:
			return rsaSignMapString(data, privateKey, charset);
		case SIGN_TYPE_RSA2:
			return rsa256SignMapString(data, privateKey, charset);
		default:
			throw new EncryptCommonException(EncryptCommonError.SIGN_TYPE_NOT_EXIST_ERROR);
		}
    }
    
    /**
     * 
     * Description：rsa签名 <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待签名对象Map<String, String>
     * @param privateKey 密钥
     * @param charset 字符集
     * @param signType 签名方式
     * @return 签名byte[]
     * @throws EncryptCommonException
     */
    public static byte[] rsaSignMapString(Map<String, String> data, String privateKey, String charset) throws EncryptCommonException {
    	if(StringUtils.isEmpty(charset)) charset = CHARSET_ALG;
    	return rsaSignString(createSignContent(data), privateKey, charset);
    }
    
    /**
     * 
     * Description：rsa256签名 <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待签名对象Map<String, String>
     * @param privateKey 密钥
     * @param charset 字符集
     * @param signType 签名方式
     * @return 签名byte[]
     * @throws EncryptCommonException
     */
    public static byte[] rsa256SignMapString(Map<String, String> data, String privateKey, String charset) throws EncryptCommonException {
    	if(StringUtils.isEmpty(charset)) charset = CHARSET_ALG;
    	return rsa256SignString(createSignContent(data), privateKey, charset);
    }
    
    /**
     * 
     * Description：签名 <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待签名串String
     * @param privateKey 密钥
     * @param charset 字符集
     * @param signType 签名方式
     * @return 签名byte[]
     * @throws EncryptCommonException
     */
    public static byte[] rsaSignString(String content, String privateKey, String charset, String signType)
            throws EncryptCommonException {
    	switch (signType) {
		case SIGN_TYPE_RSA:
			return rsaSignString(content, privateKey, charset);
		case SIGN_TYPE_RSA2:
			return rsa256SignString(content, privateKey, charset);
		default:
			throw new EncryptCommonException(EncryptCommonError.SIGN_TYPE_NOT_EXIST_ERROR);
		}
    }
    
    /**
     * 
     * Description：rsa签名 <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待签名串String
     * @param privateKey 密钥
     * @param charset 字符集
     * @param signType 签名方式
     * @return 签名byte[]
     * @throws EncryptCommonException
     */
    public static byte[] rsaSignString(String content, String privateKey, String charset) throws EncryptCommonException {
    	if(StringUtils.isEmpty(charset)) charset = CHARSET_ALG;
    	PrivateKey priKey = getPrivateKeyFromPKCS8(SIGN_TYPE_RSA, privateKey);
		try {
			java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);
			signature.initSign(priKey);
	        if (StringUtils.isEmpty(charset)) {
	            signature.update(content.getBytes());
	        } else {
	            signature.update(content.getBytes(charset));
	        }
	        return signature.sign();
		} catch (NoSuchAlgorithmException e) {
			throw new EncryptCommonException(EncryptCommonError.SIGN_TYPE_NOT_EXIST_ERROR);
		} catch (InvalidKeyException e) {
			throw new EncryptCommonException(EncryptCommonError.SIGN_RSA_PRIKEY_INVALID_ERROR);
		} catch (SignatureException e) {
			throw new EncryptCommonException(EncryptCommonError.SIGN_SIGNATURE_ERROR);
		} catch (UnsupportedEncodingException e) {
			throw new EncryptCommonException(EncryptCommonError.SYS_CHARSET_UNSUPPORTED_ERROR);
		}
    }
    
    /**
     * 
     * Description：rsa256签名 <br/>
     * Date：2018年8月28日 下午7:11:29　<br/>
     * Author：lean <br/>
     * @param data 待签名串String
     * @param privateKey 密钥
     * @param charset 字符集
     * @param signType 签名方式
     * @return 签名byte[]
     * @throws EncryptCommonException
     */
	public static byte[] rsa256SignString(String content, String privateKey, String charset) throws EncryptCommonException {
		if(StringUtils.isEmpty(charset)) charset = CHARSET_ALG;
		PrivateKey priKey = getPrivateKeyFromPKCS8(SIGN_TYPE_RSA2, privateKey);
		try {
			java.security.Signature signature = java.security.Signature.getInstance(SIGN_SHA256RSA_ALGORITHMS);
			signature.initSign(priKey);
	        if (StringUtils.isEmpty(charset)) {
	            signature.update(content.getBytes());
	        } else {
	            signature.update(content.getBytes(charset));
	        }
	        return signature.sign();
		} catch (NoSuchAlgorithmException e) {
			throw new EncryptCommonException(EncryptCommonError.SIGN_TYPE_NOT_EXIST_ERROR);
		} catch (InvalidKeyException e) {
			throw new EncryptCommonException(EncryptCommonError.SIGN_RSA_PRIKEY_INVALID_ERROR);
		} catch (SignatureException e) {
			throw new EncryptCommonException(EncryptCommonError.SIGN_SIGNATURE_ERROR);
		} catch (UnsupportedEncodingException e) {
			throw new EncryptCommonException(EncryptCommonError.SYS_CHARSET_UNSUPPORTED_ERROR);
		}
        
    }
	
	/**
	 * 
	 * Description：获取私钥 <br/>
	 * Date：2018年8月28日 下午6:29:40　<br/>
	 * Author：lean <br/>
	 * @param algorithm
	 * @param privateKey
	 * @return
	 * @throws EncryptCommonException
	 */
	public static PrivateKey getPrivateKeyFromPKCS8(String algorithm, String privateKey) throws EncryptCommonException {
		if (StringUtils.isEmpty(algorithm) || StringUtils.isEmpty(privateKey)) return null;
		try {
			KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
			byte[] encodedKey = CodeUtils.decodeBase64Byte(privateKey);
	        return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(encodedKey));
		} catch (NoSuchAlgorithmException e) {
			throw new EncryptCommonException(EncryptCommonError.SIGN_TYPE_NOT_EXIST_ERROR);
		} catch (InvalidKeySpecException e1) {
			throw new EncryptCommonException(EncryptCommonError.SIGN_RSA_PRIKEY_INVALID_ERROR);
		} catch (Exception e2) {
			throw new EncryptCommonException(EncryptCommonError.SIGN_RSA_PRIKEY_GET_ERROR);
		}
    }
	
	/**
	 * 
	 * Description：组装加密串[空值不计入] <br/>
	 * Date：2018年8月28日 下午6:37:38　<br/>
	 * Author：lean <br/>
	 * @param params
	 * @return
	 * @throws CommonException 
	 */
	public static String createSignContentMapObject(Map<String, Object> params) throws EncryptCommonException {
		return createSignContent(paramsFilter(params));
	}
	
	/**
	 * 
	 * Description：组装加密串[空值不计入] <br/>
	 * Date：2018年8月28日 下午6:37:38　<br/>
	 * Author：lean <br/>
	 * @param params
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
	        for (int i = 0; i < keys.size(); ++i) {
	            String key = keys.get(i);
	            String value = String.valueOf(params.get(key));
	            if (isNotEmpty(key, value) && !SIGN.equals(key) && !SIGN_TYPE.equals(key)) {
	            	if (sb.length() > 0) sb.append("&");
	            	sb.append(key).append("=").append(value);
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
    
    /**
     * 
     * Description：格式化字符集 <br/>
     * Date：2018年8月29日 上午11:40:18　<br/>
     * Author：lean <br/>
     * @param charSet
     * @return
     */
    public static String formatCharSet(String charset){
    	if(StringUtils.isEmpty(charset)) charset = CHARSET_ALG;
    	return charset;
    }
    
    /**
     * 
     * Description：字节数组转字符串 <br/>
     * Date：2018年8月29日 上午11:38:30　<br/>
     * Author：lean <br/>
     * @param content
     * @param charset
     * @return
     * @throws EncryptCommonException
     */
    public static String getStringFromByte(byte[] content, String charset) throws EncryptCommonException {
    	if(StringUtils.isEmpty(charset)) charset = CHARSET_ALG;
    	try {
			return new String(content, charset);
		} catch (UnsupportedEncodingException e) {
			throw new EncryptCommonException(EncryptCommonError.SYS_CHARSET_UNSUPPORTED_ERROR);
		}
	}

    public static void main(String[] args) {

	}

}
