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
        String url = "http://172.18.169.21:8855/openapi/gateway";
        Map<String,Object> params = new HashMap<>();
        params.put("version","1.0.0");
        params.put("method","epay.terminal.downloadPublicKey");
        params.put("timestamp","20171214171152");
        params.put("developerId","test123");
        params.put("sign","g9c9t6HxIsYUJJjSVX4RPFnYY1kkkzZj2xaSw/Jq8mLXHTcgnzMuuKleVK4COHsfR1pS/glWBm4YIObZT++TKAxjiBTuAfPU4UAdco2nVPQiGt9tlF/8LcC21j8NaSig2TAGwas2aKueTCztiZQCQNT26YoEyJDg6gtpkX2LaWM=");
        //HttpHost proxy = new HttpHost("127.0.0.1", 8888, "http");
        //String rst = BsHttpClientUtils.sendForm(url,params,proxy);
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
