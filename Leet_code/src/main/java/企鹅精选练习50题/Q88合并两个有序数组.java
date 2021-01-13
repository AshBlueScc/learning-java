package 企鹅精选练习50题;

import java.util.Arrays;

/**
 * @author chengzhen
 * @date 2020/9/7
 * @time 7:58 PM
 */
public class Q88合并两个有序数组 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m+n];
        int index1 = 0;
        int index2 = 0;
        int k = 0;
        while(index1 < m && index2 < n){
            if(nums1[index1] <= nums2[index2]){
                nums3[k] = nums1[index1];
                index1++;
            }else{
                nums3[k] = nums2[index2];
                index2++;
            }
            k++;
        }
        if(index1 == m){
            while (index2 < n){
                nums3[k] = nums2[index2];
                index2++;
                k++;
            }
        }else{
            while (index1 < m){
                nums3[k] = nums1[index1];
                index1++;
                k++;
            }
        }
        for(int i = 0; i < index1+index2; i++){
            nums1[i] = nums3[i];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = new int[]{2,5,6};
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
