package example0流;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created By ChengZhen on 2020/1/17.
 * Author: Ash
 * Date: 2020/1/17
 * Time: 15:47
 * Debug the codes and debug the world!
 */
public class Example0_flatMap {



    public static void main(String[] args) {
//        testFlatMapE1();
//        testFlatMapE2();
        testFlatMapE3();

    }

    /**
     首先抛出一个问题，给你一张单词表，里面会有几个单词，现在的需求就是你把这些单词用到的字母找到，当然了，不包括重复的
     **/
    public static void testFlatMapE1(){
        String[] words = new String[]{"apple", "pear", "cucumber"};

        List lw = Arrays.stream(words)
                .map(word -> word.split(""))
                .distinct()
                .collect(Collectors.toList());

        System.out.println(Arrays.toString(lw.toArray()));

        List lw2 = Arrays.stream(words)
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(Arrays.toString(lw2.toArray()));
    }

    /**
     * 给定两个数组列表，[1,2,3]和[3,4]，要求返回一个所有的数组对，也就是说是这样的：[(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]
     */
    public static void testFlatMapE2(){
        Integer[] arr1 = {1, 2, 3};
        Integer[] arr2 = {3, 4};

        List ll = Arrays.stream(arr1)
                .flatMap(a -> Arrays.stream(arr2)
                .map(b -> new Integer[]{a,b }))
//                .flatMap(Arrays::stream)
                .collect(Collectors.toList());

        System.out.println(Arrays.toString(ll.toArray()));
    }

    public static void testFlatMapE3(){
        long count = IntStream.rangeClosed(1, 100).filter(i -> i % 2 == 0).count();
        System.out.println(count);
    }
}
