package 企鹅精选练习50题;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author chengzhen
 * @date 2020/9/17
 * @time 10:02 AM
 */
public class Q215数组中的第K个最大元素 {

    public static int findKthLargest(int[] nums, int k) {
        List<Integer> nums1 = Arrays.stream(nums).boxed().collect(Collectors.toList());
        nums1.sort(Comparator.comparingInt(Integer::intValue));
        return nums1.get(nums1.size() - k);
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));

    }
    // 1 2 3 4 5 6
}
