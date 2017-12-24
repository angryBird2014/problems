package jianzhi;

/**
 * Created by xyan on 12/16/17.
 */
public class NumberOf1Between1AndN_Solution {
    public static  int solution(int n){
        int result = 0;
        for (int i =1;i<=n;i++){
            result += numberof1(i);
        }
        //System.out.println(result);
        return result;
    }
    public static int numberof1(int number){
        int out = 0;
        while (number != 0){
            if(number%10==1){
                out +=1;
            }
            number = number / 10;
        }
        return out;
    }
    public static void main(String[] args) {
       solution(13);
    }
}
