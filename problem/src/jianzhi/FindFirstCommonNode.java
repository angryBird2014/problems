package jianzhi;

/**
 * Created by xyan on 12/16/17.
 */
public class FindFirstCommonNode {
    public static ListNode solution(ListNode pHead1,ListNode pHead2){
        int length1 = 0,length2 = 0;
        ListNode p1 = pHead1,p2 = pHead2;
        while(p1.next!=null){
            length1 ++;
            p1 = p1.next;
        }
        while (p2.next!=null){
            length2 ++ ;
            p2 = p2.next;
        }
        int step = Math.abs(length1-length2),i=0;
        p1 = pHead1.next;
        p2= pHead2.next;
        if (length1<=length2){
            while (i<step){
                p2 = p2.next;
                i++;
            }


        }
        else {
            while (i<step){
                p1 = p1.next;
                i++;
            }


        }
        while (p1!=null && p2!=null){
            if (p1 == p2)
                return p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode();
        ListNode head2 = new ListNode();
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);

        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);
        ListNode p6 = new ListNode(6);
        ListNode p7 = new ListNode(7);
        head1.next = p1;
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p7;

        head2.next = p5;
        p5.next = p6;
        p6.next = p7;
        System.out.println(solution(head1,head2).val);
    }
}
