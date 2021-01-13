package 企鹅精选练习50题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chengzhen
 * @date 2020/9/2
 * @time 11:19 AM
 */
public class Q15三数之和{

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists= new ArrayList<>();
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

                int target = -(nums[i] + nums[j]);

                while(index3 > j){
                    if(nums[index3] == target){
                        List<Integer> ls = new ArrayList<>();
                        ls.add(nums[i]);
                        ls.add(nums[j]);
                        ls.add(target);
                        lists.add(ls);
                        index3_ = index3;
                        break;
                    }
                    if(nums[index3] < target){
                        break;
                    }
                    index3 --;
                }
            }
        }
        return lists;

    }

    public static void main(String[] args) {
        for(List<Integer> ls : threeSum(new int[]{0,0,0,0})){
            System.out.println(Arrays.toString(ls.toArray()));
        }
    }
}
