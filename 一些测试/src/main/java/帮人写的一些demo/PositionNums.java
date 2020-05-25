package 帮人写的一些demo;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class PositionNums {
    public static void main(String[] args) {
        int[][]  array = {
                {2,1,0,0,1},    //0
                {1,2,2,2,0},    //1
                {0,1,1,2,2},    //2
                {2,2,1,0,0},    //3
                {2,1,0,1,2},    //4
                {0,0,1,2,2},    //5
                {0,2,2,2,0},    //6
                {1,2,2,1,2}};   //7
        int[] param = {1,2};
        ArrayList<List<Integer>> result = classify(param,array);
        System.out.println(result);
    }

    /**
     * 对给定位置数字相同的进行分类
     * @param param
     * @param array
     * @return
     */
    public static ArrayList<List<Integer>> classify(int[] param, int[][] array){
        ArrayList<List<Integer>> res = new ArrayList<>();
        //八行五列的二维数组
        for(int i = 0; i < 8;i++){
            //跟第一行相等的行索引
            List<Integer> temp = new ArrayList<>();
            temp.add(i);
           for(int j = i + 1;j < 8;j++){

                for(Integer index : param){

                    //不相等跳出for循环
                    if(array[i][index] != array[j][index]) break;
//                    if(array[i][index] != array[j][index]) break;
//                    if(array[i][index] == array[j][index] && index ==  param.length - 1 ) {
//                        List<Integer> temp = new ArrayList<>();
//                        temp.add(i);
//                        temp.add(j);
//                        res.add(temp);
//                    }
                    //相等则继续for循环，若到最后一个都相等则记录索引

                    //这里判断错了最后一个不应该这么判断
//                    if(index ==  param.length - 1 ) {
//                        temp.add(j);
//                        res.add(temp);
//                    }
                    if(index ==  param[param.length - 1] ) {
                        temp.add(j);
                        res.add(temp);
                    }

                }

            }
        }
        //去重
        //思路是把数组变成一个字符串，然后看是否包含
        List<Integer> l1 = new ArrayList();
        for(int m = 0; m < res.size(); m++){
            for(int n = m+1; n < res.size(); n++){
                String r1 = "";
                for(Integer k : res.get(m)){
                    r1 += k;
                }
                String r2 = "";
                for(Integer l : res.get(n)){
                   r2 += l;
                }
                if(r1.contains(r2)){
                    l1.add(n);
                }
            }
        }
        Set l2 = new HashSet(l1);
        String t1 = "";
        for(Object g : l2){
            t1 += g;
        }

        ArrayList<List<Integer>> res1 = new ArrayList<>();
        for(int r = 0; r < res.size(); r++){
            if(!t1.contains(r+"")){
                res1.add(res.get(r));
            }
        }

        String res1s = "";
       for(int i = 0; i < res1.size(); i++){
            for(Integer j : res1.get(i)){
                res1s += j;
            }
       }
       for(int i = 0; i < array.length; i++){
           if(!res1s.contains(i+"")){
               List lo = new ArrayList<Integer>();
               lo.add(i);
               res1.add(lo);
           }
       }
        return res1;
    }
}
