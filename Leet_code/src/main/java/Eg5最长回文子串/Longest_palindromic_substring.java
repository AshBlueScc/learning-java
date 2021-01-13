package Eg5最长回文子串;

public class Longest_palindromic_substring {

    public static void main(String[] args){
//        System.out.println(longestPalindrome("bb"));
        int r = 0;
        int l = 0;
        r--;
        l++;
        System.out.println("r:"+r + "l:"+l);
    }


    public static String longestPalindrome(String s) {
        String pString = "";
        int maxLenth = 0;
        if(s.length() <2 ){
            return s;
        }else{
            StringBuilder sb = new StringBuilder(s);
            for(int i = 0; i<s.length(); i++){
                for(int j = i; j <= s.length(); j++){
                    String ss = sb.substring(i, j);
                    if(isPalindrome(ss)&&ss.length() > maxLenth) {
                        pString = ss;
                        maxLenth = ss.length();
                    }
                }
            }
        }
        return pString;
    }


    public static boolean isPalindrome(String s){
        for(int i = 0; i < s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)) return false;
        }
        return true;
    }
}
