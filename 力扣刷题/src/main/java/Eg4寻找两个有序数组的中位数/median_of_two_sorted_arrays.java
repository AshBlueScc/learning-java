package Eg4寻找两个有序数组的中位数;

public class median_of_two_sorted_arrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
//        System.out.println();

    }

    //O((m+n)/2)
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //让nums1为长字符串
        if (nums1.length < nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        if (nums2.length == 0) {
            if (nums1.length % 2 == 1) {
                return nums1[nums1.length / 2];
            } else {
                return (double)(nums1[nums1.length / 2] + nums1[nums1.length / 2 - 1]) / 2;
            }
        }
        int m = 0;
        int n = 0;
        int[] nums3 = new int[nums1.length + nums2.length];
        int i = 0;
        while(m < nums1.length && n < nums2.length){
            if(nums1[m] <= nums2[n]){
                nums3[i] = nums1[m];
                m++;
            }else{
                nums3[i] = nums2[n];
                n++;
            }
            i++;
        }

        while(m < nums1.length){
            nums3[i] = nums1[m];
            i++;
            m++;
        }

        while(n < nums2.length){
            nums3[i] = nums2[n];
            i++;
            n++;
        }
        return nums3.length % 2 == 1 ? nums3[nums3.length/2] : (double)(nums3[nums3.length/2] + nums3[nums3.length/2 -1])/2;
    }
}
