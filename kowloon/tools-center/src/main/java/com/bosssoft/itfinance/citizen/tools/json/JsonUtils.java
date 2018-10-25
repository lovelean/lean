package com.bosssoft.itfinance.citizen.tools.json;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bosssoft.itfinance.citizen.tools.exception.ToolsCommonError;
import com.bosssoft.itfinance.citizen.tools.exception.ToolsCommonException;


/**
 * 
 * ClassName：com.bosssoft.itfinance.citizen.channel.core.utils.JsonUtils　　<br/>
 * Description：json转换工具 <br/>
 * Date：2018年9月11日 下午5:20:28<br/>
 * @author lean
 * @version 1.0
 */
public class JsonUtils {

	private final static Logger logger = LoggerFactory.getLogger(JsonUtils.class);
	
    /**
     * 
     * Description：json转list <br/>
     * Date：2018年9月11日 下午5:20:36　<br/>
     * Author：lean <br/>
     * @param text
     * @param clazz
     * @return
     * @throws ToolsCommonException 
     */
    public static <T> List<T> parseArray(String text, Class<T> clazz) throws ToolsCommonException {
        try {
            return JSON.parseArray(text,clazz);
        }catch (Exception e){
        	logger.error("error:"+e.getMessage());
        	throw new ToolsCommonException(ToolsCommonError.SYS_FORMAT_JSON_ERROR);
        }
    }

    /**
     * 
     * Description：json转object <br/>
     * Date：2018年9月11日 下午5:20:45　<br/>
     * Author：lean <br/>
     * @param text
     * @param clazz
     * @return
     * @throws ToolsCommonException 
     */
    public static <T> T parseObject(String text, Class<T> clazz) throws ToolsCommonException {
        try {
            return JSON.parseObject(text, clazz);
        }catch (Exception e){
        	logger.error("error:"+e.getMessage());
        	throw new ToolsCommonException(ToolsCommonError.SYS_FORMAT_JSON_ERROR);
        }
    }

    /**
     * 
     * Description：object 转 string <br/>
     * Date：2018年9月11日 下午5:21:08　<br/>
     * Author：lean <br/>
     * @param object
     * @return
     * @throws ToolsCommonException 
     */
    public static String toJSONString(Object object) throws ToolsCommonException {
        try {
            return JSON.toJSONString(object);
        }catch (Exception e){
        	logger.error("error:"+e.getMessage());
        	throw new ToolsCommonException(ToolsCommonError.SYS_FORMAT_JSON_ERROR);
        }
    }
    
    /**
	 * 
	 * Description：json转Map <br/>
	 * Date：2018年2月26日 下午5:46:24　<br/>
	 * Author：lean <br/>
	 * @param json
	 * @return
     * @throws ToolsCommonException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map<String, String> jsonToMap(String json) throws ToolsCommonException{
		try {
			return (Map)JSON.parse(json);
		} catch (Exception e) {
			logger.error("error:"+e.getMessage());
			throw new ToolsCommonException(ToolsCommonError.SYS_FORMAT_JSON_ERROR);
		}
	}
	
	/**
	 * 
	 * Description：json转JSONObject <br/>
	 * Date：2018年7月5日 上午8:52:03　<br/>
	 * Author：lean <br/>
	 * @param json
	 * @return
	 * @throws ToolsCommonException 
	 */
	public static JSONObject jsonToJsonObject(String json) throws ToolsCommonException{
		try {
			return (JSONObject) JSON.parse(json);
		} catch (Exception e) {
			logger.error("error:"+e.getMessage());
			throw new ToolsCommonException(ToolsCommonError.SYS_FORMAT_JSON_ERROR);
		}
	}
}
