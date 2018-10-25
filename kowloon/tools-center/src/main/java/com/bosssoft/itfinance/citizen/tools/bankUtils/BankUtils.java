
/**   
 * Title：BankBinUtils.java 　<br/>
 * Package：com.bosssoft.itfinance.citizen.channel.core.utils.bankUtils 　<br/>
 * Description：<br/>
 * Data：2018年2月1日 下午4:13:46<br/>
 * @author lean
 * @copyright  Corporation 2018    
 * @version v1.0 
 */
package com.bosssoft.itfinance.citizen.tools.bankUtils;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;

/**
 * ClassName：com.bosssoft.itfinance.citizen.channel.core.utils.bankUtils.BankBinUtils　　<br/>
 * Description：银行卡bin工具类<br/>
 * Date：2018年2月1日 下午4:13:46<br/>
 * @author lean
 * @version 1.0
 */
public class BankUtils {

	/**
	 * 
	 * Description：根据银行卡号获得所属总行编码 <br/>
	 * Date：2018年2月1日 下午7:59:07　<br/>
	 * Author：lean <br/>
	 * @param cardNo
	 * @return
	 */
	public static String getBankCode(String cardNo){
		try {
			ResourceBundle bundle = ResourceBundle.getBundle("com.bosssoft.itfinance.citizen.channel.core.utils.bankUtils.cardBin");
			Enumeration<String> keyList =  bundle.getKeys();
			if(StringUtils.isEmpty(cardNo)) return null;
			while(keyList.hasMoreElements()){
	            String key = (String)keyList.nextElement();
	            String[] info  = key.split("_");
	            String head = info[0];//卡bin标准
	            int lenght = Integer.valueOf(info[1]);//卡bin长度
	            if(head.equals(cardNo.substring(0, lenght))){
	            	return bundle.getString(key).split("_")[0];
	            }
	        }
			return null;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 
	 * Description：根据银行卡号获得所属总行编码以及总行名称 <br/>
	 * Date：2018年2月1日 下午7:58:58　<br/>
	 * Author：lean <br/>
	 * @param cardNo
	 * @return
	 */
	public static String[] getBankCodeAndName(String cardNo){
		try {
			if(StringUtils.isEmpty(cardNo)) return null;
			ResourceBundle bundle = ResourceBundle.getBundle("com.bosssoft.itfinance.citizen.channel.core.utils.bankUtils.cardBin");
			Enumeration<String> keyList = bundle.getKeys();
			while(keyList.hasMoreElements()){
	            String key = (String)keyList.nextElement();
	            String[] info  = key.split("_");
	            String head = info[0];
	            int lenght = Integer.valueOf(info[1]) ;
	            if(head.equals(cardNo.substring(0, lenght))){
	            	String bankInfo[] = new String[2];
	            	bankInfo[0] = bundle.getString(key).split("_")[0];
	            	bankInfo[1] = formatterName(bundle.getString(key).split("_")[1]);
	            	return bankInfo;
	            }
	        }
			return null;
		}catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 
	 * Description：格式化中文 <br/>
	 * Date：2018年2月1日 下午7:58:39　<br/>
	 * Author：lean <br/>
	 * @param bankName
	 * @return
	 */
	public static String formatterName(String bankName){
		try {
			return new String(bankName.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	/**
	 * 校验规则：通过Luhn算法来验证通过。  
	 * 该校验的过程：
	 * 1、从卡号最后一位数字开始，逆向将奇数位(1、3、5等等)相加。
	 * 2、从卡号最后一位数字开始，逆向将偶数位数字，先乘以2（如果乘积为两位数，则将其减去9），再求和。  
	 * 3、将奇数位总和加上偶数位总和，结果应该可以被10整除。  
	 * 例如，卡号是：5432123456788881  
	 * 逆向奇数位和=35  (1+8+8+6+4+2+2+4)
	 * 逆向偶数位乘以2   (16+16+14+10+6+2+6+10)
	 * 逆向偶数位乘以2(乘积为两位数减去9)   (7+7+5+1+6+2+6+1)
	 * 逆向偶数位乘以2(乘积为两位数减去9)求和的结果=35  (7+7+5+1+6+2+6+1)  
	 * 最后35+35=70 可以被10整除，认定校验通过。
	 */ 
	
	/**
	 * 
	 * Description：Luhn算法验证卡号 <br/>
	 * Date：2018年2月1日 下午8:00:10　<br/>
	 * Author：lean <br/>
	 * @param cardId
	 * @return
	 */
	public static boolean checkBankCardByLuhn(String cardId){
	    if(cardId == null || cardId.trim().length() == 0 || !cardId.matches("\\d+")) {    
	        //如果传的不是数据返回N    
	        return false;
	    }    
	    char[] chs = cardId.trim().toCharArray();
	    int luhmSum = 0;
	    for(int i = chs.length - 1, j = 0; i >= 0; i--, j++) {    
	        int k = chs[i] - '0';
	        if(j % 2 != 0) {    
	            k *= 2;
	            k = k / 10 + k % 10;
	        }    
	        luhmSum += k;           
	    }    
	    return (luhmSum % 10 == 0);
	}
	
	/**
	 *   
	 * Description：校验银行卡卡号 <br/>
	 * Date：2018年2月1日 下午4:19:03　<br/>
	 * Author：lean <br/>
	 * @param cardId
	 * @return
	 */
	public static boolean checkBankCard(String cardId) {
		//拿去验证的内容为截掉最后一位的，原有的奇偶数位对调，验证得到的结果为最后一位则正确
		char bit = getBankCardCheckCode(cardId.substring(0, cardId.length() - 1));
		if(bit == 'N') return false;
		return cardId.charAt(cardId.length() - 1) == bit;
	}  
	
	/**
	 *     
	 * Description：从不含校验位的银行卡卡号采用 Luhm 校验算法获得校验位 <br/>
	 * Date：2018年2月1日 下午4:19:39　<br/>
	 * Author：lean <br/>
	 * @param nonCheckCodeCardId 验证的内容(去掉最后一位的卡号)
	 * @return
	 */
	public static char getBankCardCheckCode(String nonCheckCodeCardId){
	    if(nonCheckCodeCardId == null || nonCheckCodeCardId.trim().length() == 0    
	            || !nonCheckCodeCardId.matches("\\d+")) {    
	        //如果传的不是数据返回N    
	        return 'N';
	    }    
	    char[] chs = nonCheckCodeCardId.trim().toCharArray();
	    int luhmSum = 0;
	    for(int i = chs.length - 1, j = 0; i >= 0; i--, j++) {    
	        int k = chs[i] - '0';
	        if(j % 2 == 0) {    
	            k *= 2;
	            k = k / 10 + k % 10;
	        }    
	        luhmSum += k;           
	    }    
	    //这边+'0'，不是拼接，在Java和C#中是8+0的ASCII码得到8在ASCII中的编码值，然后通过(char)转成字符'8'  
	    return (luhmSum % 10 == 0) ? '0' : (char)((10 - luhmSum % 10) + '0'); 
	}
	
	/** 
	 * Description： <br/>
	 * Date：2018年2月1日 下午4:13:46　<br/>
	 * Author：lean <br/>
	 * @param args
	 */
	public static void main(String[] args) {
		String[] array = getBankCodeAndName("6214830113968563");
		System.out.println(array[0]+"------"+array[1]);
	}
}
