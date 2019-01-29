package com.lean.project.springboot.monitor.api.enums;

/**
 * 
 * ClassName：com.lean.project.springboot.monitor.api.enums.RecordMode　　<br/>
 * Description：记录模式<br/>
 * Date：2019年1月29日 上午10:21:15<br/>
 * @author lean
 * @version 1.0
 */
public enum RecordMode {
	
	LOCAL_LOG("LOCAL_LOG","本地日志"),
	CENTER_LOG("CENTER_LOG","监控中心日志"),
	CENTER_DB("CENTER_DB","监控中心数据库");

    private String code;
    private String msg;

    RecordMode(String code, String msg) {
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
    public static RecordMode getEnumByCode(String code){  
  	   for(RecordMode recordMode : RecordMode.values()){  
  		   if(recordMode.getCode().equals(code)){  
  			   return recordMode;  
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
    public static RecordMode getEnumByMsg(String msg){  
  	   for(RecordMode recordMode : RecordMode.values()){  
  		   if(recordMode.getMsg().equals(msg)){  
  			   return recordMode;  
  		   }  
  	   }  
  	   return null;  
  	}
}
