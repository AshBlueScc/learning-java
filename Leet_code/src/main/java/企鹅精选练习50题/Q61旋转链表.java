package 企鹅精选练习50题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chengzhen
 * @date 2020/9/21
 * @time 2:40 PM
 */
public class Q61旋转链表 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0){
            return head;
        }
        LinkedList<ListNode> ls = new LinkedList<>();
        ListNode head2 = head;
        while (head2 != null) {
            ls.add(head2);
            head2 = head2.next;
        }
        ListNode tail = ls.getLast();
        tail.next = head;
        int lastIndex = ls.indexOf(tail);
        k = k%ls.size();
        while (k != 0) {
            lastIndex --;
            k--;
            if(lastIndex == -1){
                lastIndex = ls.indexOf(tail);
            }
        }
        ListNode head3 = ls.get(lastIndex).next;
        ls.get(lastIndex).next = null;
        return head3;
    }
}
