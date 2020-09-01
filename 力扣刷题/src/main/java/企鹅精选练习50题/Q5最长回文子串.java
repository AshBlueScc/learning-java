package 企鹅精选练习50题;

/**
 * @author chengzhen
 * @date 2020/8/26
 * @time 3:31 PM
 */
public class Q5最长回文子串 {
    public static String longestPalindrome(String s) {

        if(s.length() == 0){
            return "";
        }

        int maxLen = 0;
        int index = 0;
        for(int i = 0; i < s.length(); i ++){
            int e = expandAroundCenter(s, i, i);
           if( e > maxLen){
               maxLen = e;
               index = i;
           }
        }
        int maxLen2 = 0;
        int index2 = 0;
        for(int i = 0; i < s.length() - 1; i ++){
            int e = expandAroundCenter(s, i, i+1);
            if(e > maxLen2){
                maxLen2 = e;
                index2 = i;
            }
        }


        if(maxLen > maxLen2){
            return s.substring(index-maxLen/2, index+maxLen/2+1);
        }else{
            return s.substring(index2-(maxLen2-1)/2, index2+(maxLen2)/2+1);
        }

    }

    public static int expandAroundCenter(String s, Integer left, Integer right){
        int L = left, R = right;
        while(L >= 0 && R < s.length() && L <= R && s.charAt(L)==s.charAt(R)){
            L--;
            R++;
        }
        return R-L-1;
    }

    public static void main(String[] args) {
        String s = "";
        System.out.println(longestPalindrome(s));
    }
}
