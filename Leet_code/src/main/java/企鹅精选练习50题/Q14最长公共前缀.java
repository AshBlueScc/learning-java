package 企鹅精选练习50题;

import java.util.Arrays;

/**
 * @author chengzhen
 * @date 2020/9/1
 * @time 2:49 PM
 */
public class Q14最长公共前缀 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        if (strs.length == 0) {
            return "";
        }
        String s = "";
        String first = strs[0];
        for (int i = 1; i < strs.length; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < Integer.min(first.length(), strs[i].length()); j++) {
                if (first.charAt(j) == strs[i].charAt(j)) {
                    sb.append(first.charAt(j));
                } else {
                    break;
                }
            }
            first = sb.toString();
        }
        return first;
    }

    public static void main(String[] args) {
        String[] strs = {""};
        System.out.println(longestCommonPrefix(strs));
    }
}
