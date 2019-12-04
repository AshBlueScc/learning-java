package 最长回文子串5;

public class Standard_solution1_expandAroundCenter {

    public static void main(String[] args){
        System.out.println(longestPalindrome( "bb"));
    }


    public static String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
        int start = 0;
        int end = 0;
        for(int i = 0; i < s.length(); i++){
        int len = expandAroundCenter(s, i, i);
        int len1 = expandAroundCenter(s, i, i+1);
        int len2 = Math.max(len,len1 );
        if(len2 > end - start ){
            start = i -(len2 - 1)/2;        //分奇偶，然后根据取整情况
            end = len2/2 + i ;          //分奇偶，然后根据取整情况，len2下面的不能减一，否则偶数情况错误，减一基数情况也满足，偶数情况也满足
        }
    }
        return s.substring(start, end+1);
}

    private static int expandAroundCenter(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
}
