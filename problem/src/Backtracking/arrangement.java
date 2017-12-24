package Backtracking;

/**
 * Created by xyan on 10/13/17.
 */
public class arrangement {
    public void solution(int n,int[] a,int cur){ //cur是正要排列的数，a[0...cur-1]是已经排好的数
        if (cur==n){
            for (int i=0;i<n;i++)
                System.out.print(a[i]);
            System.out.println();
        }
        else {
            for (int i=1;i<=n;i++) { //待选择的数
                //cur = i ;
                boolean flag = false;
                for (int j=0;j<cur;j++){
                    if (a[j]==i){
                        flag = true;
                        break;
                    }
                }
                if (flag==false){
                    a[cur] = i;
                    solution(n,a,cur+1);
                }

            }
        }
    }

    public static void main(String[] args) {
        arrangement a = new arrangement();
        int[] array = new int[10];
        a.solution(3,array,0);
    }
}
