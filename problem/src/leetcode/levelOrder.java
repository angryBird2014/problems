package leetcode;

import jianzhi.TreeNode;

import java.util.*;

/**
 * Created by xyan on 2/7/18.
 */
public class levelOrder {

    public List<List<Integer>> solution(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        if (root==null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int current = 1;
        int next = 0;
        while (!queue.isEmpty()){
            TreeNode node  = queue.poll();
            current--;
            tmp.add(node.val);
            if (node.left!=null){
                next++;
                queue.offer(node.left);
            }
            if (node.right!=null){
                next++;
                queue.offer(node.right);
            }
            if (current==0){
                result.add(new LinkedList<Integer>(tmp));
                tmp.clear();
                //tmp = new ArrayList<>();
                current = next;
                next = 0;
            }
        }
        return result;
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
        levelOrder s = new levelOrder();
        List<List<Integer>> result = s.solution(root);
        Iterator it = result.iterator();
        while (it.hasNext()){
            List<Integer> tmp =(List<Integer>) it.next();
            Iterator iterator = tmp.iterator();
            while (iterator.hasNext()){
                System.out.print(iterator.next()+"\t");
            }
            System.out.println();
        }

    }
}
