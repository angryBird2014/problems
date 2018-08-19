package leetcode;

import jianzhi.TreeNode;

import java.util.*;

public class distanceK {


    HashMap<TreeNode,ArrayList<TreeNode>> map = new HashMap<>();
    public List<Integer> solution(TreeNode root,TreeNode target,int k){
        List<Integer> arraylist = new ArrayList<>();
        if (root==null)
            return arraylist;
        build(root,null);
        if (!map.containsKey(target)) return arraylist;
        HashSet<TreeNode> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        set.add(target);
        while (!queue.isEmpty()){
            //TreeNode node = queue.poll();
            int size = queue.size();
            if (k==0){
                for (int i=0;i<size;i++){
                    arraylist.add(queue.poll().val);
                }
                return arraylist;
            }
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                for (TreeNode tmp:map.get(node)) {
                    if (!set.contains(tmp)){
                        set.add(tmp);
                        queue.offer(tmp);
                    }
                }
            }

            k--;
        }
        return arraylist;
    }
    public void build(TreeNode root,TreeNode parent){
        if (root==null)
            return;
        if (!map.containsKey(root)){
            map.put(root,new ArrayList<>());
            if (parent!=null){
                map.get(root).add(parent);map.get(parent).add(root); //遍历到root时，parent已经先一步在map中
            }
            build(root.left,root);
            build(root.right,root);
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(4);
        root.left = node1;root.right = node2;
        node1.left = node3;node1.right = node4;
        node2.left = node5;node2.right = node6;
        node4.left = node7;node4.right = node8;
        System.out.println(new distanceK().solution(root,node1,2));
    }
}
