package graph;

import org.omg.CORBA.TRANSACTION_MODE;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by xyan on 10/12/17.
 */
public class Take_maze {
    public void solution(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] maze = new int[m][n];
            int[][] visited = new int[m][n];
            for (int i=0;i<m;i++)
                for (int j =0;j<n;j++){
                    visited[i][j]=0;
                    maze[i][j]=scanner.nextInt();
                }
            int xstart = 0, ystart = 0;
            int xend = m-1,yend = n-1;
            if (maze[xstart][ystart]==1 ||maze[xend][yend]==1)
                break;
            Stack<node> stack = new Stack<>();
            node u = new node(xstart,ystart);
            stack.add(u);
            while (!stack.isEmpty()){
                node element = stack.peek();     //不弹栈
                if (element.getX()==xend && element.getY()==yend)
                    break;
                boolean flag = false;

                /*向下走*/
                if ((element.getY()+1)< m  && maze[element.getX()][element.getY()+1]!=1){
                    node down = new node(element.getX(),element.getY()+1); // 向下
                    visited[element.getX()][element.getY()+1] = 1;
                    flag = true;
                    stack.add(down);
                    continue;
                }
                /*向右走*/
                if ((element.getX()+1)< n  && maze[element.getX()+1][element.getY()]!=1){
                    node right = new node(element.getX()+1,element.getY()); // 向右
                    visited[element.getX()+1][element.getY()]=1;
                    flag  = true;
                    stack.add(right);
                    continue;
                }
                if (flag==false)//无路可走
                    stack.pop();
            }

            while (!stack.isEmpty()){
                node tmp = stack.pop();
                System.out.println("("+tmp.getX()+","+tmp.getY()+")->");
            }



        }
    }

    public static void main(String[] args) {
        Take_maze s = new Take_maze();
        s.solution();
    }
}
