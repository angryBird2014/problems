package jianzhi;


import java.util.Arrays;

/**
 * Created by xyan on 12/20/17.
 */
public class isContinuous {
    public static boolean solution(int[] numbers){
        if (numbers.length==0)
            return false;
        Arrays.sort(numbers);
        int i=0;
        while (numbers[i]==0){
            i++;
        }
        int sum = 0;
        for(int j=i;j<numbers.length;j++){
            if (sum>i)
                return false;
            if (j+1<numbers.length){
                if (numbers[j+1]==numbers[j])
                    return false;
                sum += numbers[j+1]-numbers[j]-1;
            }
        }
        System.out.println("trye");
        return true;

    }

    public static void main(String[] args) {
        solution(new int[]{});
    }
}
