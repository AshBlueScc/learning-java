package utils.xmlUtils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

import java.io.Writer;

public class XStreamInitializer {

    public static XStream getInstance() {
        XStream xstream = new XStream(new XppDriver() {

            @Override
            public HierarchicalStreamWriter createWriter(Writer out) {
                return new PrettyPrintWriter(out, getNameCoder()) {
                    //对所有xml节点的转换都增加CDATA标记
                    boolean cdata = true;

                    //排除需要加CDATA的标记
//                    protected String PREFIX_CREATE_TIME = "<CreateTime>";
//                    protected String SUFFIX_CREATE_TIME = "</CreateTime>";
//                    protected String PREFIX_MSG_ID = "<MsgId>";
//                    protected String SUFFIX_MSG_ID = "</MsgId>";

                    @Override
                    @SuppressWarnings("rawtypes")
                    public void startNode(String name, Class clazz) {
                        super.startNode(name, clazz);
                    }

                    //重写此方法，不再像XppDriver那样调用nameCoder来进行编译，而是直接返回节点名称。
                    //防止将_转换成__
                    @Override
                    public String encodeNode(String name) {
                        return name;
                    }

                    @Override
                    protected void writeText(QuickWriter writer, String text) {
//                        System.out.println(text);
//                        if (text.startsWith(PREFIX_CREATE_TIME) && text.endsWith(SUFFIX_CREATE_TIME)) {
//                            writer.write(text);
//                        } else if (text.startsWith(PREFIX_MSG_ID) && text.endsWith(SUFFIX_MSG_ID)) {
//                            writer.write(text);
//                        } else {
                            writer.write("<![CDATA[");
                            writer.write(text);
                            writer.write("]]>");
//                        }
                    }


                };
            }
        });
        xstream.ignoreUnknownElements();
        xstream.setMode(XStream.NO_REFERENCES);
        xstream.addPermission(NullPermission.NULL);
        xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
        return xstream;
    }

    public static XStream getInstance2() {
        XStream xstream = new XStream(new XppDriver() {

            @Override
            public HierarchicalStreamWriter createWriter(Writer out) {
                return new PrettyPrintWriter(out, getNameCoder()) {

                    @Override
                    @SuppressWarnings("rawtypes")
                    public void startNode(String name, Class clazz) {
                        super.startNode(name, clazz);
                    }

                    //重写此方法，不再像XppDriver那样调用nameCoder来进行编译，而是直接返回节点名称。
                    //防止将_转换成__
                    @Override
                    public String encodeNode(String name) {
                        return name;
                    }

                    @Override
                    protected void writeText(QuickWriter writer, String text) {
//                        System.out.println(text);
//                        if (text.startsWith(PREFIX_CREATE_TIME) && text.endsWith(SUFFIX_CREATE_TIME)) {
//                            writer.write(text);
//                        } else if (text.startsWith(PREFIX_MSG_ID) && text.endsWith(SUFFIX_MSG_ID)) {
//                            writer.write(text);
//                        } else {
//                        writer.write("<![CDATA[");
                        writer.write(text);
//                        writer.write("]]>");
//                        }
                    }


                };
            }
        });
        xstream.ignoreUnknownElements();
        xstream.setMode(XStream.NO_REFERENCES);
        xstream.addPermission(NullPermission.NULL);
        xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
        return xstream;
    }
}
