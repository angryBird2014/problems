package jianzhi;

/**
 * Created by xyan on 10/7/17.
 */
public class JumpFloor {
    public static int solution(int n){
        if (n==1)
            return 1;
        if(n==2)
            return 2;
        return solution(n-1)+solution(n-2);
    }

    public static void main(String[] args) {
        System.out.println(solution(4));
    }
}
