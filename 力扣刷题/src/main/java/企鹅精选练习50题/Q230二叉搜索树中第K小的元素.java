package 企鹅精选练习50题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengzhen
 * @date 2020/9/16
 * @time 1:31 PM
 */
public class Q230二叉搜索树中第K小的元素 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }

    public static int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList();
        midorderTraversal(root, list);
        return list.get(k-1);
    }

    //dfs 中序遍历，第k小的几第k-1个元素
    public static void midorderTraversal(TreeNode root, ArrayList<Integer> arrayList){
        if(root.left != null){
            midorderTraversal(root.left, arrayList);
        }
        if(root != null){
            arrayList.add(root.val);
        }
        if(root.right != null){
            midorderTraversal(root.right, arrayList);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(6);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(4);
        treeNode.left.left.left = new TreeNode(1);

        kthSmallest(treeNode,3);

    }
}
