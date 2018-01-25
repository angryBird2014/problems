package jianzhi;

import java.util.ArrayList;
import java.util.Stack;


/**
 * Created by xyan on 12/28/17.
 */
public class Print {
    public static ArrayList<ArrayList<Integer>> solution(TreeNode pRoot){
        //奇数层用queue,偶数层是栈
        if (pRoot==null)
            return null;
        int level = 1;
        ArrayList<ArrayList<Integer>> array = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();//奇数层
        stack1.add(pRoot);
        Stack<TreeNode> stack2 = new Stack<>();//偶数层
        while (!stack1.empty()||!stack2.empty()){
            if (level%2!=0){ //奇数层
                ArrayList<Integer> tmp = new ArrayList<>();
                while (!stack1.empty()){
                    TreeNode p = stack1.pop();
                    System.out.println(p.val);
                    tmp.add(p.val);
                    if (p.left!=null)
                        stack2.add(p.left);
                    if (p.right!=null)
                        stack2.add(p.right);
                }
                array.add(tmp);
                level++;
            }
            else{//偶数层
                ArrayList<Integer> tmp = new ArrayList<>();
                while (!stack2.empty()){
                    TreeNode p = stack2.pop();
                    System.out.println(p.val);
                    tmp.add(p.val);
                    if (p.right!=null)
                        stack1.add(p.right);
                    if (p.left!=null)
                        stack1.add(p.left);
                }
                array.add(tmp);
                level++;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node3.right = node4;
        node2.right = node5;
        solution(root);
    }
}
