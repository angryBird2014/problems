package jianzhi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * Created by xyan on 10/22/17.
 */
public class FindPath {
    public ArrayList<ArrayList<Integer>> solution(TreeNode node ,int target){
        Stack<Integer> stack = new Stack<>();
        ArrayList<ArrayList<Integer>> array = new ArrayList<>();
        if (node==null)
            return array;
        int sum = 0;
        return FindPathSum(node,stack,array,target,sum);
    }
    public ArrayList<ArrayList<Integer>> FindPathSum(TreeNode node,Stack<Integer> stack,ArrayList<ArrayList<Integer>> array,int target,int sum){

        sum += node.val;
        stack.push(node.val);
        if (sum==target && node.left==null && node.right==null){
            ArrayList<Integer> tmp = new ArrayList<>();
            Iterator<Integer> it = stack.iterator();
            while (it.hasNext()){
                tmp.add(it.next());
            }
            array.add(tmp);

        }
        if (node.left!=null)
            FindPathSum(node.left,stack,array,target,sum);
        if (node.right!=null)
            FindPathSum(node.right,stack,array,target,sum);
        //返回父节点
        sum -= node.val;
        stack.pop();
        return array;
    }
}
