package 企鹅精选练习50题;

/**
 * @author chengzhen
 * @date 2020/9/16
 * @time 9:43 AM
 */
public class Q236二叉树的最近公共祖先 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if( root != null && (root.val == p.val || root.val == q.val)){
            return root;
        }

        //遍历求出p在root的左边还是右边，q在root的左边还是右边
        boolean leftP = false;
        boolean leftQ = false;
        boolean rightP = false;
        boolean rightQ = false;
        if(root.left!=null){
            leftP = containsNode(root.left, p);
            leftQ = containsNode(root.left, q);
        }
        if(root.right!=null){
            rightP = containsNode(root.right, p);
            rightQ = containsNode(root.right, q);
        }

        if((leftP && rightQ) || (rightP && leftQ)){
            return root;
        }

        if(leftP){
            return lowestCommonAncestor(root.left, p, q);
        }else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }

    public static boolean containsNode(TreeNode root, TreeNode p){
        if(root != null && root.val == p.val){
            return true;
        }

        if(root.left != null && root.left.val == p.val){
            return true;
        }

        if(root.right != null && root.right.val == p.val){
            return true;
        }

        Boolean flag = false;

        if(root.left != null){
            flag = containsNode(root.left, p);
        }

        if(flag) return flag;

        if(root.right != null){
            flag = containsNode(root.right, p);
        }
        if(flag) return flag;
        return flag;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(37);
        treeNode.left = new TreeNode(-34);
        treeNode.right = new TreeNode(-48);
        treeNode.left.right = new TreeNode(-100);
        treeNode.right.left = new TreeNode(-101);
        treeNode.right.right = new TreeNode(48);
        treeNode.right.right.left = new TreeNode(-54);
        treeNode.right.right.left.left = new TreeNode(-71);
        treeNode.right.right.left.right = new TreeNode(-22);
        treeNode.right.right.left.right.right = new TreeNode(8);
        System.out.println(lowestCommonAncestor(treeNode, treeNode.right.right.left.left, treeNode.right.right.left.right.right).val);
    }
}
