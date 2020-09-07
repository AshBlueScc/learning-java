package 企鹅精选练习50题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chengzhen
 * @date 2020/9/3
 * @time 1:41 PM
 */
public class Q16最接近的三数之和 {

    public static int threeSumClosest(int[] nums, int target) {
        int near = Integer.MAX_VALUE;
        Arrays.sort(nums);
        //为防止重复，假设三个数满足a<b<c, 且随着b增大c减小，也就是c'一定在c左边
        //时间复杂度O(n^2)
        //第一个数
        for(int i = 0; i < nums.length - 2; i++){
            //第二个数
            int index3_ = nums.length - 1;
            int index3;

            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }

            for(int j = i+1; j < nums.length - 1; j++){

                if(j>i+1 && nums[j] == nums[j-1]){
                    continue;
                }

                if(index3_ != nums.length -1){
                    index3 = index3_;
                }else{
                    index3 = nums.length - 1;
                }

                int thirdNum = -(nums[i] + nums[j] - target);

                while(index3 > j){
                    if(Math.abs(nums[index3] - thirdNum) < Math.abs(near)){
                        near = nums[index3] - thirdNum;
                    }
                    if(near == 0){
                        return near+target;
                    }
                    if(nums[index3] < thirdNum){
                        break;
                    }
                    index3 --;
                }
            }
        }
        return near+target;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-4,-1,2,1}, 1));
    }
}
