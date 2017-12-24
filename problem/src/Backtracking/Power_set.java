package Backtracking;

/**
 * Created by xyan on 10/13/17.
 */
public class Power_set {
    public void solution(int n,int[] array,int cur,int[] flag){
        if (cur==n){
            for (int i=0;i<n;i++){
                if (flag[i]==1)
                    System.out.print(array[i]);
            }
            System.out.println();
        }
        else {
            flag[cur] = 0;
            solution(n,array,cur+1,flag);
            flag[cur]=1;
            solution(n,array,cur+1,flag);
        }
    }

    public static void main(String[] args) {
        Power_set pow = new Power_set();
        int[] array = {1,2,3};
        int[] flag = {0,0,0};
        pow.solution(3,array,0,flag);
    }
}
