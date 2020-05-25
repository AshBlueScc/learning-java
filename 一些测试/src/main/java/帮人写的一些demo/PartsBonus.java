package 帮人写的一些demo;

/**
 * @author chengzhen
 * @date 2020/5/7
 * @time 下午5:09
 */
public class PartsBonus {

    public static void main(String[] args) {
        System.out.println(calculateBonus2(11111111));
        System.out.println(calculateBonus(1111.1111));
    }

    /**
     * 企业发放的奖金根据利润提成。利润(I)低于或等于10万元时，奖金可提10%；
     * 利润高于10万元，低于20万元时，低于10万元的部分按10%提成，高于10万元的部分，可提成7.5%；
     * 20万到40万之间时，高于20万元的部分，可提成5%；
     * 40万到60万之间时高于40万元的部分，可提成3%；
     * 60万到100万之间时，高于60万元的部分，可提成1.5%，高于100万元时，超过100万元的部分按1%提成，从键盘输入当月利润I，求应发放奖金总数？
     */

    /**
     * 计算奖金
     * @param profit 利润（万为单位）
     * @return
     */
    public static double calculateBonus(double profit){
        //总奖金数额
        double bonus = 0;
        //利润低于10万
        if(profit < 10){
            bonus = profit  * 0.1;
        }
        //利润在10到20万之间
        if(profit < 20 && profit >= 10){
            bonus = 10 * 0.1 + (profit - 10) * 0.075;
        }
        //利润在10到20万之间
        if(profit < 20 && profit >= 10){
            bonus = 10 * 0.1 + (profit - 10) * 0.075;
        }
        //利润在20到40万之间
        if(profit < 40 && profit >= 20){
            bonus = 10 * 0.1 + 10 * 0.075 + (profit - 20) * 0.05;
        }
        //利润在40到60万之间
        if(profit < 60 && profit >= 40){
            bonus = 10 * 0.1 + 10 * 0.075 + 20 * 0.05 + (profit - 40)*0.03;
        }
        //利润在60到100万之间
        if(profit < 100 && profit >= 60){
            bonus = 10 * 0.1 + 10 * 0.075 + 20 * 0.05 + 20 * 0.03 + (profit - 60)*0.015;
        }
        //利润超过100万
        if(profit > 100){
            bonus = 10 * 0.1 + 10 * 0.075 + 20 * 0.05 + 20 * 0.03 + 40 * 0.015 + (profit -100)*0.01;
        }
        return bonus;
    }

    /**
     * 计算奖金
     * @param profit 利润（万为单位）
     * @return
     */
    public static double calculateBonus2(double profit){
        //总奖金数额
        double bonus = 0;
        int[] segs = new int[]{1000000, 600000, 400000, 200000, 100000, 0};
        double[] rate = new double[]{0.01, 0.015, 0.03, 0.05, 0.075, 0.1};
        for(int i = 0; i < segs.length; i ++){
            System.out.println("第"+i+"次循环"+"bonus:" + bonus);
            if(profit > segs[i]){
                System.out.println("利润大于"+segs[i]);
                bonus += (profit - segs[i])*rate[i];
                profit = segs[i];
            }
        }
        return bonus;
    }
}
