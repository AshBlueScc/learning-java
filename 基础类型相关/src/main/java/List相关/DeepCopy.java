package List相关;

import com.google.common.collect.Lists;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chengzhen
 * @date 2020/9/1
 * @time 6:15 PM
 * 两种深拷贝的方法
 */
public class DeepCopy {
    //1.使用序列化方法，主要需要实现Serializable接口
    public static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        @SuppressWarnings("unchecked")
        List<T> dest = (List<T>) in.readObject();
        return dest;
    }


    //2.使用clone方法，注意需要实现cloneable接口
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Person> srcList = Lists.newArrayList(Person.create("s1", 2), Person.create("s2", 3));
//        List<Person> destList = deepCopy(srcList); //调用该方法(使用序列化方法)
        List<Person> destList = new ArrayList<>();
        srcList.forEach(o->{
            destList.add((Person) o.clone());
        });//使用clone方法
        System.out.println("修改前 srcList:"+srcList+",desList:"+destList);
        srcList.get(0).setName("修改后的s1");
        srcList.get(0).setAge(4);
        System.out.println("修改后 srcList:"+srcList+",desList:"+destList);
    }

}
