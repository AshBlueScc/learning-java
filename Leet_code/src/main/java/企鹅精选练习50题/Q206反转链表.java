package 企鹅精选练习50题;

/**
 * @author chengzhen
 * @date 2020/9/14
 * @time 2:27 PM
 */
public class Q206反转链表 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode reverseList(ListNode head) {
      if(head == null){
          return head;
      }
      ListNode second = head.next;
      head.next = null;
      return reverseNodes(head, second);
    }

    public static ListNode reverseNodes(ListNode now, ListNode next){
        if(next == null) return now;
        ListNode third = next.next;
        next.next = now;
        return reverseNodes(next, third);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        ListNode tail = reverseList(head);
        while (tail != null){
            System.out.println(tail.val);
            tail = tail.next;
        }
    }

}
