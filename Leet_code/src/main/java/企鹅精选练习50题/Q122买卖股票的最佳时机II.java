package 企鹅精选练习50题;

/**
 * @author chengzhen
 * @date 2020/9/9
 * @time 3:29 PM
 */
public class Q122买卖股票的最佳时机II {

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i ++){
            if(prices[i] > prices[i-1]){
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] i1 = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(i1));
    }
}
