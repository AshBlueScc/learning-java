package List相关;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
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

    public static void testArray2Set(){
        Integer[] nums = new Integer[]{1, 2, 3, 4, 1, 2, 3, 4};
        Set<Integer> set = new HashSet(Arrays.asList(nums));
        System.out.println(Arrays.toString(set.toArray()));
    }

    public static void testList2Array(){
        List<Integer> ls = Lists.newArrayList(1, 2, 3, 4);
        Object[] nums = ls.toArray();
        for(Object object : nums){
            System.out.println((Integer) object);   //单个的对象可以转类型，但是对于Object[]无法直接转化成Integer[]
        }
    }

    public static void testList2Set(){
        List<Integer> ls = Stream.of(1, 2, 3, 4).collect(Collectors.toList());
        Set nums = new HashSet(ls);
        System.out.println(Arrays.toString(nums.toArray()));
    }

    public static void set2Array(){
        Set nums = new HashSet(Arrays.asList(1,2,3,4, 1, 2, 3, 4));
        System.out.println(Arrays.toString(nums.toArray()));
    }

    public static void set2List(){
        Set nums = new HashSet(Arrays.asList(1,2,3,4, 1, 2, 3, 4));
        System.out.println(Arrays.asList(nums.toArray()));
    }
}
