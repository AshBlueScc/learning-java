package 企鹅精选练习50题;

/**
 * @author chengzhen
 * @date 2020/9/7
 * @time 6:13 PM
 */
public class Q53最大子序和 {
    public static int maxSubArray(int[] nums) {
        int pre = nums[0];    //i结尾最大子序和是，i-1结尾最大子序和即为pre
        int max = pre;
        for(int i = 1; i < nums.length; i++){
            int next = Math.max(pre+nums[i], nums[i]);
            max = Math.max(max, next);
            pre = next;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
