package 企鹅精选练习50题;

/**
 * @author chengzhen
 * @date 2020/9/4
 * @time 8:58 AM
 */
public class Q21合并两个有序链表 {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode start = l3;

        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                l3.next = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                l3.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            l3 = l3.next;
        }

        if(l1 == null){
            l3.next = l2;
        }else{
            l3.next = l1;
        }
        return start.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = mergeTwoLists(l1, l2);
        while (l3 != null){
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }
}
