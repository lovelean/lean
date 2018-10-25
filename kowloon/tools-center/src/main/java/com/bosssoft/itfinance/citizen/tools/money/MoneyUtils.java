package com.bosssoft.itfinance.citizen.tools.money;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bosssoft.itfinance.citizen.tools.exception.ToolsCommonError;
import com.bosssoft.itfinance.citizen.tools.exception.ToolsCommonException;

/**
 * 
 * ClassName：com.bosssoft.itfinance.citizen.tools.money.MoneyUtils　　<br/>
 * Description：金额转换工具类 <br/>
 * Date：2018年10月24日 上午9:07:51<br/>
 * @author lean
 * @version 1.0
 */
public class MoneyUtils {
	
	private final static Logger logger = LoggerFactory.getLogger(MoneyUtils.class);
	
	private static DecimalFormat decimalFormat =new DecimalFormat("#.00");
	
	/**
	 * 
	 * Description： 格式化金额 <br/>
	 * Date：2018年10月24日 上午9:33:57　<br/>
	 * Author：lean <br/>
	 * @param money
	 * @return
	 * @throws ToolsCommonException 
	 */
    public static String formatMoney(String money) throws ToolsCommonException{
        try {
        	return decimalFormat.format(new BigDecimal(money));
        }catch (Exception e){
        	logger.error("error:"+e.getMessage());
        	throw new ToolsCommonException(ToolsCommonError.SYS_FORMAT_MONEY_ERROR);
        }
    }
	
    /**
     * 
     * Description：元转分 <br/>
     * Date：2018年10月24日 上午9:08:05　<br/>
     * Author：lean <br/>
     * @param amount
     * @return
     * @throws ToolsCommonException 
     */
    public static int amountToCent(String amount) throws ToolsCommonException{
        return amountToCent(new BigDecimal(amount));
    }

    /**
     * 
     * Description：元转分 <br/>
     * Date：2018年10月24日 上午9:08:14　<br/>
     * Author：lean <br/>
     * @param amount
     * @return
     * @throws ToolsCommonException 
     */
    public static int amountToCent(BigDecimal amount) throws ToolsCommonException{
    	try {
    		return new BigDecimal(100).multiply(amount).intValue();
        }catch (Exception e){
        	logger.error("error:"+e.getMessage());
        	throw new ToolsCommonException(ToolsCommonError.SYS_FORMAT_MONEY_ERROR);
        }
    }
    
    public static void main(String[] args) {

    }
}
