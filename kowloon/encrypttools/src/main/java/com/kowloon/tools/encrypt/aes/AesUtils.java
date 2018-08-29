package com.kowloon.tools.encrypt.aes;

import java.security.MessageDigest;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;


public class AesUtils {
	
	public static final String CHARSET_ALG = "UTF-8";
	
	public static final String AES_ALG = "AES";
    /** AES算法 */
    private static final String AES_CBC_PCK_ALG = "AES/ECB/PKCS7Padding";
    
    private static final String PROVIDER_ALG = "BC";
	
	static{
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
	}
	
	/**
	 * 
	 * Description：加密(结果base64转码) <br/>
	 * Date：2018年6月27日 上午9:14:48　<br/>
	 * Author：lean <br/>
	 * @param originString 待加密串
	 * @param encryptKey 密钥
	 * @param charset 字符集
	 * @param md5 是否先对key先进行加密
	 * @return
	 * @throws Exception
	 */
	public static String aesEncryptByString(String originString, String encryptKey, String charset, boolean md5) throws Exception{
		if(StringUtils.isEmpty(charset)) charset = CHARSET_ALG;
		if(md5) encryptKey = MD5Encode(encryptKey, charset).toLowerCase();
		SecretKeySpec skeySpec = new SecretKeySpec(encryptKey.getBytes(charset), AES_ALG);
		Cipher cipher = Cipher.getInstance(AES_CBC_PCK_ALG, PROVIDER_ALG);
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encryptBytes = cipher.doFinal(originString.getBytes(charset));
        return base64EncodeToString(encryptBytes);
	}
	
	/**
	 * 
	 * Description：加密(结果base64转码) <br/>
	 * Date：2018年6月27日 上午9:14:48　<br/>
	 * Author：lean <br/>
	 * @param originByte 待加密byte
	 * @param encryptKey 密钥
	 * @param charset 字符集
	 * @param md5 是否先对key先进行加密
	 * @return
	 * @throws Exception
	 */
	public static String aesEncryptByByte(byte[] originByte, String encryptKey, String charset, boolean md5) throws Exception{
		if(StringUtils.isEmpty(charset)) charset = CHARSET_ALG;
		if(md5) encryptKey = MD5Encode(encryptKey, charset).toLowerCase();
		SecretKeySpec skeySpec = new SecretKeySpec(encryptKey.getBytes(charset), AES_ALG);
		Cipher cipher = Cipher.getInstance(AES_CBC_PCK_ALG, PROVIDER_ALG);
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encryptBytes = cipher.doFinal(originByte);
        return base64EncodeToString(encryptBytes);
	}
	
	/**
	 * 
	 * Description：aes解密 <br/>
	 * Date：2018年6月27日 上午8:59:22　<br/>
	 * Author：lean <br/>
	 * @param encryptContent 加密串 
	 * @param decryptKey 密钥
	 * @param charset 字符集
	 * @param md5 是否先对key进行md5加密
	 * @return
	 * @throws Exception
	 */
	public static String aesDecryptByString(String encryptString, String decryptKey, String charset, boolean md5) throws Exception {
		if(StringUtils.isEmpty(charset)) charset = CHARSET_ALG;
		byte[] encryptByte = base64DecodeToByte(encryptString);
		if(md5) decryptKey = MD5Encode(decryptKey, charset).toLowerCase();
		SecretKeySpec skeySpec = new SecretKeySpec(decryptKey.getBytes(charset), AES_ALG);
		Cipher cipher = Cipher.getInstance(AES_CBC_PCK_ALG, PROVIDER_ALG);
		cipher.init(Cipher.DECRYPT_MODE, skeySpec);
		byte[] original = cipher.doFinal(encryptByte);
		return new String(original, charset);
	}
	
	/**
	 * 
	 * Description：aes解密 <br/>
	 * Date：2018年6月27日 上午8:58:12　<br/>
	 * Author：lean <br/>
	 * @param encryptBytes 加密数据
	 * @param decryptKey 密钥
	 * @param charset 字符集
	 * @param base64 是否先base64解密(若为false说明传入的加密串已经进行过base64解密)
	 * @param md5 是否先对key进行md5加密
	 * @return
	 * @throws Exception
	 */
	public static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey, String charset, boolean base64, boolean md5) throws Exception {
		if(StringUtils.isEmpty(charset)) charset = CHARSET_ALG;
		if(base64) encryptBytes = base64DecodeToByte(encryptBytes);
		if(md5) decryptKey = MD5Encode(decryptKey, charset).toLowerCase();
		SecretKeySpec skeySpec = new SecretKeySpec(decryptKey.getBytes(charset), AES_ALG);
		Cipher cipher = Cipher.getInstance(AES_CBC_PCK_ALG, PROVIDER_ALG);
		cipher.init(Cipher.DECRYPT_MODE, skeySpec);
		byte[] original = cipher.doFinal(encryptBytes);
		return new String(original,charset);
	}

	/**
	 * 
	 * Description：base64解密 <br/>
	 * Date：2018年6月27日 上午9:00:57　<br/>
	 * Author：lean <br/>
	 * @param base64String base64加密串
	 * @return byte
	 * @throws Exception
	 */
	public static byte[] base64DecodeToByte(String base64String) throws Exception {
		return Base64.decodeBase64(base64String);
	}

	/**
	 * 
	 * Description：base64解密 <br/>
	 * Date：2018年6月27日 上午9:52:38　<br/>
	 * Author：lean <br/>
	 * @param base64Byte 待解密byte
	 * @return byte
	 * @throws Exception
	 */
	public static byte[] base64DecodeToByte(byte[] base64Byte) throws Exception {
		return Base64.decodeBase64(base64Byte);
	}
	
	/**
	 * 
	 * Description：base64解密 <br/>
	 * Date：2018年6月27日 上午9:00:57　<br/>
	 * Author：lean <br/>
	 * @param base64String base64加密串
	 * @param charset 字符集
	 * @return 字符串
	 * @throws Exception
	 */
	public static String base64DecodeToString(String base64String, String charset) throws Exception {
		if(StringUtils.isEmpty(charset)) charset = CHARSET_ALG;
		return new String(Base64.decodeBase64(base64String), charset);
	}
	
	/**
	 * 
	 * Description：base64解密 <br/>
	 * Date：2018年6月27日 上午9:00:57　<br/>
	 * Author：lean <br/>
	 * @param base64String 加密byte
	 * @param charset 字符集
	 * @return 字符串
	 * @throws Exception
	 */
	public static String base64DecodeToString(byte[] base64Byte, String charset) throws Exception {
		if(StringUtils.isEmpty(charset)) charset = CHARSET_ALG;
		return new String(Base64.decodeBase64(base64Byte), charset);
	}
	
	/**
	 * 
	 * Description：base64加密 <br/>
	 * Date：2018年6月27日 上午9:13:03　<br/>
	 * Author：lean <br/>
	 * @param base64Byte 待加密byte
	 * @return base64加密byte
	 * @throws Exception
	 */
	public static byte[] base64EncodeToByte(byte[] base64Byte) throws Exception {
		return Base64.encodeBase64(base64Byte);
	}
	
	/**
	 * 
	 * Description：base64加密 <br/>
	 * Date：2018年6月27日 上午9:24:44　<br/>
	 * Author：lean <br/>
	 * @param base64Byte 待加密byte
	 * @return base64加密串
	 * @throws Exception
	 */
	public static String base64EncodeToString(byte[] base64Byte) throws Exception {
		return Base64.encodeBase64String(base64Byte);
	}
	
	/**
	 * 
	 * Description：base64加密 <br/>
	 * Date：2018年6月27日 上午9:13:03　<br/>
	 * Author：lean <br/>
	 * @param base64String 待加密串
	 * @return base64加密byte
	 * @throws Exception
	 */
	public static byte[] base64EncodeToByte(String base64String, String charset) throws Exception {
		if(StringUtils.isEmpty(charset)) charset = CHARSET_ALG;
		return Base64.encodeBase64(base64String.getBytes(charset));
	}
	
	/**
	 * 
	 * Description：base64加密 <br/>
	 * Date：2018年6月27日 上午9:29:12　<br/>
	 * Author：lean <br/>
	 * @param base64String 待加密串
	 * @param charset 字符集
	 * @return base64加密串
	 * @throws Exception
	 */
	public static String base64EncodeToString(String base64String, String charset) throws Exception {
		if(StringUtils.isEmpty(charset)) charset = CHARSET_ALG;
		return Base64.encodeBase64String(base64String.getBytes(charset));
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
	public static String MD5Encode(String origin, String charset) throws Exception {
		if(StringUtils.isEmpty(charset)) charset = CHARSET_ALG;
		String resultString = new String(origin);
		MessageDigest md = MessageDigest.getInstance("MD5");
		resultString = byteArrayToHexString(md.digest(resultString.getBytes(charset)));
		return resultString;
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
	
	public static void main(String[] args) {
		byte[] bytes;
		try {
			String key = "1234567890abcdef1234567890abcdef";
			String content = "m+cqC5OWNek/jGSeSFjMwxqoQmt9x/XQEPRosjYHR2a6kosdkuS2hFlt1QP/ykVOCm6PXnC0tOc7gsPzP3aG4Hhn7wJwJAvMhSUJhOAOlnXtHupbyiwb9vNgqAwcSr04U1yoI8UemDCz+TnIsbldurZh6UKtDqSutp/KiutgJ/9crss+fh9hy9UcBKO60JkJgka79q6lkQoOKZh3kIHrFEZGFKcvCOJzx/heVtz8AHGoB/IuNV4Mh280FZM1TTe8V54eXgqHNAOdJCoYQuKu34tepA+a4sjCcPOmNU5wLCjEFQ/+w7Ad8U2i3bfaA713DPk5qV8IVSB1cMGZj+zZBGPT4OWBg0vZD4ZJCydf93e95CbxV7FuSPiFnZwjvsHBCA7DNGoAfSx72p5ZBcyCTFV9y4O9xTukHUmJNI8XK+JhR5Imz9u5422lfN5FcM6g4WdLDTVO/DiN4chaTUk9uqEiMqD2Bn3+ZWe/R91YDW8koG3qd7m/9y7sckptNQWU9fi+zk/AbCLHETiUIj4dtFxsZRTBUFIEmSl2ebcPEdowOLzjUe2uW/Qr8dDwFuWGsSYawYnsbsxliNc5DthzhcdB9MDkOab6hckUIC7639s6DKFP44Olgjc+tt5EfDpNxK0rHh4rhlCz9h5ZhzI7CVqJRx5pCLEBaJKntPeF9IWfj92VYMY7o8TesmqhiDWnGVGSK8vXDsQMAWIhHi2STvdVAZkaOTzF+cxVJsUgy2zVlGhNzlqjQZmLoXZ/Kiid7cfUQvg/Bqw4We6KRrAfTHplwjbghjVzqWsgJv8KI3cYjFJEtTy19a0z3yBrcthtjszmBEUyUG/d4O0DzGEG+JNB4VsMz/jWUJ2d2uJmpyvngyt5RkafRH4mCHWkNTPz5UCBZtJbvFzQ/VB/X077Apwgk7lfgULu1uVF9N108kRKQcrqoGEH/oZ6lo0wIXbITx+7lr91eMvu4JgGPSQW4MKbluSa28iwkE5YcnQbYd0=";
			/** 微信解密流程.所有步骤单独做*/
			System.out.println("**************微信解密流程.所有步骤单独做**************");
			//1.对加密串A做base64解码，得到加密串B
			bytes = base64DecodeToByte(content);
			//2.取商户key的md5值，小写
			String md5Key = MD5Encode("1234567890abcdef1234567890abcdef", CHARSET_ALG).toLowerCase();
			//3.用key*对加密串B做AES-256-ECB解密（PKCS7Padding）
			String decryptStr = aesDecryptByBytes(bytes, md5Key, CHARSET_ALG, false, false);
			System.out.println(decryptStr);
			System.out.println("**************微信解密流程.所有步骤合并一个方法做**************");
			String decryptStr2 = aesDecryptByString(content, key, CHARSET_ALG, true);
			System.out.println(decryptStr2);
			System.out.println("**************自加密自解密**************");
			String origin = "<root><out_refund_no><![CDATA[123]]></out_refund_no><out_trade_no><![CDATA[abc]]></out_trade_no><refund_account><![CDATA[REFUND_SOURCE_UNSETTLED_FUNDS]]></refund_account><refund_fee><![CDATA[1]]></refund_fee><refund_id><![CDATA[50000303712017072701466990000]]></refund_id><refund_recv_accout><![CDATA[用户零钱]]></refund_recv_accout><refund_request_source><![CDATA[API]]></refund_request_source><refund_status><![CDATA[SUCCESS]]></refund_status><settlement_refund_fee><![CDATA[1]]></settlement_refund_fee><settlement_total_fee><![CDATA[1]]></settlement_total_fee><success_time><![CDATA[2017-07-27 00:33:09]]></success_time><total_fee><![CDATA[1]]></total_fee><transaction_id><![CDATA[4005302001201707272838220000]]></transaction_id></root>";
			System.out.println("源:"+origin);
			System.out.println("**************(md5)**************");
			String encryptString = aesEncryptByString(origin, key, CHARSET_ALG, true);
			System.out.println("加密串(md5):"+encryptString);
			System.out.println("比较:"+encryptString.equals(content));
			
			String decryptString = aesDecryptByString(encryptString, key, CHARSET_ALG, true);
			System.out.println("解密串(md5,内部base64):"+decryptString);
			System.out.println("比较(md5,内部base64):"+decryptString.equals(origin));
			
			byte[] encryptByte = base64DecodeToByte(encryptString);
			String decryptString1 = aesDecryptByBytes(encryptByte, key, CHARSET_ALG, false, true);
			System.out.println("解密串(md5,外部base64):"+decryptString1);
			System.out.println("比较(md5,外部base64):"+decryptString1.equals(origin));
			
			System.out.println("****************************");
			String encryptString1 = aesEncryptByString(origin, key, CHARSET_ALG, false);
			System.out.println("加密串:"+encryptString1);
			String decryptString2 = aesDecryptByString(encryptString1, key, CHARSET_ALG, false);
			System.out.println("解密串(内部base64):"+decryptString2);
			System.out.println("比较(内部base64):"+decryptString2.equals(origin));
			
			byte[] encryptByte1 = base64DecodeToByte(encryptString1);
			String decryptString3 = aesDecryptByBytes(encryptByte1, key, CHARSET_ALG, false, false);
			System.out.println("解密串(外部base64):"+decryptString3);
			System.out.println("比较(外部base64):"+decryptString3.equals(origin));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
