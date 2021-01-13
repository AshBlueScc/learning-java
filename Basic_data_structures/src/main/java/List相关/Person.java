package List相关;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chengzhen
 * @date 2020/9/1
 * @time 5:26 PM
 */
@Data
public class Person implements Serializable,Cloneable{
    private String name;
    private Integer age;

    public static Person create(String name, Integer age){
        Person ins = new Person();
        ins.setAge(age);
        ins.setName(name);
        return ins;
    }

    @Override
    public Object clone() {
        Person o = null;
        try {
            o = (Person) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }
}
