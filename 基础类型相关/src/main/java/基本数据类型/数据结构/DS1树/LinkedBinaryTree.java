package 基本数据类型.数据结构.DS1树;

import lombok.Data;

/**
 * @author chengzhen
 * @date 2020/9/16
 * @time 4:49 PM
 * 链式存储的二叉树
 */
@Data
public class LinkedBinaryTree {

    private TreeNode root;

    public LinkedBinaryTree() { }

    public LinkedBinaryTree(TreeNode root) {
        this.root = root;
    }

    public void showFront(){
        if(root == null) return;
        root.frontShow();
    }

    public void showMid() {
        if(root == null) return;
        root.showMid();
    }

    public void showBack() {
        if(root == null) return;
        root.showBack();
    }

    public TreeNode frontSearch(int i) {
        return root.frontSearch(i);
    }

    public TreeNode midSearch(int i) {
        return root.midSearch(i);
    }

    public TreeNode backSearch(int i) {
        return root.backSearch(i);
    }

    public void delete(int i) {
        if(root.getVal() == i){
            root = null;
        }else {
            root.delete(i);
        }
    }
}
