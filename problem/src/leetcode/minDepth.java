package leetcode;

import jianzhi.TreeNode;

public class minDepth {

    public static int solution(TreeNode root){
        if (root==null)
            return 0;
        int n = helper(root);
        return n;
    }
    public static int helper(TreeNode node){
        if (node==null)
            return 0;

        if(node.left==null)
          return 1+helper(node.right);
        if (node.right==null)
            return 1+helper(node.left);
        return 1+Math.min(helper(node.left),helper(node.right));
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
//        root.right = node2;
//        node1.left = node3;
//        node1.right = node4;
//        node2.left = node6;
//        node2.right = node7;
        System.out.println(new minDepth().solution(root));
    }
}
