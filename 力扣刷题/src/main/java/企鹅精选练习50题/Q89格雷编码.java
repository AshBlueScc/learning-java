package 企鹅精选练习50题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengzhen
 * @date 2020/9/18
 * @time 5:58 PM
 */
public class Q89格雷编码 {

    public static List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for(int i = 0; i < n; i++){
            for(int j = list.size() - 1; j >=0; j--){
                list.add((1<<i)+list.get(j));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(grayCode(0));
    }


}
