package leetcode;

import jianzhi.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

public class rob3 {
    HashMap<TreeNode,Integer> hashMap = new HashMap<>();
    public int solution(TreeNode root){
        if (root==null)
            return 0;
        int value = 0;
        if (root.left!=null)
            value += solution2(root.left.left)+solution2(root.left.right);
        if (root.right!=null)
            value += solution2(root.right.left)+solution(root.right.right);
        return Math.max(root.val+value,solution2(root.left)+solution2(root.right));
    }
    public int solution2(TreeNode root){

        if (root==null)
            return 0;
        if (hashMap.containsKey(root))
            return hashMap.get(root);
        int value = 0;
        if (root.left!=null)
            value += solution(root.left.left)+solution(root.left.right);
        if (root.right!=null)
            value += solution(root.right.left)+solution(root.right.right);
        value = Math.max(root.val+value,solution(root.left)+solution(root.right));
        hashMap.put(root,value);

        return value;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(1);

        root.left = node1;root.right = node2;
        node1.left = node3;node1.right = node4;
        node2.right = node5;
        System.out.println(new rob3().solution2(root));
    }
}
