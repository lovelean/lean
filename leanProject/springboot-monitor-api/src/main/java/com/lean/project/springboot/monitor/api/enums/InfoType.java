package com.lean.project.springboot.monitor.api.enums;

/**
 * 
 * ClassName：com.lean.project.springboot.monitor.api.enums.InfoType　　<br/>
 * Description：消息类型 <br/>
 * Date：2019年1月28日 下午4:51:05<br/>
 * @author lean
 * @version 1.0
 */
public enum InfoType {
	
	ERROR("ERROR","异常信息"),
	TIME_OUT("TIMEOUT","超时信息");

    private String code;
    private String msg;

    InfoType(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
    
    /**
     * 
     * Description： <br/>
     * Date：2019年1月28日 下午4:51:51　<br/>
     * Author：lean <br/>
     * @param code
     * @return
     */
    public static InfoType getEnumByCode(String code){  
  	   for(InfoType infoType : InfoType.values()){  
  		   if(infoType.getCode().equals(code)){  
  			   return infoType;  
  		   }  
  	   }  
  	   return null;  
  	}
    
    /**
     * 
     * Description： <br/>
     * Date：2019年1月28日 下午4:52:13　<br/>
     * Author：lean <br/>
     * @param msg
     * @return
     */
    public static InfoType getEnumByMsg(String msg){  
  	   for(InfoType infoType : InfoType.values()){  
  		   if(infoType.getMsg().equals(msg)){  
  			   return infoType;  
  		   }  
  	   }  
  	   return null;  
  	}
}
