package jianzhi;

/**
 * Created by xyan on 10/7/17.
 */
public class NumberOf1 {
    public static int solution(int n){
        int count = 0;
        int flag = 1;
        while(flag != 0){
            if ((n & flag)!=0)
                count++;
            flag = flag << 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(-1));
    }
}
