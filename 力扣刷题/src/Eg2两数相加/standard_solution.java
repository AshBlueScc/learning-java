package Eg2两数相加;

public class standard_solution {
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);

        ListNode l2 = new ListNode(2);


        ListNode l3 = addTwoNumbers(l1, l2);

        while(l3.next !=  null){
            l3 = l3.next;
            System.out.print("->" + l3.val);
        }
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0);
        ListNode ln = start;
        int carry = 0;
        int sum = 0;
        while(l1 != null || l2 !=null){
            int x = l1==null?0:l1.val;
            int y = l2==null?0:l2.val;
            sum = x + y +carry;
            carry = sum /10;
            start.next = new ListNode(sum%10);
            start = start.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(carry > 0){
            start.next = new ListNode(carry);
        }
        return ln.next;
    }

}

