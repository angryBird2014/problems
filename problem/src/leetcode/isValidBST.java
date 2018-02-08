package leetcode;

import jianzhi.TreeNode;

import java.util.Stack;

/**
 * Created by xyan on 2/1/18.
 */
public class isValidBST {

        public boolean solution(TreeNode root){
            if (root==null) return true;
            Stack<TreeNode> stack = new Stack<>();
            TreeNode pre = null;
            while (root!=null || !stack.empty()){
                while (root!=null)
                {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (pre!=null && root.val<=pre.val)
                    return false;
                pre = root;
                root = root.right;
            }
            return true;
        }



    public static void main(String[] args) {
        isValidBST s = new isValidBST();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        root.left = node1;
        //root.right = node2;
        System.out.println(s.solution(root));

    }
}
