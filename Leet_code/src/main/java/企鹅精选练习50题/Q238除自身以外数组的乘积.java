package 企鹅精选练习50题;

import java.util.Arrays;

/**
 * @author chengzhen
 * @date 2020/9/16
 * @time 9:06 AM
 */
public class Q238除自身以外数组的乘积 {
    public static int[] productExceptSelf(int[] nums) {
        //l[i]表示nums数组下标为i的左侧的乘积
        int[] l = new int[nums.length];
        //r[i]表示nums数组下标为i的右侧的乘积
        int[] r = new int[nums.length];

        int[] target = new int[nums.length];

        //初始化
        l[0] = 1;
        r[nums.length-1] = 1;

        //计算l数组里面的值
        for(int i = 1; i < nums.length; i++){
            l[i] = l[i-1] * nums[i-1];
        }

        for(int i = nums.length - 2; i >=0; i--){
            r[i] = r[i+1] * nums[i+1];
        }

        System.out.println("l:"+Arrays.toString(l));
        System.out.println("r:"+Arrays.toString(r));
        for(int i = 0; i < nums.length; i++){
            target[i] = l[i] * r[i];
        }

        return target;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
    }
}
