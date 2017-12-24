package jianzhi;


import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xyan on 10/5/17.
 */
public class reconstruct_tree {
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root = reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }

    public static TreeNode reConstructBinaryTree(int[] pre,int preStart,int preEnd,int[] in,int inStart,int inEnd) {

        if ((preStart >=0 &&preStart > preEnd) ||(inStart >= 0 && inStart > inEnd))
            return null;
        TreeNode node = new TreeNode(pre[preStart]);
        int i = -1;
        for (i = inStart; i <= inEnd; i++) {
            if (in[i] == pre[preStart]){
                node.left = reConstructBinaryTree(pre, preStart + 1, preStart + i - inStart, in, inStart, i - 1);
                node.right = reConstructBinaryTree(pre, preStart + 1 + i - inStart, preEnd, in, i + 1, inEnd);
            }
        }

        return node;
    }

    public static void levelOutput(TreeNode node){
        if (node==null){
            return ;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = node;
        TreeNode tmp = null;
        queue.offer(root);
        while (!queue.isEmpty()){
            tmp  = queue.poll();
            System.out.print(tmp.val + " ");
            if (tmp.left!=null)
                queue.add(tmp.left);
            if (tmp.right!=null)
                queue.add(tmp.right);
        }
    }


    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};

        int[] pre1 ={4,7};
        int[] in1 = {4,7};
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node8 = new TreeNode(8);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node4.right = node7;
        node6.left = node8;
        TreeNode node  = reConstructBinaryTree(pre,in);
        levelOutput(node);

    }
}
