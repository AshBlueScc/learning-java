package 企鹅精选练习50题;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengzhen
 * @date 2020/9/21
 * @time 3:29 PM
 */
public class Q54螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        //先取左上(0,0)，右上(0,n)，左下(m,0)，右下(m,n)四个点
        int i, j = matrix.length; //i为变动的起始行，j为变动的结束行
        int m , n = matrix[0].length; //m为变动的起始列，n为变动的结束列
        for(i = 0; i < matrix.length/2; i ++){
            for(m = 0; m < matrix[0].length; m++){
                list.add(matrix[i][matrix[0].length - 1 - m]);
            }
        }
        return list;
    }


    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject(true);
        jsonObject.put("description", "通过输入手机号与卡号信,对卡片进行实名认证,只有实名认证通过后的卡片才可以开通套餐及正常使用");
        System.out.println(jsonObject.toString());
    }
}
