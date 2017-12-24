package jianzhi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xyan on 10/22/17.
 */
public class PrintFromTopToBottom {
    public ArrayList<Integer> solution(TreeNode root){
        ArrayList<Integer> array = new ArrayList<>();
        if (root!=null){
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                TreeNode first = queue.poll();
                System.out.print(first.val+" ");
                array.add(first.val);
                if (first.left!=null){
                    queue.add(first.left);
                }
                if (first.right!=null){
                    queue.add(first.right);
                }

            }
        }
        return array;
    }

    public static void main(String[] args) {
        PrintFromTopToBottom p = new PrintFromTopToBottom();
        //p.solution()
    }
}
