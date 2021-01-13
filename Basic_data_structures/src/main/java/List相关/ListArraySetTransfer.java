package List相关;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author chengzhen
 * @date 2020/9/15
 * @time 9:50 AM
 * List,Array,Set之间的互相转化
 */
public class ListArraySetTransfer {




    public static void main(String[] args) {


//        testArray2List();

//        testArray2Set();

//        testList2Array();

//        testList2Set();

//        set2Array();

        set2List();
    }

    /**
     * 1.int[] 转 List<Integer>
     * 2.int[] 转 Integer[]
     * 3.List<Integer> 转 Integer[]
     * 4.List<Integer> 转 int[]
     * 5.Integer[] 转 int[]
     * 6.Integer[] 转 List<Integer>
     * 7.String[] 转 List<String>
     * 8.List<String> 转 String[]
     */
    public static void testArray2List0(){
        //基本数据类型的数组转list,int[] 转List<Integer>, String[] 转 List<String>
        //1.
        int[] data = {4,5,3,6,2,5,1};
        List<Integer> list1 = Arrays.stream(data).boxed().collect(Collectors.toList());
        List<Integer> list12 = IntStream.of(data).boxed().collect(Collectors.toList());
        //2.
        Integer[] integers1 = Arrays.stream(data).boxed().toArray(Integer[]::new);
        //3.
        Integer[] integers2 = list1.toArray(new Integer[0]);
        //4.
        int[] arr1 = list1.stream().mapToInt(Integer::valueOf).toArray();
        //5.
        int[] arr2 = Arrays.stream(integers1).mapToInt(Integer::valueOf).toArray();
        //6.
        List<Integer> list2 = Arrays.asList(integers1);
        //7.
        String[] strings1 = {"A", "b", "c"};
        List<String> list3 = Arrays.asList(strings1);
        //8.
        String[] strings2 = list3.toArray(new String[0]);

    }


    /**
     * Integer[] 转 List<Integer>
     */
    public static void testArray2List(){
        //1.这三个数据结构之间的转化仅限于非基本数据类型之间的转化,有些童鞋可能会疑惑自动装箱和自动拆箱，建议去看看相关资料很多情况下是不支持的(超出你的认知)
        int[] nums = new int[]{1, 2, 3, 4};
        //Arrays.asList()无法将int[]转化成list，但是可以将Integer[]转化成List, 并且可以转化引用类型String
        //是因为list的范型只支持Integer类型
        List ls1 = Arrays.asList(nums);
        //List<int[]> ls1 = Arrays.asList(nums);
        System.out.println(ls1.toString());
        //此时变成了存储nums地址的数组

        Integer[] nums1 = new Integer[]{1, 2, 3, 4};
        List ls2 = Arrays.asList(nums1);
        //List<Integer> ls1 = Arrays.asList(nums1);
        System.out.println(ls2.toString());

    }

    /**
     * Integer[] 转 Set<Integer>
     */
    public static void testArray2Set(){
        Integer[] nums = new Integer[]{1, 2, 3, 4, 1, 2, 3, 4};
        Set<Integer> set = new HashSet(Arrays.asList(nums));
        System.out.println(Arrays.toString(set.toArray()));
    }

    /**
     * List<Integer> 转 Object[]
     */
    public static void testList2Array(){
        List<Integer> ls = Lists.newArrayList(1, 2, 3, 4);
        Object[] nums = ls.toArray();
        for(Object object : nums){
            System.out.println((Integer) object);   //单个的对象可以转类型，但是对于Object[]无法直接转化成Integer[]
        }
    }

    /**
     * List<Integer> 转 Set<Integer>
     */
    public static void testList2Set(){
        List<Integer> ls = Stream.of(1, 2, 3, 4).collect(Collectors.toList());
        Set nums = new HashSet(ls);
        System.out.println(Arrays.toString(nums.toArray()));
    }

    /**
     * Set 转 Integer[]
     */
    public static void set2Array(){
        Set nums = new HashSet(Arrays.asList(1,2,3,4, 1, 2, 3, 4));
        System.out.println(Arrays.toString(nums.toArray()));
    }

    /**
     * Set 转 List<Integer>
     */
    public static void set2List(){
        Set nums = new HashSet(Arrays.asList(1,2,3,4, 1, 2, 3, 4));
        System.out.println(Arrays.asList(nums.toArray()));
    }
}

/**
 *参考：
 * 1。https://blog.csdn.net/PitBXu/article/details/97672145
 */