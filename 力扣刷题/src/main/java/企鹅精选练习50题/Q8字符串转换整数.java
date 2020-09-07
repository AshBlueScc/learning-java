package 企鹅精选练习50题;

import java.math.BigDecimal;

/**
 * @author chengzhen
 * @date 2020/9/1
 * @time 9:53 AM
 */
public class Q8字符串转换整数 {

    public static int myAtoi(String str) {
        String s1 = str.trim();
        if(s1.length() == 0){
            return 0;
        }
        StringBuffer sb = new StringBuffer();
        if(s1.charAt(0) == '+' || s1.charAt(0) == '-'){
            sb.append(s1.charAt(0));
            s1 = s1.substring(1, s1.length());
        }
        try {
            for(int i = 0; i < s1.length(); i++){
                if(s1.charAt(i)>='0' && s1.charAt(i) <='9'){
                    sb.append(s1.charAt(i));
                }else {
                    break;
                }
            }
            BigDecimal num1 = new BigDecimal(sb.toString());
            if(num1.compareTo(new BigDecimal(Integer.MIN_VALUE)) == -1){
                return Integer.MIN_VALUE;
            }else if(num1.compareTo(new BigDecimal(Integer.MAX_VALUE)) == 1){
               return Integer.MAX_VALUE;
            }else  {
                return Integer.parseInt(num1.toString());
            }
        }catch (Exception e){
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("20000000000000000000"));
    }
}
