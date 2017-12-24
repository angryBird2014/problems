package jianzhi;

/**
 * Created by xyan on 12/18/17.
 */
public class TreeDepth {
    public static int solution(TreeNode root){
        int left_depth =0,right_depth = 0;
        if(root==null)
            return 0;
        if (root.left!=null)
            left_depth =solution_depth(root.left);
        if (root.right!=null)
            right_depth = solution_depth(root.right);
        return Math.max(left_depth+1,right_depth+1);
    }

    public static int solution_depth(TreeNode root){
        if(root==null)
            return 0;
        return Math.max(solution_depth(root.left)+1,solution_depth(root.right)+1);
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
        node3.right = node4;
        node3.left = node5;
        node2.left = node6;
        node2.right = node7;
        System.out.println(solution(root));
    }
}
