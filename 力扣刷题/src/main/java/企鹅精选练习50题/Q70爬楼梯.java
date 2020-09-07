package 企鹅精选练习50题;

/**
 * @author chengzhen
 * @date 2020/9/7
 * @time 7:27 PM
 */
public class Q70爬楼梯 {
    public static int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        else if(n == 2){
            return 2;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }

    //分析，第n阶梯的前一阶梯可能是n-1或者是n-2
    //将n-1和n-2替换成n继续分析则可以通过递归解决问题
    //即f(n) = f(n-1) + f(n-2)


    public static int climbStairs1(int n) {
        if(n == 1){
            return 1;
        }
        else if(n == 2){
            return 2;
        }
        int f = 1, s = 2, p = 0;
        for(int i = 2; i < n; i++){
            p = f + s;
            f = s;
            s = p;
        }
        return p;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs1(45));
    }
}
