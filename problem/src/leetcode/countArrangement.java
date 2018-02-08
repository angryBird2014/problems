package leetcode;

import java.util.ArrayList;

/**
 * Created by xyan on 1/5/18.
 */
public class countArrangement {
    static int count = 0;
    public static int solution(int N){
        int pos = 1;

        int[] visited = new int[N+1];
        Arrangement(pos,N,visited);
        return count;
    }
    public static void Arrangement(int pos,int N,int[] visited){
        if(pos > N){
            count ++;
            return;
        }
        for (int i=1;i<=N;i++){
            if (visited[i]==0 && (pos%i==0 || i%pos==0)){
                visited[i] = 1;
                Arrangement(pos+1,N,visited);
                visited[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(2));
    }
}
