package 基本数据类型.数据结构.DS1树;

/**
 * @author chengzhen
 * @date 2020/9/17
 * @time 9:38 AM
 */
public class TestArrayTree {

    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 4, 5, 6, 7};

        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(data);
        arrayBinaryTree.frontShow(0);
    }
}
