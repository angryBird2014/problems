package graph;

import java.util.Scanner;

/**
 * Created by xyan on 10/11/17.
 */
public class EightPieces {

    public void dfs(String[] a,int[][] visited,int i,int j,int n){
            if (i<0 || i>=n || j<0 || j>=n ||a[i].charAt(j)=='0' || visited[i][j]==1)
                return;
            visited[i][j] = 1;
            dfs(a,visited,i-1,j-1,n); dfs(a,visited,i-1,j,n);dfs(a,visited,i-1,j+1,n);
            dfs(a,visited,i,j-1,n);dfs(a,visited,i,j+1,n);
            dfs(a,visited,i+1,j-1,n);dfs(a,visited,i+1,j,n);dfs(a,visited,i+1,j+1,n);
    }

    public  int func() {
        int ans = 0;
        String[] a = new String[700];
        int[][] visited = new int[700][700];
        for (int i = 0;i<700;i++)
            for (int j=0;j<700;j++){
                visited[i][j]=0;
            }

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i=0;i<n;i++){
            String s = scan.next();
            a[i] = s;
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (a[i].charAt(j)!='0' && visited[i][j]==0){
                    ans++;
                    dfs(a,visited,i,j,n);
                }
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        EightPieces e = new EightPieces();
        System.out.println(e.func());
    }
}
