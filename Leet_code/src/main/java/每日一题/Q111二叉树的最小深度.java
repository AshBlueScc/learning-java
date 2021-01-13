package 每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengzhen
 * @date 2020/8/21
 * @time 1:36 PM
 */
public class Q111二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        //递归先求出左边node的最小深度，然后再去比较右边的最小深度，取最小的
        //DFS 深度搜索优先
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return 1;
        }

        Integer min_depth = Integer.MAX_VALUE;
        if(root.left != null){
            min_depth = Math.min(min_depth, minDepth(root.left));
        }
        if(root.right != null){
            min_depth = Math.min(min_depth, minDepth(root.right));
        }
        return min_depth + 1;
    }

     public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
