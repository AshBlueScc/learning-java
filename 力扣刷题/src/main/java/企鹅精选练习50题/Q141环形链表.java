package 企鹅精选练习50题;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chengzhen
 * @date 2020/9/14
 * @time 9:34 AM
 */
public class Q141环形链表 {
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> listNodeSet = new HashSet<>();
        while (head != null){
            if(listNodeSet.contains(head)){
                return true;
            }else{
                listNodeSet.add(head);
            }
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(3);
        ListNode seconde = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);
        first.next = seconde;
        seconde.next = third;
        third.next = fourth;
        fourth.next = seconde;
        System.out.println(hasCycle(first));

    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
        val = x;
        next = null;
    }
  }
}
