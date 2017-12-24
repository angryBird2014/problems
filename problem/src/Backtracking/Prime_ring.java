package Backtracking;

/**
 * Created by xyan on 10/13/17.
 */
public class Prime_ring {

    public boolean prime(int n){
        boolean flag = false;
        for (int i=2;i<=Math.sqrt(n);i++){
            if (n%i==0){
                flag = true;
                break;
            }
        }
        if (flag)
            return false;
        return true;
    }

    public boolean visit(int[] visited){
        boolean flag = false;
        for (int i=0;i<visited.length-1;i++)
            if (visited[i]==1){
                flag = true;
                break;
            }
        if (flag)
            return true;
        return false;
    }

    public void solution(int n,int[] array,int[] visited,int cur){
        if (cur==n && prime(array[n]+array[1])){
            for (int i=1;i<=n;i++)
                System.out.print(array[i]);
            System.out.println();
        }
        else {
            for (int i=2;i<=n;i++){
                if (visited[i]==0 && prime(array[cur-1]+i)){
                    visited[i]=1;
                    array[cur] = i;
                    solution(n,array,visited,cur+1);
                    visited[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Prime_ring pri = new Prime_ring();
        int n = 6;
        int[] array = new int[n+1];
        array[1] = 1;
        int[] visited = {0,1,0,0,0,0,0};
        pri.solution(n,array,visited,2);
    }
}
