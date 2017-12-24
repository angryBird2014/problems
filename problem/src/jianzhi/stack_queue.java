package jianzhi;

import java.util.Stack;

/**
 * Created by xyan on 10/6/17.
 */
public class stack_queue {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public  void push(int node) {
        stack1.add(node);
    }

    public  int pop() {
        if(stack2.empty()){
            while (!stack1.empty())
                stack2.add(stack1.pop());
        }
        return stack2.pop();
    }


}
