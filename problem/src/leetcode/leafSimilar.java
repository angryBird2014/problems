package leetcode;

import jianzhi.TreeNode;

import java.util.ArrayList;

public class leafSimilar {
    public boolean solution(TreeNode root1,TreeNode root2){
        if (root1==null && root2 == null)
            return true;
        if (root1!=null && root2==null)
            return false;
        if (root1==null && root2 !=null)
            return false;
        ArrayList<TreeNode> arrayList1 = new ArrayList<>();
        ArrayList<TreeNode> arrayList2 = new ArrayList<>();
        dfs(root1,arrayList1);
        dfs(root2,arrayList2);
        if (arrayList1.size()!=arrayList2.size())
            return false;
        for (int i=0;i<arrayList1.size();i++)
            if (arrayList1.get(i).val != arrayList2.get(i).val)
                return false;
        return true;
    }
    public void dfs(TreeNode node,ArrayList<TreeNode> arrayList){
        if (node==null)
            return;
        if (node.left == null && node.right==null){
            arrayList.add(node);
            return;
        }
        dfs(node.left,arrayList);
        dfs(node.right,arrayList);
        //System.out.println(arrayList);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(4);
        root.left = node1;root.right = node2;
        node1.left = node3;node1.right = node4;
        node2.left = node5;node2.right = node6;
        node4.left = node7;node4.right = node8;
        System.out.println(new leafSimilar().solution(root,node1));
    }
}
