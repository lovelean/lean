package com.kowloon.tools.httpclient4.httpUrl;

import org.apache.commons.io.IOUtils;
import org.apache.http.Consts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * 
 * ClassName：com.kowloon.tools.httpclient.HttpURLConnectionTool　　<br/>
 * Description：HttpURLConnection方式请求 <br/>
 * Date：2018年7月23日 下午2:43:34<br/>
 * @author lean
 * @version 1.0
 */
public class HttpURLConnectionTool {
	
    private static Logger logger = LoggerFactory.getLogger(HttpURLConnectionTool.class);
    /** 默认编码 */
    private final static Charset DEFAULT_CHARSET = Consts.UTF_8;
    /** head名称 Content-Type*/
    private static final String HEAD_CONTENT_TYPE = "Content-Type";
    /** form表单方式 */
    private static final String HEAD_CONTENT_FORM = "application/x-www-form-urlencoded; charset="+DEFAULT_CHARSET.name();
    /** body json 方式*/
    private static final String HEAD_CONTENT_BODY_JSON = "application/json; charset="+DEFAULT_CHARSET.name();
    /** http成功状态 */
    private static final int HTTP_OK = 200;
    /** 建立连接超时时间(毫秒) */
    private static final int CONNECT_TIMEOUT = 30000;
    /** 等待响应超时时间(毫秒) */
    private static final int READ_TIMEROUT = 10000;

    /**
     * 
     * Description：form表单POST方法发送请求 <br/>
     * Date：2018年7月23日 下午2:43:53　<br/>
     * Author：lean <br/>
     * @param urlPath 请求地址
     * @param param 参数
     * @return
     * @throws Exception
     */
    public static String postForm(String urlPath, Map<String,Object> param) throws Exception {
        String paramStr = getFormString(param);
        return sendPostRequest(urlPath,paramStr,HEAD_CONTENT_FORM,-1,-1);
    }

    /**
     * 
     * Description：form表单POST方法发送请求 <br/>
     * Date：2018年7月23日 下午2:44:13　<br/>
     * Author：lean <br/>
     * @param urlPath 请求地址
     * @param param 参数
     * @param connectTimeout 连接超时设置
     * @param readTimeout 读超时设置
     * @return
     * @throws Exception
     */
    public static String postForm(String urlPath, Map<String,Object> param,int connectTimeout,int readTimeout) throws Exception {
        return sendPostRequest(urlPath,getFormString(param),HEAD_CONTENT_FORM,connectTimeout,readTimeout);
    }

    /**
     * 
     * Description：body方式json格式post发送请求 <br/>
     * Date：2018年7月23日 下午2:44:51　<br/>
     * Author：lean <br/>
     * @param url
     * @param jsonStr
     * @return
     * @throws Exception
     */
    public static String postBody(String url, String jsonStr) throws Exception {
        return sendPostRequest(url,jsonStr,HEAD_CONTENT_BODY_JSON,-1,-1);
    }

    /**
     * 
     * Description：拼接Form表单参数串
     * 注意：null拼接为null字符串 <br/>
     * Date：2018年7月23日 下午2:45:12　<br/>
     * Author：lean <br/>
     * @param param
     * @return
     * @throws UnsupportedEncodingException
     */
    private static String getFormString(Map<String,Object> param) throws UnsupportedEncodingException {
        if(param != null && !param.isEmpty()){
            StringBuffer sb = new StringBuffer();
            for (Map.Entry<String, Object> entry : param.entrySet()) {
                sb.append("&")
                        .append(entry.getKey())
                        .append("=")
                        .append(URLEncoder.encode(String.valueOf(entry.getValue()),DEFAULT_CHARSET.name()));
            }
            return sb.substring(1);
        }
        return null;
    }

    /**
     * 
     * Description：发送请求 <br/>
     * Date：2018年7月23日 下午2:45:33　<br/>
     * Author：lean <br/>
     * @param urlPath 请求地址
     * @param paramStr 参数串
     * @param contentType 文本类型
     * @param connectTimeout 连接超时
     * @param readTimeout 读超时
     * @return
     * @throws Exception
     */
    private static String sendPostRequest(String urlPath, String paramStr,
                                          String contentType,int connectTimeout,
                                          int readTimeout) throws Exception {
        URL url = new URL(urlPath);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        // 设置doOutput属性为true表示将使用此urlConnection写入数据
        urlConnection.setDoOutput(true);
        urlConnection.setRequestMethod("POST");
        if(connectTimeout > 0){
            urlConnection.setConnectTimeout(connectTimeout);
        }else {
            urlConnection.setConnectTimeout(CONNECT_TIMEOUT);
        }
        if(readTimeout > 0) {
            urlConnection.setReadTimeout(readTimeout);
        }else{
            urlConnection.setReadTimeout(READ_TIMEROUT);
        }
        urlConnection.setRequestProperty(HEAD_CONTENT_TYPE, contentType);
        //根据现有接口文档定义，返回值都为json，服务端需要配置支持此MIME返回，也可以配置为text/plain
        //urlConnection.setRequestProperty("Accept", "application/json");

        //OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream(),DEFAULT_CHARSET);
        PrintStream out = new PrintStream(urlConnection.getOutputStream(), false, DEFAULT_CHARSET.name());
        // 把数据写入请求的Body
        if(paramStr != null && !"".equals(paramStr)) {
            out.print(paramStr);
        }
        out.flush();
        out.close();

        InputStream inputStream = urlConnection.getInputStream();
        String encoding = urlConnection.getContentEncoding();
        if(encoding == null || "".equals(encoding)){
            encoding = DEFAULT_CHARSET.name();
        }
        String respBody = IOUtils.toString(inputStream, encoding);
        int respCode = urlConnection.getResponseCode();
        logger.debug("http请求完成,url={},paramString={},respCode={},resp={}",urlPath,paramStr,respCode,respBody);

        if(urlConnection.getResponseCode() == HTTP_OK){
            return respBody;
        }else{
            logger.warn("http请求失败，code={},msg={}",urlConnection.getResponseCode(),respBody);
            throw new Exception("http请求异常,code="+respCode+",body="+respBody);
        }
    }

    /**
     * 
     * Description：读取流，用来异步多次读取流中数据 <br/>
     * Date：2018年7月23日 下午2:46:19　<br/>
     * Author：lean <br/>
     * @param inStream
     * @return
     * @throws Exception
     */
    public static byte[] readStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int len = -1;
          while ((len = inStream.read(buffer)) != -1) {
            outSteam.write(buffer, 0, len);
            System.out.println("收到消息="+new String(buffer,"UTF-8"));
        }
        outSteam.close();
        inStream.close();
        return outSteam.toByteArray();
    }

}
