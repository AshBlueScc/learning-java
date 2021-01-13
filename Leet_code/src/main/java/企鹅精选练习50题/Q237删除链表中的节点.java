package 企鹅精选练习50题;

/**
 * @author chengzhen
 * @date 2020/9/15
 * @time 2:23 PM
 */
public class Q237删除链表中的节点 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}
