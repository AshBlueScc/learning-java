package 企鹅精选练习50题;

/**
 * @author chengzhen
 * @date 2020/9/15
 * @time 2:54 PM
 */
public class Q557反转字符串中的单词III {
    public static String reverseWords(String s) {
        StringBuffer sb = new StringBuffer();
        String[] ss = s.split(" ");
        for(String s1 : ss){
            for(int i = s1.length()-1; i >=0; i--){
                sb.append(s1.charAt(i));
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}
