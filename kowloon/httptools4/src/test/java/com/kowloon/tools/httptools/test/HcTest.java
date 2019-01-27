package com.kowloon.tools.httptools.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.kowloon.tools.httpclient4.httpClient.HttpClientTool;

/**
 * 
 * ClassName：com.kowloon.tools.httptools.test.HcTest　　<br/>
 * Description：<br/>
 * Date：2018年7月23日 下午2:57:00<br/>
 * @author lean
 * @version 1.0
 */
public class HcTest {
    @Test
    public void httpClientForm() throws Exception {
        String url = "http://172.18.160.222:32891/monitor/center/receiveInfo";
        Map<String,Object> params = new HashMap<>();
        params.put("version","1.0.0");
        params.put("info","123");
        String rst = HttpClientTool.sendForm(url,params);
        System.out.println("rst===="+rst);
    }

    @Test
    public void httpClientFormAsy() throws Exception {
/*       for(int i=0;i<100;i++){
            Thread thread = new Thread(){
                @Override
                public void run() {
                    super.run();
                    try {
                        httpClientForm();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            thread.start();
        }*/
    }

    @Test
    public void httpClientBody() throws Exception {
        String url = "http://localhost:8081/third-mock/two";
        Map<String,Object> params = new HashMap<>();
        params.put("userName","张三");
        params.put("sno","200412141251");
        params.put("amt",100230);
        String rst = HttpClientTool.sendBody(url, JSON.toJSONString(params));
        System.out.println("rst===="+rst);
    }

    @Test
    public void httpClientForm2() throws Exception {
        String url = "http://localhost:8081/third-mock/two";
        Map<String,Object> params = new HashMap<>();
        params.put("userName","张三===");
        String rst = HttpClientTool.sendForm(url,params);
        System.out.println("rst===="+rst);
    }

    @Test
    public void httpClientForm3() throws Exception {
/*        HttpClientPoolConfig httpClientPoolConfig = new HttpClientPoolConfig();
        httpClientPoolConfig.setIgnoreSSL(false);
        HttpClientPool.init(httpClientPoolConfig);*/

        String url = "https://120.40.102.240:9600/openapi/gateway";
        Map<String,Object> params = new HashMap<>();
        params.put("userName","张三===");
        String rst = HttpClientTool.sendForm(url,params);
        System.out.println("rst===="+rst);

    }



}
