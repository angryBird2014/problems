package jianzhi;

/**
 * Created by xyan on 1/22/18.
 */
public class EntryNodeOfLoop {
    public ListNode solution(ListNode pHead){
        if (pHead==null)
            return null;
        ListNode quick = pHead.next;
        if (quick==null)
            return null;
        ListNode slow = pHead;
        while(quick!=slow){   //快慢指针没有相遇的
            quick = quick.next.next;
            slow = slow.next;
        }
        //快慢指针相遇
        int length = 1;
        quick = quick.next;
        while (quick!=slow){
            length++;
            quick = quick.next;
        }
        //环长
        quick = pHead;
        slow = pHead;
        int index = 1 ;
        while (index <= length){
            quick = quick.next;
            index ++;
        }
        while (quick!=slow){
            quick = quick.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        EntryNodeOfLoop  s = new EntryNodeOfLoop();
        ListNode head = new ListNode();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node1;
        System.out.println(s.solution(head).val);
    }
}
