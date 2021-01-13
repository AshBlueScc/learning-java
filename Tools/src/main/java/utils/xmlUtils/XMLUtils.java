package utils.xmlUtils;

import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chengzhen
 * @date 2020/3/2
 * @time 下午3:18
 */
@Component
public class XMLUtils {
    /**
     * 将bean对象转成xml
     *
     * @param obj
     * @return xml
     */
    public static String toXml(Object obj) {
        XStream xstream = XStreamInitializer.getInstance();
//        xstream.alias("xml", Map.class);
        xstream.processAnnotations(obj.getClass());
        return xstream.toXML(obj);
    }

    public static String toXml2(Object obj) {
        XStream xstream = XStreamInitializer.getInstance2();
        xstream.alias("xml", obj.getClass());
        xstream.processAnnotations(obj.getClass());
        return xstream.toXML(obj);
    }

    /**
     * 将xml转成bean对象
     *
     * @param xml
     * @return
     */
    public static Object fromXml(String xml, Class clazz) {
        XStream xstream = XStreamInitializer.getInstance();
        xstream.processAnnotations(clazz);
        return xstream.fromXML(xml);
    }

    /**
     * 取xml中某个节点的值
     * @param xml
     * @param attribute
     * @return
     */
    public static String getAttributeValue(String xml, String attribute) {
        String value  = "";
        try {
            Document document = DocumentHelper.parseText(xml);
            Element root = document.getRootElement();
            Element childElement = root.element(attribute);
            if(childElement != null){
               value = childElement.getTextTrim();
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * 解析微信发来的请求（XML）
     *
     * @param xml
     * @return Map<String       ,               String>
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> parseXml(String xml) throws Exception {
        // 将解析结果存储在HashMap中
        Map<String, String> map = new HashMap<String, String>();

        Document document = DocumentHelper.parseText(xml);
        // 得到xml根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        List<Element> elementList = root.elements();

        // 遍历所有子节点
        for (Element e : elementList)
            map.put(e.getName(), e.getText());

        return map;
    }
}
