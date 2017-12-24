package jianzhi;

import java.util.logging.Level;

/**
 * Created by xyan on 12/18/17.
 */
public class IsBalanced_Solution {
    public static boolean solution(TreeNode root){

        if(root == null)
            return true;
        int left_depth = depth(root.left);
        int right_depth = depth(root.right);
        if(Math.abs(left_depth-right_depth)<=1)
            return solution(root.left) && solution(root.right);
        else
            return false;

    }


    public static int depth(TreeNode root){
        if(root==null)
            return 0;
        return Math.max(depth(root.left)+1,depth(root.right)+1);
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
        System.out.println(solution(root));
    }
}
