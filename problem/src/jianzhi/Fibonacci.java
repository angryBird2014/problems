package jianzhi;

/**
 * Created by xyan on 10/7/17.
 */
public class Fibonacci {
    public static int solution(int n){
        if(n<=0)
            return 0;
        else if(n==1 || n==2)
            return 1;
        else {
            int a1 = 1;
            int a2 = 1;
            int a3 = 1;
            for (int i = 3;i<=n;i++){
                a3 = a1 + a2;
                a1 = a2;
                a2 = a3;
            }

            return a3;
        }

    }

    public static void main(String[] args) {
        System.out.println(solution(1));
    }
}
