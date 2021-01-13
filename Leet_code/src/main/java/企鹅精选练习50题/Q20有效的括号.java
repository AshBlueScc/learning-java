package 企鹅精选练习50题;

import java.util.Stack;

/**
 * @author chengzhen
 * @date 2020/8/19
 * @time 3:04 PM
 */
public class Q20有效的括号 {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i < s.length(); i++){
           if(String.valueOf(s.charAt(i)).equals("[")){
               stack.push(']');
           }else if(String.valueOf(s.charAt(i)).equals("{")){
               stack.push('}');
           }else if(String.valueOf(s.charAt(i)).equals("(")){
               stack.push(')');
           }else{
               if (stack.isEmpty() || stack.pop().compareTo(s.charAt(i)) != 0){
                   return false;
               }
           }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([)]";
        String s5 = "{[]}";
        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));
        System.out.println(isValid(s4));
        System.out.println(isValid(s5));

    }
}
