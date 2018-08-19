package other;


import jianzhi.TreeNode;

//对应位置两棵树都有值则相加，对应位置只有一棵树有值则取该值；
public class two_tree_add {
    public int add(TreeNode root1, TreeNode root2){
        if (root1==null && root2 == null)
            return 0;
        int s = 0;
        if (root1==null && root2!=null)
            s += root2.val + add(null,root2.left) +  add(null,root2.right);
        else if (root1 !=null && root2==null)
            s += root1.val + add(root1.left,null) + add(root1.right,null);
        else
            s += root1.val+ root2.val+add(root1.left,root2.left) + add(root1.right,root2.right);
        return s;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2  = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        //TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(8);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node6;
        node2.right = node7;
        TreeNode root2 = new TreeNode(10);
        root2.left = node1;
        System.out.println(new two_tree_add().add(root,root2));
    }
}
