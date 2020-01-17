package Eg121买卖股票的最佳时机;

import java.util.Arrays;
import java.util.Scanner;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String sa = sc.nextLine();
        String[] sa2 = sa.replace("[", "").replace("]", "").replace(" ","").split(",");
        System.out.println(Arrays.toString(sa2));
        int[] array = new int[sa2.length];
        for(int i = 0; i < sa2.length; i++){
            array[i] = Integer.parseInt(sa2[i]);
        }
        System.out.println(maxProfit(array));

    }

        private static int maxProfit(int[] prices) {
            int max = 0;
            for(int i = 0; i < prices.length - 1; i++){
                for(int j = i + 1; j < prices.length; j++){
                    int profit = prices[j] - prices[i];
                    if(profit > max){
                        max = profit;
                    }
                }
            }
            return max > 0 ? max:0;
        }


}
