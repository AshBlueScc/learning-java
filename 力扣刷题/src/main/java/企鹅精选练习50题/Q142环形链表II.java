package 企鹅精选练习50题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author chengzhen
 * @date 2020/9/18
 * @time 5:25 PM
 */
public class Q142环形链表II {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        int index = 0;
        while (head != null) {
            if(list.contains(head)) return head;
            list.add(head);
            head = head.next;
        }
        return null;
    }
}
