package jianzhi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xyan on 1/29/18.
 */
public class Print_Multi {
    public ArrayList<ArrayList<Integer>> solution(TreeNode pRoot){
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot==null)
            return result;
        queue.add(pRoot);
        int current = 1;
        int next = 0;
        ArrayList<Integer> array = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            array.add(tmp.val);
            current--;
            if (tmp.left!=null){
                queue.offer(tmp.left);
                next ++ ;
            }
            if (tmp.right!=null){
                queue.offer(tmp.right);
                next ++;
            }
            if (current == 0){
                result.add(array);
                array = new ArrayList<>();
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
        node2.left = node5;
        node2.right = node6;
        node3.left = node7;
        Print_Multi s = new Print_Multi();
        ArrayList<ArrayList<Integer>> result = s.solution(root);
        Iterator iterator  = result.iterator();
        while (iterator.hasNext()){
            ArrayList<Integer> tmp = (ArrayList<Integer>) iterator.next();
            Iterator it = tmp.iterator();
            while (it.hasNext()){
                System.out.print(it.next()+" ");
            }
            System.out.println();
        }
    }
}
