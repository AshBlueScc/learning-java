package Eg2两数相加;

public class add_two_numbers {

    public static void main(String[] args){
        ListNode l1 = new ListNode(5);
//        l1.next = new ListNode(1);
//        l1.next.next = new ListNode(6);

        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

        ListNode l3 = addTwoNumbers(l1, l2);
        System.out.print(l3.val);
        while(l3.next !=  null){
            l3 = l3.next;
            System.out.print("->" + l3.val);
        }
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String s1 ="" + l1.val;
        String s2 ="" + l2.val;
        ListNode temp1 = l1.next;
        while(temp1 != null){
            s1 += temp1.val;
            temp1 = temp1.next;
        }
        ListNode temp2 = l2.next;
        while(temp2 != null){
            s2 += temp2.val;
            temp2 = temp2.next;
        }
        //让s1为长串
        if(s2.length() > s1.length()){
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }
        //给s2补0使他们一样长
        int lent = s1.length() - s2.length();
        for(int i = 0; i < lent; i++){
            s2 += 0;
        }
        //计算他们实际和,并存储为到一个string里面去
        String s3 = "";
        int temp = 0;//若同位相加大于10则进1
        int add = 0;
        for(int i = 0; i < s1.length(); i++){
            add = (s1.charAt(i) - '0' + s2.charAt(i) - '0') + temp;
            temp = add >= 10 ? 1 : 0;
            add = temp == 0 ? add : add-10;
            s3 += add;
        }
        s3 = temp == 0 ? s3 : s3+1;
        ListNode ln = new ListNode(s3.charAt(0) - '0');
        ListNode tempLn = ln;
        for(int i = 1; i < s3.length(); i++){
            tempLn.next = new ListNode(s3.charAt(i) - '0');
            tempLn = tempLn.next;
        }
        return ln;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

}
