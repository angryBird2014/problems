package IEEE;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by xyan on 10/15/17.
 */
class Node{
    int x;
    int y;

}

public class pix {

    static int cases;
    static int w,h;
    static int map[][] = new int[1005][1005];
    //static char ch;
    static int vis[][][] = new int[1005][1005][3];

    public static void bfs(int x, int y, int type) {
        Node s = new Node();
        Node p = new Node();
        Node q  = new Node();
        s.x = x;
        s.y =y;
        Queue<Node> que =new LinkedList<>();
        que.offer(s);
        while (!que.isEmpty()){
            q = que.poll();
            switch(type) {
                case 0: {
                    if(q.y > 0 && map[q.x][q.y - 1]==1 && (vis[q.x][q.y - 1][0])==0) {	// left
                        p.x = q.x;
                        p.y = q.y - 1;
                        que.offer(p);
                        vis[p.x][p.y][0] = 1;
                    }
                    if(q.y < w - 1 && map[q.x][q.y + 1]==1 && vis[q.x][q.y + 1][0]==0) {	// right
                        p.x = q.x;
                        p.y = q.y + 1;
                        que.offer(p);
                        vis[p.x][p.y][0] = 1;
                    }
                    if(q.x > 0 && map[q.x - 1][q.y]==1 && vis[q.x - 1][q.y][0]==0) {	// up
                        p.x = q.x - 1;
                        p.y = q.y;
                        que.offer(p);
                        vis[p.x][p.y][0] = 1;
                    }
                    if(q.x < w - 1 && map[q.x + 1][q.y]==1 && vis[q.x + 1][q.y][0]==0) {	// down
                        p.x = q.x + 1;
                        p.y = q.y;
                        que.offer(p);
                        vis[p.x][p.y][0] = 1;
                    }

                    break;
                }
                case 1: {
                    if(q.y > 0 && q.x > 0 && map[q.x - 1][q.y - 1]==1 && vis[q.x - 1][q.y - 1][1]==0) {	// left-top
                        p.x = q.x - 1;
                        p.y = q.y - 1;
                        que.offer(p);
                        vis[p.x][p.y][1] = 1;
                    }
                    if(q.y < w - 1 && q.x > 0 && map[q.x - 1][q.y + 1]==1 && vis[q.x - 1][q.y + 1][1]==0) {	// right-top
                        p.x = q.x - 1;
                        p.y = q.y + 1;
                        que.offer(p);
                        vis[p.x][p.y][1] = 1;
                    }
                    if(q.y > 0 && q.x < w - 1 && map[q.x + 1][q.y - 1]==1 && vis[q.x + 1][q.y - 1][1]==0) {	// left-down
                        p.x = q.x + 1;
                        p.y = q.y - 1;
                        que.offer(p);
                        vis[p.x][p.y][1] = 1;
                    }
                    if(q.y < w - 1 && q.x < w - 1 && map[q.x + 1][q.y + 1]==1 && vis[q.x + 1][q.y + 1][1]==0) {	// right-down
                        p.x = q.x + 1;
                        p.y = q.y + 1;
                        que.offer(p);
                        vis[p.x][p.y][1] = 1;
                    }

                    break;
                }
                case 2: {
                    if(q.y > 0 && map[q.x][q.y - 1]==1 && vis[q.x][q.y - 1][2]==0) {	// left
                        p.x = q.x;
                        p.y = q.y - 1;
                        que.offer(p);
                        vis[p.x][p.y][2] = 1;
                    }
                    if(q.y < w - 1 && map[q.x][q.y + 1]==1 && vis[q.x][q.y + 1][2]==0) {	// right
                        p.x = q.x;
                        p.y = q.y + 1;
                        que.offer(p);
                        vis[p.x][p.y][2] = 1;
                    }
                    if(q.x > 0 && map[q.x - 1][q.y]==1 && vis[q.x - 1][q.y][2]==0) {	// up
                        p.x = q.x - 1;
                        p.y = q.y;
                        que.offer(p);
                        vis[p.x][p.y][2] = 1;
                    }
                    if(q.x < w - 1 && map[q.x + 1][q.y]==1 && vis[q.x + 1][q.y][2]==0) {	// down
                        p.x = q.x + 1;
                        p.y = q.y;
                        que.offer(p);
                        vis[p.x][p.y][2] = 1;
                    }

                    if(q.y > 0 && q.x > 0 && map[q.x - 1][q.y - 1]==1 && vis[q.x - 1][q.y - 1][2]==0) {	// left-top
                        p.x = q.x - 1;
                        p.y = q.y - 1;
                        que.offer(p);
                        vis[p.x][p.y][2] = 1;
                    }
                    if(q.y < w - 1 && q.x > 0 && map[q.x - 1][q.y + 1]==1 && vis[q.x - 1][q.y + 1][2]==0) {	// right-top
                        p.x = q.x - 1;
                        p.y = q.y + 1;
                        que.offer(p);
                        vis[p.x][p.y][2] = 1;
                    }
                    if(q.y > 0 && q.x < w - 1 && map[q.x + 1][q.y - 1]==1 && vis[q.x + 1][q.y - 1][2]==0) {	// left-down
                        p.x = q.x + 1;
                        p.y = q.y - 1;
                        que.offer(p);
                        vis[p.x][p.y][2] = 1;
                    }
                    if(q.y < w - 1 && q.x < w - 1 && map[q.x + 1][q.y + 1]==1 && vis[q.x + 1][q.y + 1][2]==0) {	// right-down
                        p.x = q.x + 1;
                        p.y = q.y + 1;
                        que.offer(p);
                        vis[p.x][p.y][2] = 1;
                    }

                    break;
                }
            }

        }


    }

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        cases = in.nextInt();
        for(int it = 1;it<=cases;it++){
            w =in.nextInt();
            h = in.nextInt();
            //String useless = in.next();
            for (int i=0;i<h;i++){
                String tmp = in.next();
                for (int j =0;j<w;j++){
                    map[i][j] = tmp.charAt(j)-'0';
                }
            }

            int[] res = {0,0,0};
            for (int i=0;i<h;i++) {
                for (int j=0;j<w;j++){
                    for (int k=0;k<3;k++)
                        vis[i][j][k] = 0;
                }
            }
            for(int i = 0; i < h; ++ i)
            {
                for(int j = 0; j < w; ++ j)
                {
                    if(map[i][j]==1) {
                        if(vis[i][j][0]==0) {
                            bfs(i, j, 0);
                            res[0] ++;
                        }
                        if(vis[i][j][1]==0) {
                            bfs(i, j, 1);
                            res[1] ++;
                        }
                        if(vis[i][j][2]==0) {
                            bfs(i, j, 2);
                            res[2] ++;
                        }
                    }
                }
            }

            System.out.println(res[0]+" "+res[1]+" "+res[2]);

        }

    }
}
