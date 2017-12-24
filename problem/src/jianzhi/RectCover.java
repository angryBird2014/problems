package jianzhi;

/**
 * Created by xyan on 10/7/17.
 */
public class RectCover {
    public static int solution(int target){
        if (target == 0)
            return 0;
        if(target==1)
            return 1;
        if(target == 2)
            return 2;
        return solution(target-1) + solution(target-2);
    }

    public static void main(String[] args) {
        System.out.println(solution(3));
    }
}
