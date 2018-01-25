package jianzhi;

import com.sun.xml.internal.fastinfoset.tools.FI_DOM_Or_XML_DOM_SAX_SAXEvent;

import java.util.Iterator;

/**
 * Created by xyan on 1/22/18.
 */
public class deleteDuplication {
    public ListNode solution(ListNode pHead){
        if(pHead==null)
            return null;
        if (pHead.next==null)
            return pHead;

        ListNode first = new ListNode(-1);
        first.next = pHead;
        ListNode pre = first;
        ListNode current = pHead;
        while (current!=null && current.next!=null){
            if(current.val == current.next.val){
                int value = current.val;
                while (current!=null && current.val==value)
                    current = current.next;
                pre.next = current;
            }
            else{
                pre = current;
                current = current.next;
            }

        }
        return first.next;
    }

    public static void main(String[] args) {
        deleteDuplication s = new deleteDuplication();
        ListNode head = new ListNode();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode tmp = s.solution(head);
        while (tmp.next!=null){
            tmp = tmp.next;
            System.out.println(tmp.val);
        }


    }
}
