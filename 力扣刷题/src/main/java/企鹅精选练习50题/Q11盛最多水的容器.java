package 企鹅精选练习50题;

/**
 * @author chengzhen
 * @date 2020/9/1
 * @time 2:32 PM
 */
public class Q11盛最多水的容器 {

    public static int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < height.length; i++){
            for(int j = i+1; j < height.length; j ++){
                int area = (j-i) * Integer.min(height[i], height[j]);
                if(area > maxArea){
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] a = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(a));
    }
}
