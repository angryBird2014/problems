package Backtracking;

/**
 * Created by xyan on 10/13/17.
 */
public class monkey {
    public void solution(int n){
        int sum = 1;
        for (int i = n-1 ;i>=1;i--){
            sum = (sum+1) * 2;
        }
        System.out.println(sum);

    }

    public static void main(String[] args) {
        monkey m =  new monkey();
        m.solution(4);
    }
}