package jianzhi;

/**
 * Created by xyan on 10/11/17.
 */
//代码问题不知道出现哪地方
public class FindKthToTail {

    public ListNode solution(ListNode head,int k){
        int j = 0;
        ListNode first = head;
        ListNode last = head;
        while (last.next!=null && j<k-1){
            last = last.next;
            j++;
        }
        if (j<k-1)
            return head;
        while(last.next!=null){
            first = first.next;
            last = last.next;
        }
        return first;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        //head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        FindKthToTail f = new FindKthToTail();
        System.out.println(f.solution(head,100).val);
    }
}
