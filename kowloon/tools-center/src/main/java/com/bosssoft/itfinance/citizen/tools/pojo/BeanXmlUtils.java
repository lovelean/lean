package com.bosssoft.itfinance.citizen.tools.pojo;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bosssoft.itfinance.citizen.tools.exception.ToolsCommonError;
import com.bosssoft.itfinance.citizen.tools.exception.ToolsCommonException;

/**
 * 
 * ClassName：com.bosssoft.itfinance.citizen.tools.pojo.BeanXmlUtils　　<br/>
 * Description：bean与xml互转 <br/>
 * Date：2018年10月24日 上午10:39:44<br/>
 * @author lean
 * @version 1.0
 */
public class BeanXmlUtils {

	private final static Logger logger = LoggerFactory.getLogger(BeanXmlUtils.class);
	
    /**
     * 
     * Description：JavaBean转换成xml[默认编码UTF-8] <br/>
     * Date：2018年10月24日 上午8:57:23　<br/>
     * Author：lean <br/>
     * @param obj
     * @return
     * @throws ToolsCommonException 
     */
    public static String convertToXml(Object obj) throws ToolsCommonException {
        return convertToXml(obj, "UTF-8");
    }

    /**
     * 
     * Description：JavaBean转换成xml <br/>
     * Date：2018年10月24日 上午8:57:45　<br/>
     * Author：lean <br/>
     * @param obj
     * @param encoding 字符集编码
     * @return
     * @throws ToolsCommonException 
     */
    public static String convertToXml(Object obj, String encoding) throws ToolsCommonException {
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT,true);

            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            return writer.toString().replace(" standalone=\"yes\"", "");
        } catch (Exception e) {
        	logger.error("ERROR:"+e.getMessage());
            throw new ToolsCommonException(ToolsCommonError.POJO_BEAN_TO_XML);
        }
    }

    /**
     * 
     * Description：xml转换成JavaBean <br/>
     * Date：2018年10月24日 上午8:58:00　<br/>
     * Author：lean <br/>
     * @param xml 待转换内容
     * @param c
     * @return
     * @throws ToolsCommonException 
     */
    @SuppressWarnings("unchecked")
    public static <T> T converyToJavaBean(String xml, Class<T> c) throws ToolsCommonException {
        try {
            JAXBContext context = JAXBContext.newInstance(c);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (T) unmarshaller.unmarshal(new StringReader(xml));
        } catch (Exception e) {
        	logger.error("ERROR:"+e.getMessage());
            throw new ToolsCommonException(ToolsCommonError.POJO_XML_TO_BEAN);
        }
    }
}
