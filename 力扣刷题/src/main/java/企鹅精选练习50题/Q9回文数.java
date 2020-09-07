package 企鹅精选练习50题;

/**
 * @author chengzhen
 * @date 2020/9/1
 * @time 1:32 PM
 */
public class Q9回文数 {
    public static boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        int left = s.length()/2 - 1;
        int right = s.length()/2;
        if(s.length()%2==1){
            right = right + 1;
        }
        while(left != -1){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left--;
            right++;
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(isPalindrome(110));
    }
}
