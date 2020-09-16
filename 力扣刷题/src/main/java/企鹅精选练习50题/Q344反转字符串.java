package 企鹅精选练习50题;

/**
 * @author chengzhen
 * @date 2020/9/15
 * @time 2:50 PM
 */
public class Q344反转字符串 {
    public void reverseString(char[] s) {
        for(int i = 0; i < s.length/2; i++){
            char temp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i]=temp;
        }
    }
}
