package 企鹅精选练习50题;

/**
 * @author chengzhen
 * @date 2020/9/4
 * @time 9:58 AM
 */
public class Q23合并K个升序链表 {
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        ListNode now = lists[0];
        int i = 1;
        while(i < lists.length){
            ListNode next = lists[i];
            ListNode newNode = new ListNode();
            ListNode startNewNode = newNode;
            while (now != null && next != null){
                if(now.val < next.val){
                    newNode.next = new ListNode(now.val);
                    now = now.next;
                }else{
                    newNode.next = new ListNode(next.val);
                    next = next.next;
                }
                newNode = newNode.next;
            }
            if(now == null){
                newNode.next = next;
            }else {
                newNode.next = now;
            }
            now = startNewNode.next;
            i++;
        }
        return now;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[]{null, new ListNode(1)};
        ListNode l2 = mergeKLists(lists);
        while(l2 != null){
            System.out.println(l2.val);
            l2 = l2.next;
        }
    }
}
