package com.bosssoft.itfinance.citizen.tools.verify;

import java.lang.reflect.Field;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bosssoft.itfinance.citizen.tools.exception.ToolsCommonError;
import com.bosssoft.itfinance.citizen.tools.exception.ToolsCommonException;

/**
 * 
 * ClassName：com.bosssoft.itfinance.citizen.tools.verify.CheckUtils　　<br/>
 * Description：注解校验工具类<br/>
 * Date：2018年10月24日 上午9:42:13<br/>
 * @author lean
 * @version 1.0
 */
public class CheckUtils {

	private final static Logger logger = LoggerFactory.getLogger(CheckUtils.class);
	
    /**
     * 
     * Description：对象校验 <br/>
     * Date：2018年10月24日 上午10:34:10　<br/>
     * Author：lean <br/>
     * @param object
     * @throws ToolsCommonException
     */
    public static void check(Object object) throws ToolsCommonException{
    	if(object == null){
    		throw new ToolsCommonException(ToolsCommonError.CHECK_PARAMS_NULL_ERROR);
    	}
        //获取object的类型
        Class<? extends Object> clazz=object.getClass();
        //获取该类型声明的成员
        Field[] fields = clazz.getDeclaredFields();
        try {
            for(Field field:fields){
                field.setAccessible(true);
                if (field.isAnnotationPresent(Check.class)){
                    check(field, object);
                }
                field.setAccessible(false);
            }
        }catch (IllegalAccessException e) {
        	logger.error("ERROR:"+e.getMessage());
            throw new ToolsCommonException(ToolsCommonError.CHECK_PARAMS_CHECK_ERROR);
        }
    }

	/**
	 * 
	 * Description：注解字段校验 <br/>
	 * Date：2018年10月24日 上午10:34:18　<br/>
	 * Author：lean <br/>
	 * @param field
	 * @param object
	 * @throws ToolsCommonException
	 * @throws IllegalAccessException
	 */
    private static void check(Field field,Object object) throws ToolsCommonException, IllegalAccessException {
        Check check = field.getAnnotation(Check.class);
        if(check!=null){
            String name = check.name();
            boolean isRequired = check.required();
            if (isRequired == false){
                return;
            }
            Object value = field.get(object);
            if( isRequired && value == null) {
                throw new ToolsCommonException(ToolsCommonError.CHECK_PARAMS_ATTR_ERROR.getCode(), String.format("(%s)%s", name, "不能为空！"));
            }
            checkByType(name,value,check.type());
        }
    }

    /**
     * 
     * Description：校验类型校验 <br/>
     * Date：2018年10月24日 上午10:34:33　<br/>
     * Author：lean <br/>
     * @param name
     * @param value
     * @param checkType
     * @throws ToolsCommonException
     */
    @SuppressWarnings("rawtypes")
	private static void checkByType(String name, Object value, CheckType checkType) throws ToolsCommonException {
        //字符类型检验为空
        if(value instanceof String){
            String result = (String) value;
            if("".equals(result)){
                throw new ToolsCommonException(ToolsCommonError.CHECK_PARAMS_ATTR_ERROR.getCode(), String.format("(%s)%s", name,"不能为空！"));
            }
        }
        //列表不能为空
        if (value instanceof List){
            List result = (List) value;
            if(result.size()==0){
                throw new ToolsCommonException(ToolsCommonError.CHECK_PARAMS_ATTR_ERROR.getCode(), String.format("(%s)%s", name,"列表不能为空！"));
            }
        }
        //具体类型判断
        switch (checkType){
            case PASSWORD:
                if(!VerifyUtils.isPassword(String.valueOf(value))){
                    throw new ToolsCommonException(ToolsCommonError.CHECK_PARAMS_ATTR_ERROR.getCode(), String.format("(%s)%s",name,"只能由英文、数字、下划线组成"));
                }
                break;
            case EMAIL:
                if (!VerifyUtils.isEmail(String.valueOf(value))){
                    throw new ToolsCommonException(ToolsCommonError.CHECK_PARAMS_ATTR_ERROR.getCode(), String.format("(%s)%s",name,"格式不正确！"));
                }
                break;
            case PHONE:
                if (!VerifyUtils.isMobile(String.valueOf(value))){
                    throw new ToolsCommonException(ToolsCommonError.CHECK_PARAMS_ATTR_ERROR.getCode(), String.format("(%s)%s",name,"格式不正确！"));
                }
                break;
            case ZIPCODE:
                if (!VerifyUtils.isZipCode(String.valueOf(value))){
                    throw new ToolsCommonException(ToolsCommonError.CHECK_PARAMS_ATTR_ERROR.getCode(), String.format("(%s)%s",name,"格式不正确！"));
                }
                break;
            case POSITIVE:
                if(value instanceof Integer && (Integer)value <= 0){
                    throw new ToolsCommonException(ToolsCommonError.CHECK_PARAMS_ATTR_ERROR.getCode(), String.format("(%s)%s",name,"必须大于0！"));
                }
                break;
            case DATE:
                if (!VerifyUtils.isDate(String.valueOf(value))){
                    throw new ToolsCommonException(ToolsCommonError.CHECK_PARAMS_ATTR_ERROR.getCode(), String.format("(%s)%s",name,"格式不正确！"));
                }
                break;
            case TIME:
                if (!VerifyUtils.isTime(String.valueOf(value))){
                    throw new ToolsCommonException(ToolsCommonError.CHECK_PARAMS_ATTR_ERROR.getCode(), String.format("(%s)%s",name,"格式不正确！"));
                }
                break;
            case DATETIME:
                if (!VerifyUtils.isDateTime(String.valueOf(value))){
                    throw new ToolsCommonException(ToolsCommonError.CHECK_PARAMS_ATTR_ERROR.getCode(), String.format("(%s)%s",name,"格式不正确！"));
                }
                break;
            case ENUM:
                break;
            default:
                break;
        }
    }
}
