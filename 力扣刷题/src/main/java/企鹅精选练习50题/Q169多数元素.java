package 企鹅精选练习50题;

import java.util.HashMap;

/**
 * @author chengzhen
 * @date 2020/9/14
 * @time 2:03 PM
 */
public class Q169多数元素 {

    public static int majorityElement(int[] nums) {
        int element = 0;
        int frequency = 0;
        HashMap<Object, Integer> hashMap = new HashMap();
        for(int num : nums){
            if (hashMap.get(num)!=null){
                int sf = Integer.valueOf(hashMap.get(num)+1);
                hashMap.put(num, sf);
                if (sf > frequency){
                    frequency = sf;
                    element = num;
                }
            }else{
                hashMap.put(num, 1);
                if (1 > frequency){
                    frequency = 1;
                    element = num;
                }
            }
        }
        return element;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3}));
    }
}
