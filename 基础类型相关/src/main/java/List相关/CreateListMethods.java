package List相关;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author chengzhen
 * @date 2020/9/1
 * @time 5:05 PM
 * 创建list的四种方法
 */
public class CreateListMethods {


    public static void main(String[] args) {
        //1.通过构造方法,可增加新的元素
        List<String> strs = new ArrayList<String>();
        strs.add("a");
        strs.add("b");
        System.out.println(strs);
        strs.add("c");

        //2.通过Arrays.asList()方法,固长不可增加新的元素
        strs = Arrays.asList("a", "b");
        System.out.println(strs);
//        strs.add("c"); //增加报错

        //3.通过Java8引入的Stream提供的方法,可增加新的元素
        strs = Stream.of("a", "b").collect(Collectors.toList());
        System.out.println(strs);
        strs.add("c");

        //4.通过guava提供的方法,可增加新的元素
        strs = Lists.newArrayList("a", "b");
        System.out.println(strs);
        strs.add("c");



    }

}
