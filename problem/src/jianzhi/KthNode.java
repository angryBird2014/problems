package jianzhi;

/**
 * Created by xyan on 2/1/18.
 */
public class KthNode {
    int index = 0;
    public TreeNode solution(TreeNode pRoot,int k) {
        if (pRoot!=null){
            TreeNode node = solution(pRoot.left,k);
            if (node!=null)
                return node;
            index++;
            if (index==k)
                return pRoot;
            node = solution(pRoot.right,k);
            if (node!=null)
                return node;
        }
        return null;
    }

}
