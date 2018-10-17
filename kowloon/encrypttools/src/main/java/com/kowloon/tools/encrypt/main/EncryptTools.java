package com.kowloon.tools.encrypt.main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.kowloon.tools.encrypt.exception.EncryptCommonException;

/**
 * 
 * ClassName：com.kowloon.tools.encrypt.main.EncryptTools　　<br/>
 * Description：工具类 <br/>
 * Date：2018年8月28日 下午4:24:01<br/>
 * @author lean
 * @version 1.0
 */
public class EncryptTools {
	
	public static String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC0Vq1Zyv2zyrpIrBrZzCX4LJ7Y2eCaLPxRC4UBb85Mp1HGYNBGKPbIuE7oghkFiHojx2pzk7q6xMPg+9vOAfO4R7V33L1o2DVe6CiQafpq/XZvJDQrDRlPERvLftouC0a9ngDkgmDpfLcCppue93P+peZQ6pKdKcGBvg0cUauah11E9/7HilDloq6qxcfdFjmJcTYjpSkrnz9zUoUjoPmem1QH8mLbPmGc9e5woeVkgAFLXqFIdIk656CbuLAMoHOXf1crYrtWv/lcPp/lV6WctoInzBOgO1yz18O4g3RjTgMvQY/WmrWr/oCy5ic4JnFD1ACeixVR2YH1VoVnrrXVAgMBAAECggEBAKgPet+KZ+Js1CuzkBZWxS/BzYsDiOfFcqLInHwZSOVwrKm2QYKQ3GN0N71AuLbKWCENz2vESamSg4Ug0dfrQ8kBsuDwKugRTbOToXHsAb5BVWUAFUnlnCduJzv+jK+KPLOrEuPhiRUu75Kd17tOmp++1aOk51tltXsGtUsl5UlMt6OqsS5+l4GjbpSv5BbFqz0S/AId1g8K5emCGnDS324XAt+vXcBIK9BncKa++a2GUKE+myaj79XRMqTfpJhNDTrA3OFf5Tfsmxhss4huCuuo7NCWYJ2tq6Q9h/hJv9lkY6zRQ87P8kX48EImd4s7SDHkBYqcr5UYEzg4iZ89QqUCgYEA8vDT0eLKqBxL21dluED+2yzyv+EQCEXsdOZ82L9B36fovxKoEBi8QrRHkle/CQ0shitMTBzSo7/oviYqaueDum4NuFWpb81o+kQi6XOa2V5P6iL+RY/eeFJ2HP0mRGjSKn+pc3CsTSYE42kRT0FCcBKT/LxkngMQzKbjGC1aLzcCgYEAvghdYNn4CkO92EzylRVO6Th7uXnD4nw+MLwS1TFvKqipTDXpJOa9ktMFrrVCJEMbIyNCqfxcCrxzdnaRo14RlphH9B+23IlAprCPhHne9BTnpnPO89vqsQaTGSzOR49DMWMSu406b0Fd2K2osOAH0vIzGE5mlnxNO1FpQSAHUVMCgYEA44u+WrBZsOwQAPnzRIlcLF4FYMOlCJq1xyi7dyhswte6oH0Q/UKt0qyY/PFC9W9pbKHRbNjyUn3FuZR11nvSXiQGpclWUmnLEd4P9SlauI4lu9/a2bzPW1OhXbWeyiSD9VptlLrMJ9acbYRTujAd0msUQX0ToQyuB4Go41RXTDECgYAdmi35pVq3NqA/LpVnVd9qAyt61BYIlPQXIWUJot6/VXCx93/vCKalVYwAECpSfcWfbqG22yH3Zi3SWVwMh93TiLtEsyAIMLVKghyJNXberNb9HfMyF6LymqSVel5T1WRRMC692p0ssZEN7NdnXi651JLTCXt/m7NoNyFfTL73EwKBgEKgthlL4u30nC1Ov9HB+snKVswEFyGCRZ3XM2moqFoTnVLGDcnjusiIP/EvZJqhvsnzW4lZBqNbiZVZ+2stMlmRH+aTotvuVacTP3WYuPgSzImJw3vZrGXjJElqWZQtaolg9z0Fhc8n9Oy3WatKc1vg1r+3ss0Gf2CpCeorQTp1";
	public static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDQ6R5rq3DZ0zEfzsPnMZPjmb8dIVXpdNODrN8QjMmmCd75eNQwasAoLSiRc55w7TBxDK25hJYOVspnev3rHkeyvTzKE1NCWvysalvK7BBlPdA8NE0JNkiPS2iEliHRw/QM7F6/17cjWocoKEYBMfj5Em5YnCWzXu+5F08/26BKXwIDAQAB";
	
	public static void main(String[] args) {
		testRsaVertifyType();
	}
	
	public static void testRsaVertifyType(){
		Map<String, Object> vertifyMap = new HashMap<String,Object>();
        vertifyMap.put("data", "{\"signedTime\":\"20180824172342\",\"contractState\":\"02\",\"contractNo\":\"A20180824172332\",\"agreementNo\":\"A20180824000000000001\",\"reqReserved\":\"\",\"agencyCode\":\"01\",\"removeTime\":\"20180824175834\",\"expiredTime\":\"21180824172342\"}");
        vertifyMap.put("sign", "Rrhzksyp3hzcqjyvLvBeDLfvHW8KDYikcz4LrCoTfAGQOKl6X7t1ryKXVKgVJpZVfZwwwh4gc0bzOQZXDQBohrpCUFA+z++eW7Wh34RgJGaPQX/SnA/J6ud1fOLZOthwj6R6RMIhAajn22+ftKBfZcgZ/COpHMVfaKOdmhtEj2M=");
        vertifyMap.put("respCode", "01");
        
        Map<String, String> vertifyMapString = new HashMap<String,String>();
        vertifyMapString.put("data", "{\"signedTime\":\"20180824172342\",\"contractState\":\"02\",\"contractNo\":\"A20180824172332\",\"agreementNo\":\"A20180824000000000001\",\"reqReserved\":\"\",\"agencyCode\":\"01\",\"removeTime\":\"20180824175834\",\"expiredTime\":\"21180824172342\"}");
        vertifyMapString.put("sign", "Rrhzksyp3hzcqjyvLvBeDLfvHW8KDYikcz4LrCoTfAGQOKl6X7t1ryKXVKgVJpZVfZwwwh4gc0bzOQZXDQBohrpCUFA+z++eW7Wh34RgJGaPQX/SnA/J6ud1fOLZOthwj6R6RMIhAajn22+ftKBfZcgZ/COpHMVfaKOdmhtEj2M=");
        vertifyMapString.put("respCode", "01");
        try {
        	boolean flag = verifyTools.rsaVerifyBase64MapObject(vertifyMap, (String)vertifyMap.get("sign"), publicKey, "UTF-8", "RSA");
            System.out.println(flag);
            boolean flag2 = verifyTools.rsaVerifyBase64MapString(vertifyMapString, vertifyMapString.get("sign"), publicKey, "UTF-8", "RSA");
            System.out.println(flag2);
		} catch (EncryptCommonException e) {
			System.out.println(e.getCode()+"--"+e.getMsg());
		} 
	}
	
	public static void testRsaSignType(){
		Map<String,Object> param = new HashMap<String,Object>();
        param.put("timestamp", "20180829144444");
        param.put("developerId", "zxy");
        param.put("data", "{\"agencyCode\":\"01\",\"contractDate\":\"20180824\",\"contractNo\":\"A20180824172332\",\"reqReserved\":\"\"}");
        param.put("method", "wallet.core.queryContract");
        param.put("version","1.0.0");
        param.put("qqq",1);
        Map<String,String> paramString = new HashMap<String,String>();
        paramString.put("timestamp", "20180829144444");
        paramString.put("developerId", "zxy");
        paramString.put("data", "{\"agencyCode\":\"01\",\"contractDate\":\"20180824\",\"contractNo\":\"A20180824172332\",\"reqReserved\":\"\"}");
        paramString.put("method", "wallet.core.queryContract");
        paramString.put("version","1.0.0");
        paramString.put("qqq","1");
        try{
	        String sign = SignTools.signBase64MapObject(param, privateKey, "UTF-8", "RSA");
	        String signString = SignTools.signBase64MapString(paramString, privateKey, "UTF-8", "RSA");
	        System.out.println(sign);
	        System.out.println(signString);
	        System.out.println(sign.equals(signString));
        } catch (EncryptCommonException e) {
			System.out.println(e.getCode()+"--"+e.getMsg());
		}    
	}
	
	public static void testRsa(){
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("timestamp", "20180829144444");
        param.put("developerId", "zxy");
        param.put("data", "{\"agencyCode\":\"01\",\"contractDate\":\"20180824\",\"contractNo\":\"A20180824172332\",\"reqReserved\":\"\"}");
        param.put("method", "wallet.core.queryContract");
        param.put("version","1.0.0");
        String aa = "Fp+4Q/FxN4VkJ4LjgQbHF//lSXrBv1dj55WGTLyH7jDnUttyHXH4SUFqt6bk2NaqkgZJi79MD51kYXmNt5C7SvYkB2Uwi6k7q6a32ToS3JQ/Qdo5mD/Hg3r9h0aWLoD3g3gxVjgZgi3M3KAyCnshkUHfe6pEkTzUlCOWSR+CRrtIj5N7Vm9Cu6Jbp1Us3pZCIZ9vWIGjsMwVtO3KSLlYRZ/Z4aLUJCEsKvGE8DudlPjb5g7Ixr0fgdXUbACOMiFwkqXLWYezJ+Ur92+ZbdUMIIrwsDXVNSMB5d3IVCTc9LvGzr64JKLC5Tj5nX+BpwNLi5uaW4UKGoxTceIeXHbAOA==";
        try {
        	String sign = SignTools.signBase64MapObject(param, privateKey, "UTF-8", "RSA");
            System.out.println(sign.equals(aa));
            Map<String, Object> vertifyMap = new HashMap<String,Object>();
            vertifyMap.put("data", "{\"signedTime\":\"20180824172342\",\"contractState\":\"02\",\"contractNo\":\"A20180824172332\",\"agreementNo\":\"A20180824000000000001\",\"reqReserved\":\"\",\"agencyCode\":\"01\",\"removeTime\":\"20180824175834\",\"expiredTime\":\"21180824172342\"}");
            vertifyMap.put("sign", "Rrhzksyp3hzcqjyvLvBeDLfvHW8KDYikcz4LrCoTfAGQOKl6X7t1ryKXVKgVJpZVfZwwwh4gc0bzOQZXDQBohrpCUFA+z++eW7Wh34RgJGaPQX/SnA/J6ud1fOLZOthwj6R6RMIhAajn22+ftKBfZcgZ/COpHMVfaKOdmhtEj2M=");
            vertifyMap.put("respCode", "01");
            
            boolean flag = verifyTools.rsaVerifyBase64MapObject(vertifyMap, (String)vertifyMap.get("sign"), publicKey, "UTF-8", "RSA");
            System.out.println(flag);
		} catch (EncryptCommonException e) {
			System.out.println(e.getCode()+"--"+e.getMsg());
		}
	}
	
	@Override
	public String toString() {
		return "EncryptTools []";
	}

	public static String getNowDateTime(){
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
        return format.format(date);
    }
}
