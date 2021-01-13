package 企鹅精选练习50题;

import java.util.Arrays;

/**
 * @author chengzhen
 * @date 2020/9/4
 * @time 1:46 PM
 */
public class Q26删除排序数组中的重复项 {

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return nums.length;
        }
        int left = 0;
        int right = 1;

        for(int i = 0; i < nums.length-1; i++){
            if(nums[left] == nums[right]){
                right++;
            }else{
                nums[left+1]=nums[right];
                left++;
                right++;
            }
        }
        return left+1;
    }

    public static void main(String[] args) {
        int[] int1 = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(int1));
        System.out.println(Arrays.toString(int1));
    }
}
