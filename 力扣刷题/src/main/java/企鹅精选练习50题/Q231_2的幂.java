package 企鹅精选练习50题;

/**
 * @author chengzhen
 * @date 2020/9/15
 * @time 11:11 AM
 */
public class Q231_2的幂 {

    public static boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        int reMainder = 0;
        int divisor = n;
        while (divisor != 1){
            reMainder += divisor%2;
            divisor = divisor/2;
        }
        if(reMainder == 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(isPowerOfTwo(1));
//        System.out.println(isPowerOfTwo(16));
//        System.out.println(isPowerOfTwo(218));
        System.out.println(isPowerOfTwo(5));


    }
}
