package 基本数据类型.数据结构.DS1树;

/**
 * @author chengzhen
 * @date 2020/9/17
 * @time 9:28 AM
 */
public class ArrayBinaryTree {

    int[] data;

    public ArrayBinaryTree(int[] data) {
        this.data = data;
    }

    public void frontShow(int start){
        if(data == null || start >= data.length){
            return;
        }
        System.out.print(data[start] + "->");
        frontShow(2*start+1);
        frontShow(2*start+2);
    }

    //其他遍历方法根链式的基本一样
}
