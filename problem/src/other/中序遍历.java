package other;

import apple.laf.JRSUIUtils;
import jianzhi.TreeNode;

import java.util.Stack;

//利用O(1)空间统计遍历的每个节点的层次。（Bug Free Code）
//非递归
public class 中序遍历 {
    public void no_digui(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        if (root==null)
            return;

        while (!stack.isEmpty() || root!=null){
            if (root!=null){
                stack.add(root);
                root = root.left;
            }
            else {
                root = stack.pop();
                System.out.println(root.val);
                root = root.right;
            }
        }
    }

    public void qianxu(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        if (root==null)
            return;
        while(!stack.isEmpty() || root!=null){
            if (root!=null){
                System.out.println(root.val);
                stack.add(root);
                root = root.left;
            }
            else{
                root = stack.pop();
                root = root.right;
            }
        }
        
    }

    public void houxu(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (!stack.isEmpty() || root!=null){
            if (root!=null){
                stack.add(root);
                root = root.left;
            }
            else {
                root = stack.peek();
                //右子树不为空，且未被访问
                if (root.right!=null && root.right != pre){
                    root = root.right;
                    stack.add(root);
                    root = root.left;
                }
                else {
                    root = stack.pop();
                    System.out.println(root.val);
                    pre = root;
                    root = null;
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2  = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(8);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node6;
        node2.right = node7;
        new 中序遍历().houxu(root);
    }

}
