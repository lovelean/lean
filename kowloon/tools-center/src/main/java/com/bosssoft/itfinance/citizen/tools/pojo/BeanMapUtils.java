package com.bosssoft.itfinance.citizen.tools.pojo;

import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bosssoft.itfinance.citizen.tools.exception.ToolsCommonError;
import com.bosssoft.itfinance.citizen.tools.exception.ToolsCommonException;

/**
 * 
 * ClassName：com.bosssoft.itfinance.citizen.tools.pojo.BeanMapUtils　　<br/>
 * Description：bean与map互转<br/>
 * Date：2018年10月24日 上午9:28:22<br/>
 * @author lean
 * @version 1.0
 */
public class BeanMapUtils {

	private final static Logger logger = LoggerFactory.getLogger(BeanMapUtils.class);
	
    /**
     * 
     * Description： Map转换层Bean，使用泛型免去了类型转换的麻烦。 <br/>
     * Date：2018年10月24日 上午9:30:38　<br/>
     * Author：lean <br/>
     * @param map
     * @param pojo
     * @return
     * @throws ToolsCommonException 
     */
    public static <T> T mapToBean(Map<String, String> map, Class<T> pojo) throws ToolsCommonException{
        try {
            T bean = pojo.newInstance();
            BeanUtils.populate(bean, map);
            return bean;
        } catch (Exception e) {
        	logger.error("error:"+e.getMessage());
        	throw new ToolsCommonException(ToolsCommonError.POJO_MAP_TO_BEAN);
        }
    }

    /**
     * 
     * Description：bean转换到map <br/>
     * Date：2018年10月24日 上午9:31:30　<br/>
     * Author：lean <br/>
     * @param object
     * @return
     * @throws ToolsCommonException 
     */
    @SuppressWarnings("rawtypes")
	public static Map beanToMap(Object object) throws ToolsCommonException{
        try {
            Map result = BeanUtils.describe(object);
            result.remove("class");
            return result;
        } catch (Exception e) {
        	logger.error("error:"+e.getMessage());
        	throw new ToolsCommonException(ToolsCommonError.POJO_BEAN_TO_MAP);
        }
    }
}
