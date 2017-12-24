package jianzhi;

/**
 * Created by xyan on 10/19/17.
 */
public class Mirror {
    public void solution(TreeNode root){
        if (root==null || (root.left==null && root.right==null))
            return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        if (root.left!=null)
            solution(root.left);
        if (root.right!=null)
            solution(root.right);
    }
}
