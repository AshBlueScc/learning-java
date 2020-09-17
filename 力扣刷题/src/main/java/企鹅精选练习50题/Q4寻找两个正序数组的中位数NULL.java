package 企鹅精选练习50题;

/**
 * @author chengzhen
 * @date 2020/8/25
 * @time 10:01 AM
 */
public class Q4寻找两个正序数组的中位数NULL {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] temp = nums1;
        if(nums1.length > nums2.length){
            nums1 = nums2;
            nums2 = temp;
        }

        if(nums1.length == 0){
            if(nums2.length%2 == 0){
                return (nums2[nums2.length/2]+nums2[(nums2.length-1)/2])/2;
            }else{
                return nums2[nums2.length/2];
            }
        }

        int k = (nums1.length + nums2.length)/2;
        int n = k/2;

        int index1 = 0;
        int index2 = 0;

        while(n != 0){
            if(n > nums1.length){
                return nums2[n - nums1.length - 1];
            }
//
//            if(nums1[n] < nums2[n]){
//                index1 =
//            }


        }

        return 0d;

    }

}
