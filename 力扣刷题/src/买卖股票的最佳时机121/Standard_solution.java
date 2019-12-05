package 买卖股票的最佳时机121;

public class Standard_solution {
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int price : prices){
            if(price < minPrice){
                minPrice = price;

            }else if(maxProfit < price - minPrice) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }
}
