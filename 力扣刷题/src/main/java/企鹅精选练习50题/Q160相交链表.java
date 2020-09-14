package 企鹅精选练习50题;

/**
 * @author chengzhen
 * @date 2020/9/14
 * @time 11:55 AM
 */
public class Q160相交链表 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode startB = headB;
        while (headA !=null){
           while (headB != null){
               if(headA == headB){
                   return headA;
               }
               headB = headB.next;
           }
           headA = headA.next;
           headB = startB;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode first_1 = new ListNode(4);
        ListNode second_1 = new ListNode(1);
        ListNode third_1 = new ListNode(8);
        ListNode fourth_1 = new ListNode(4);
        ListNode fifth_1 = new ListNode(5);
        ListNode first_2 = new ListNode(5);
        ListNode second_2 = new ListNode(0);
        ListNode third_2 = new ListNode(1);
        first_1.next = second_1;
        second_1.next = third_1;
        third_1.next = fourth_1;
        fourth_1.next = fifth_1;

        first_2.next = second_2;
        second_2.next = third_2;
        third_2.next = third_1;
        System.out.println(getIntersectionNode(first_1, first_2).val);
    }
}
