package jianzhi;

import java.util.*;

/**
 * Created by xyan on 2/7/18.
 */
public class zigzagLevelOrder {
    public List<List<Integer>> solution(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        if (root==null)
            return result;
        queue.offer(root);
        boolean lefttoright = true;

        while (!queue.isEmpty()){

            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if (lefttoright){
                    tmp.add(node.val);
                }
                else {
                    tmp.add(0,node.val);
                }
                if (node.left!=null)
                    queue.offer(node.left);
                if (node.right!=null)
                    queue.offer(node.right);
            }

            lefttoright = !lefttoright;
            result.add(new ArrayList<>(tmp));
            tmp.clear();
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
        zigzagLevelOrder s = new zigzagLevelOrder();
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
