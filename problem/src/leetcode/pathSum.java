package leetcode;

import jianzhi.TreeNode;

public class pathSum {

    private static int total = 0;
    public static int solution(TreeNode root,int sum){
        if(root==null)
            return 0;
        return helper(root,sum) + solution(root.left,sum) + solution(root.right,sum);
    }

    public static int helper(TreeNode root,int sum){
        int res = 0;
        if (root==null)
            return res;
        if(root.val==sum){
            res += 1;

        }
        res += helper(root.left,sum-root.val);
        res += helper(root.right,sum-root.val);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(-3);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(11);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(-2);
        TreeNode node8 = new TreeNode(1);
        root.left = node1;root.right = node2;
        node1.left = node3;node1.right = node4;
        node2.right = node5;
        node3.left = node6;node3.right = node7;
        node4.right = node8;
        System.out.println(solution(root,8));

    }
}
