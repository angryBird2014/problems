package jianzhi;

/**
 * Created by xyan on 10/17/17.
 */
public class Merge {
    public ListNode solution(ListNode list1,ListNode list2){
        if (list1==null)
            return list2;
        if (list2==null)
            return list2;
        ListNode tmp = null;
        ListNode head = null;
        if (list1.val >= list2.val){
            head = list2;
            list2 = list2.next;
        }
        else{
            head = list1;
            list1 = list1.next;
        }
        tmp = head;
        while (list1!=null && list2!=null){
            if (list1.val <= list2.val){
                tmp.next = list1;
                list1 = list1.next;
            }
            else
            {
                tmp.next = list2;
                list2 = list2.next;
            }
            tmp = tmp.next;
        }
        if (list1!=null)
            tmp.next = list1;

        if (list2!=null)
            tmp.next = list2;

        return head;

    }

    public static void main(String[] args) {
        Merge m = new Merge();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 =  new ListNode(5);
        node1.next = node2;
        node2.next = node3;



        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(4);
        ListNode node7 =  new ListNode(6);
        ListNode node8 = new ListNode(8);
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        ListNode head = m.solution(node1,node5);
        while (head!=null){
            System.out.print(head.val);
            head = head.next;
        }
    }

}
