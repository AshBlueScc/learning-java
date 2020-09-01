package 企鹅精选练习50题;

/**
 * @author chengzhen
 * @date 2020/8/24
 * @time 10:29 AM
 */
public class Q2两数相加 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0);
        ListNode l3 = start;

        int carry = 0;
        int sum = 0;
        while(l1 != null || l2 != null){
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;


            sum = x + y + carry;
            l3.next = new ListNode(sum%10);
            l3 = l3.next;
            carry = sum / 10;

            if(carry != 0){
                l3.next = new ListNode(carry);
            }

            l1 = l1==null?null:l1.next;
            l2 = l2==null?null:l2.next;
        }

        return start.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1);
        l1.next = new ListNode(9);
        ListNode start = addTwoNumbers(l1 ,l2);
        while (start != null){
            System.out.print(start.val + "->");
            start = start.next;
        }
    }
}
