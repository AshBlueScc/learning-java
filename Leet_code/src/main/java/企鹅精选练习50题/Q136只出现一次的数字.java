package 企鹅精选练习50题;

/**
 * @author chengzhen
 * @date 2020/9/9
 * @time 3:40 PM
 */
public class Q136只出现一次的数字 {
    public int singleNumber(int[] nums) {
        int singleNum = 0;
        for(int num : nums){
            singleNum ^= num;
        }
        return singleNum;
    }

}
