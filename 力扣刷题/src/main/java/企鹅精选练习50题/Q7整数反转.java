package 企鹅精选练习50题;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Array;
import java.util.Stack;

/**
 * @author chengzhen
 * @date 2020/8/27
 * @time 10:42 AM
 */
public class Q7整数反转 {

    public static int reverse(int x) {
        if(x==0) return 0;
        Stack<Integer> stack = new Stack();
        int y = x;
        int counts = Integer.toString(x).length();
        if(x < 0){
            counts -= 1;
        }
        for(int i = counts; i > 0; i--){
            Integer t = 1;
            for(int j = i - 1; j>0; j--){
                t *= 10;
            }
            stack.push(y/t);
            y = y - (y/t) * t;
        }
        StringBuffer sb = new StringBuffer();
        if(x < 0){
            sb.append("-");
        }
        while (!stack.isEmpty()){
            sb.append(Math.abs(stack.pop()));
        }
        try{
            return Integer.parseInt(sb.toString());
        }catch (Exception e){
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
    }

}
