package 基本数据类型.数据结构.DS1树;

/**
 * @author chengzhen
 * @date 2020/9/16
 * @time 3:46 PM
 * 树相关的复习
 */
public class TestLinkedTree {
    //1。树出现的原因是，数组插入删除不方便查找方便，链表插入删除方便查找不方便，树综合了两者(线性数据结构)的优势并且解决了两者的劣势

    public static void main(String[] args) {
        LinkedBinaryTree linkedBinaryTree = new LinkedBinaryTree();
        TreeNode root = new TreeNode(1);
        linkedBinaryTree.setRoot(root);
        TreeNode rootL = new TreeNode(2);
        TreeNode rootR = new TreeNode(3);
        root.setLeft(rootL);
        root.setRight(rootR);
        TreeNode leftL = new TreeNode(4);
        TreeNode leftR = new TreeNode(5);
        rootL.setLeft(leftL);
        rootL.setRight(leftR);
        TreeNode rightL = new TreeNode(6);
        TreeNode rightR = new TreeNode(7);
        rootR.setLeft(rightL);
        rootR.setRight(rightR);

        //前序遍历
        linkedBinaryTree.showFront();
        System.out.println();
        //中序遍历
        linkedBinaryTree.showMid();
        System.out.println();
        //后序遍历
        linkedBinaryTree.showBack();
        System.out.println();


        //前序查5
        TreeNode sfNode = linkedBinaryTree.frontSearch(8);
        if(sfNode != null){
            System.out.println("前序查找成功:"+sfNode.getVal());
        }else {
            System.out.println("前序查找失败:" + sfNode);
        }

        //中序查找
        TreeNode smNode = linkedBinaryTree.midSearch(5);
        if(smNode != null){
            System.out.println("中序查找成功:"+smNode.getVal());
        }else {
            System.out.println("中序查找失败:" + smNode);
        }

        //后序查找
        TreeNode sbNode = linkedBinaryTree.backSearch(4);
        if(sbNode != null){
            System.out.println("后序查找成功:"+sbNode.getVal());
        }else {
            System.out.println("后序查找失败:" + sbNode);
        }

        //删除一个子树
        linkedBinaryTree.delete(2);
        System.out.print("删除一个子树后：");
        linkedBinaryTree.showFront();
    }


}

/**
 * 参考：
 * 1.https://www.bilibili.com/video/BV1Zt411o7Rn?p=28
 * 2.笔记见有道云笔记
 */