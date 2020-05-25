package utils.xmlUtils;

import com.thoughtworks.xstream.XStream;
import utils.xmlUtils.Person;

import java.util.List;

/**
 * @author chengzhen
 * @date 2020/4/28
 * @time 下午3:15
 */
public class xStream {

    public static void main(String[] args) {
        String s = "<xml>\n" +
                "  <ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                "  <FromUserName><![CDATA[fromUser]]></FromUserName>\n" +
                "  <CreateTime>1348831860</CreateTime>\n" +
                "  <MsgType><![CDATA[text]]></MsgType>\n" +
                "  <Content><![CDATA[this is a Demo]]></Content>\n" +
                "  <MsgId>1234567890123456</MsgId>\n" +
                "</xml>";
        try {
            System.out.println(XMLUtils.parseXml(s));
        } catch (Exception e) {
            e.printStackTrace();
        }

        XStream xStream = new XStream();
        xStream.alias("xml", Person.class);
        xStream.processAnnotations(List.class);
        Person person = new Person();
        person.setName("11");
        person.setAge("11");
        System.out.println(xStream.toXML(person));

    }
}
