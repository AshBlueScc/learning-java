package 企鹅精选练习50题;

import java.math.BigDecimal;

/**
 * @author chengzhen
 * @date 2020/8/19
 * @time 4:48 PM
 */
public class Q62不同路径 {

    public static Integer uniquePaths1(Integer m, Integer n) {
        //机器人一定需要走m+n-2步，即向右走m-1步，向下走n-1步达到目的地
        //则只需要挑选出向下走的那几步或者挑选出向右走的那几步剩下的路径就固定了
        //则需要走的步数为
        //使用BigDecimal防止数字太大超过最大值会变成负值(Long会在正负之间震荡)
        //C(m-1, m+n-2)
        return factorial(new BigDecimal(m+n-2)).divide(factorial(new BigDecimal(m-1)).multiply(factorial(new BigDecimal(n-1)))).intValue();
    }

    public static BigDecimal factorial(BigDecimal n){
        if(n.compareTo(new BigDecimal(1)) <= 0){
            return new BigDecimal(1);
        }else {
            return n.multiply(factorial(n.subtract(new BigDecimal(1))));
        }
    }

    /** ====================================================== **/
    public static Integer uniquePaths2(Integer m, Integer n) {
        //动态规划
        //假设dp[i][j]为到达(i,j)最多路径
        //则dp[i][j]=dp[i-1][j]+dp[i][j-1]
        //对于第一行第一列 dp[0][j] = 1, dp[i][0] = 1
        Integer[][] dp = new Integer[n][m];    //n行m列
        //初始化
        for(int i = 0; i < n; i++){
            dp[i][0] = 1;
        }
        for(int j = 0; j < m; j++){
            dp[0][j] = 1;
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
//                System.out.println("["+i+","+j+"]" + "= [" + (i-1) + ","+j+"] +" + "[" + i + "," + (j-1) + "]");
              dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[n-1][m-1];
    }


    public static void main(String[] args) {
        System.out.println(uniquePaths2(23,12));
//        System.out.println(factorial(new BigDecimal(20)));
//        System.out.println(Long.MAX_VALUE);
    }
}
