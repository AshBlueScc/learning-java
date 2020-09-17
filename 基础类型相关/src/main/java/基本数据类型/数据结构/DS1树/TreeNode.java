package 基本数据类型.数据结构.DS1树;

import lombok.Data;

import java.beans.Transient;
import java.lang.annotation.Target;

/**
 * @author chengzhen
 * @date 2020/9/16
 * @time 4:50 PM
 */
@Data
public class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public void frontShow() {
        System.out.print(val+"->");
        if(left != null){
            left.frontShow();
        }
        if(right != null){
            right.frontShow();
        }
    }

    public void showMid() {
        if(left != null){
            left.showMid();
        }
        System.out.print(val + "->");
        if(right != null){
            right.showMid();
        }
    }

    public void showBack() {
        if(left != null){
            left.showBack();
        }
        if(right != null){
            right.showBack();
        }
        System.out.print(val + "->");
    }

    public TreeNode frontSearch(int i) {
        TreeNode target = null;
        if(val == i){
            return this;
        }else{
            if(left != null){
                target = left.frontSearch(i);
            }
            if(target != null) return target;
            if(right != null){
                target = right.frontSearch(i);
            }
        }
        return target;
    }

    public TreeNode midSearch(int i) {
        TreeNode target = null;
        if(left != null){
            target = left.midSearch(i);
        }
        if(target != null){
            return target;
        }
        if(val == i){
            return this;
        }
        if(right != null){
            target = right.midSearch(i);
        }
        return target;
    }

    public TreeNode backSearch(int i) {
        TreeNode target = null;
        if(left != null){
            target = left.backSearch(i);
        }
        if(target != null) return target;
        if(right != null){
            target = right.backSearch(i);
        }
        if(target != null) return target;
        if(val == i){
            return this;
        }
        return target;
    }

    public void delete(int i) {
        if(left != null ){
            if(left.val == i){
                left = null;
            }else{
                left.delete(i);
            }
        }
        if(right != null ){
            if(right.val == i){
                right = null;
            }else{
                right.delete(i);
            }
        }
    }
}
