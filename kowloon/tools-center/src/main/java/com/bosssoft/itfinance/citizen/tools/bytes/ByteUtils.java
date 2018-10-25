package com.bosssoft.itfinance.citizen.tools.bytes;

/**
 * 
 * ClassName：com.bosssoft.itfinance.citizen.tools.ByteUtils　　<br/>
 * Description：位转换工具类 <br/>
 * Date：2018年10月24日 上午8:58:53<br/>
 * @author lean
 * @version 1.0
 */
public class ByteUtils {

    /**
     * 
     * Description：byte数组转换成16进制字符串 <br/>
     * Date：2018年10月24日 上午8:58:59　<br/>
     * Author：lean <br/>
     * @param byteSrc
     * @return
     */
    public static String bytes2HexString(byte[] byteSrc) {
        StringBuilder result = new StringBuilder();
        for (int i = 0;i< byteSrc.length;i++) {
            String byteStr = Integer.toHexString(byteSrc[i] & 0xFF);
            if (byteStr.length() < 2) {
                result.append(String.format("0%s", byteStr));
            }else{
                result.append(byteStr);
            }
        }
        return result.toString().toUpperCase();
    }

    /**
     * 
     * Description：16进制字符串转成byte数组 <br/>
     * Date：2018年10月24日 上午8:59:09　<br/>
     * Author：lean <br/>
     * @param stringSrc
     * @return
     */
    public static byte[] hexString2Bytes(String stringSrc){
        byte[] byteSrc = new byte[stringSrc.length() / 2];
        for (int i=0;i<byteSrc.length;i++) {
            byteSrc[i] = ((byte)Integer.parseInt(stringSrc.substring(i * 2, i * 2 + 2), 16));
        }
        return byteSrc;
    }

    public static String int2HexString(int i){
        String byteStr = Integer.toHexString(i);
        if (byteStr.length() < 2) {
            return String.format("0%s", byteStr);
        }else{
            return byteStr;
        }
    }
}
