package 企鹅精选练习50题;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chengzhen
 * @date 2020/9/15
 * @time 8:58 AM
 */
public class Q217存在重复元素 {

    public static boolean containsDuplicate(int[] nums) {
        if(nums.length == 0) return false;
        Set<Integer> numSet = new HashSet<>();
        for(int num : nums){
            if(numSet.contains(num)){
                return true;
            }else{
                numSet.add(num);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{3 , 1}));
    }
}
