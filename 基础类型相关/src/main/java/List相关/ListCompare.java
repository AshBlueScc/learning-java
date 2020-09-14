package List相关;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chengzhen
 * @date 2020/9/14
 * @time 11:25 AM
 */
public class ListCompare {

    public static void main(String[] args) {
        //1。自带sort()方法
        List<Integer> list = Lists.newArrayList(1, 2, 3);
        list.sort(Comparator.comparingInt(Integer::intValue).reversed());   //倒序
        System.out.println("list:" + list);
        list.sort(Comparator.comparingInt(Integer::intValue));   //正序
        System.out.println("list:" + list);

        //2。流的sorted()方法
        List list2 = list.stream().sorted(Comparator.comparingInt(Integer::intValue).reversed()).collect(Collectors.toList());  //倒序
        System.out.println("list2:" + list2);
        List list3 = list.stream().sorted(Comparator.comparingInt(Integer::intValue)).collect(Collectors.toList());   //正序
        System.out.println("list3:" + list3);

        //3。对象的某个字段比较
        Comparator.comparingInt(Person::getAge).reversed(); // 倒序
        Comparator.comparingInt(Person::getAge); // 正序

        //4。Collections.sort(List),String有自带的实现了comparator方法可以直接用，也可以自己实现comparator方法
        Collections.sort(list2);     //默认正序
        System.out.println("list2:" + list2);

        Collections.sort(list2, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        System.out.println("list2:" + list2);
    }
}
