package jianzhi; /**
 *    public class jianzhi.ListNode {
 *        int val;
 *        jianzhi.ListNode next = null;
 *
 *        jianzhi.ListNode(int val) {
 *            this.val = val;
 *        }
 *    }
 *
 */
import jianzhi.ListNode;
import java.util.ArrayList;
import java.util.Stack;

public class reverse_list {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(listNode != null){
            Stack<Integer> stack = new Stack<>();

            int ele = -1;
            while(listNode!=null){
                stack.push(listNode.val);
                listNode = listNode.next;
            }
            while(!stack.empty()){
                ele = stack.pop();
                arrayList.add(ele);
                System.out.println(ele);
            }
        }


        return arrayList;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode test1 = new ListNode();
        printListFromTailToHead(null);
    }

}