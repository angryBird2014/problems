package IEEE; /**
 * Created by xyan on 10/14/17.
 */
import java.util.*;
import java.lang.*;
import java.io.*;
public class Gotta_Catch {

    public static void main (String[] args) throws java.lang.Exception {
        class node{
            int x;
            int y;
            public node(int x,int y){
                this.x = x;
                this.y = y;
            }

        }
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int[][] forest = new int[201][201];
            int[][] visited = new int[201][201];
            int m = in.nextInt();
            int n = in.nextInt();
            for(int i=0;i<m;i++){
                for (int j=0;j<n;j++){
                    forest[i][j] = in.nextInt();
                    visited[i][j] = 0;
                }
            }

            //深搜
            int xstart = 0, ystart = 0;
            int xend = m-1,yend = n-1;
            node u = new node(xstart,ystart);
            Stack<node> stack = new Stack<>();
            stack.add(u);
            int count = 0;
            while (!stack.isEmpty()){
                node element = stack.peek();
                if (element.x==xend && element.y==yend && count > 0){
                    System.out.println(count);
                    break;
                }
                boolean flag = false;

                /*向下走*/
                if ((element.y+1)< m  && visited[element.x][element.y+1]!=1 && count+forest[element.x][element.y+1]>0){
                    count += forest[element.x][element.y+1];
                    node down = new node(element.x,element.y+1); // 向下
                    visited[element.y+1][element.x] = 1;
                    flag = true;
                    stack.add(down);
                    continue;
                }
                /*向右走*/
                if ((element.x+1)< n  && visited[element.x+1][element.y]!=1 && count+forest[element.x+1][element.y]>0){
                    count += forest[element.x+1][element.y];
                    node right = new node(element.x+1,element.y); // 向右
                    visited[element.x+1][element.y]=1;
                    flag  = true;
                    stack.add(right);
                    continue;
                }
                if (flag==false || count<0)//无路可走
                    stack.pop();
            }



        }
    }



}
