package jianzhi;


import java.util.regex.Pattern;

/**
 * Created by xyan on 12/21/17.
 */
public class StrToInt {
    public static int solution(String str){

        char[] array = str.toCharArray();
        int start=0;
        for (;start<array.length && (array[start]<'0' || array[start]>'9');start++);
            int sum=0,count = 1;
            for(int i=array.length-1;i>=start;i--){
                if (array[i]<'0' || array[i]>'9')
                    return 0;
                int number = array[i]-'0';
                if (i==array.length-1)
                    sum += number;
                else
                    sum += count*number;
                count *= 10;
            }
            //System.out.println(sum);
            return sum;
    }

    public static void main(String[] args) {
        solution("1a33");
    }

}
