package 企鹅精选练习50题;

/**
 * @author chengzhen
 * @date 2020/9/8
 * @time 9:14 AM
 */
public class Q104二叉树的最大深度 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int maxDepth(TreeNode root) {
        int max = 0;
        if(root == null) return max;
        if(root.left != null) max = Math.max(max, maxDepth(root.left));
        if(root.right != null) max = Math.max(max, maxDepth(root.right));
        return max + 1;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        System.out.println(maxDepth(treeNode));
    }



}


