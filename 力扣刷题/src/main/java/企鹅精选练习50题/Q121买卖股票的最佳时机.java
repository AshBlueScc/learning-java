package 企鹅精选练习50题;

/**
 * @author chengzhen
 * @date 2020/9/9
 * @time 2:19 PM
 */
public class Q121买卖股票的最佳时机 {
    public static int maxProfit(int[] prices) {
        int max = 0;
        for(int i = 0; i < prices.length-1; i ++){
            for(int j = i+1; j < prices.length; j++){
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }

    /**
     * i为第i天，只需要维护一个到第i天开始的最低价格然后按照那个价格卖出就可以了，然后比较卖出去的最大值取那个值就Ok了
     */
    public static int maxProfit2(int[] prices) {
        if(prices.length==0) return 0;
        int max = 0;
        int minPrice = prices[0];
        for(int price : prices){
            if(minPrice > price){
                minPrice = price;
            }else{
                max = Math.max(max, price - minPrice);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] i1 = new int[]{7,1,5,3,6,4};
        int[] i2 = new int[]{7,6,4,3,1};
        System.out.println(maxProfit2(i1));
        System.out.println(maxProfit2(i2));
    }
}
