package utils.xmlUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Data;

/**
 * @author chengzhen
 * @date 2020/4/30
 * @time 下午5:10
 */
@Data
public class Person {
    private String name;
    @XStreamAlias(impl=Person.class,value="Benefit")
    @XStreamImplicit
    private String age;

}
