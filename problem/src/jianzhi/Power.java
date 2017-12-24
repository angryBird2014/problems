package jianzhi;

/**
 * Created by xyan on 10/8/17.
 */
//快速幂
public class Power {
    public static double solution(double base,int exponent){

        double sum = 1;

        if (exponent==0)
            return 1;
        else if (exponent>0){
            while(exponent!=0){
                if((exponent & 1)==1 ){  //exponent二进制表示中某一位不为０
                    sum *= base;
                }
                base = base * base;
                exponent = exponent >> 1;
            }
        }
        else {
            exponent = -exponent;
            while(exponent!=0){
                if((exponent & 1)==1 ){  //exponent二进制表示中某一位不为０
                    sum *= base;
                }
                base = base * base;
                exponent = exponent >> 1;
            }
            sum = 1.0/sum;
        }

        return sum;
    }

    public static double solution2(double base,int exponent){
        double sum = 1;
        if (exponent > 0 ){
            if (exponent == 0 )
                return 1;
            sum = solution2(base,exponent/2);
            sum = sum * sum;
            if (exponent%2==1)
                sum = sum * base;
        }
        else if (exponent < 0){
            exponent = -exponent;
            if (exponent == 0 )
                return 1;

            sum = solution2(base,exponent/2);
            sum = sum * sum;
            if (exponent%2==1)
                sum = sum * base;
            sum = 1.0/sum;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(solution2(2.0,0));
    }
}
