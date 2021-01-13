package 企鹅精选练习50题;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chengzhen
 * @date 2020/8/21
 * @time 5:07 PM
 */
public class Q78子集 {

    public static List<List<Integer>> subsets(int[] nums) throws IOException, ClassNotFoundException {
        List<List<Integer>> ls = new ArrayList<List<Integer>>();
        ls.add(new ArrayList<Integer>());

        for(Integer num : nums){
            //此处必须深拷贝
            List<List<Integer>> lsc = null;
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream out = null;
            out = new ObjectOutputStream(byteOut);
            out.writeObject(ls);
            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream in = new ObjectInputStream(byteIn);
            lsc = (List<List<Integer>>) in.readObject();
            for(List<Integer> l : lsc){
                l.add(num);
                ls.add(l);
            }
        }
        return ls;
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int[] ls = new int[]{1, 2 ,3};
        System.out.println(subsets(ls));
    }
}
