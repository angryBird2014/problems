package jianzhi;

/**
 * Created by xyan on 1/25/18.
 */
class TreeLinkNode{
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class GetNext {
    public TreeLinkNode solution(TreeLinkNode pNode){
        if(pNode==null)
            return null;
        if (pNode.right!=null){ //右子树不空，找右子树的最左的节点
            TreeLinkNode right = pNode.right;
            while(right.left!=null){
                right = right.left;
            }
            return right;
        }
        else { //右子树为空,找其父亲节点，第一个父亲节点为其祖先节点的左孩子
            TreeLinkNode current = pNode;
            if (current.next==null) //根节点
                return null;
            else {    //非根节点
                TreeLinkNode parent = pNode.next;
                while (parent!=null && parent.left!=current){
                    current = parent;
                    parent = parent.next;
                }
                return parent;
            }
        }

    }

    public static void main(String[] args) {
        GetNext s = new GetNext();
        TreeLinkNode root = new TreeLinkNode(0);
        TreeLinkNode node1 = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        TreeLinkNode node5 = new TreeLinkNode(5);
        TreeLinkNode node6 = new TreeLinkNode(6);
        TreeLinkNode node7 = new TreeLinkNode(7);
        TreeLinkNode node8 = new TreeLinkNode(8);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node4.right = node6;
        node6.left = node8;
        node6.right = node7;

        root.next = null;
        node1.next = root;
        node2.next = root;
        node3.next = node1;
        node4.next = node2;
        node5.next = node2;
        node6.next = node4;
        node8.next = node6;
        node7.next = node6;
        System.out.println(s.solution(node5).val);

        }
    }




