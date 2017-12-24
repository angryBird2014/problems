package jianzhi;

/**
 * Created by xyan on 12/18/17.
 */
public class FindNumsAppearOnce {
    public static void solution(int[] array,int[] num1,int[] num2){
        int result = 0;
        for(int i=0;i<array.length;i++)
            result ^= array[i];
        int index = getFirstOne(result);
        for(int j=0;j<array.length;j++){
            if (isOneOnIndex(array[j],index))
                num1[0] ^= array[j];
            else
                num2[0] ^= array[j];

        }
        System.out.println(num1[0]+""+num2[0]);


    }
    public static int getFirstOne(int result){
        int index = 0;
        while((result & 1)==0 && result < 32){
            result >>= 1;
            index++;
        }
        return index;

    }

    public static  boolean isOneOnIndex(int value,int index){
        return ((value >> index) & 1) == 1;
    }



    public static void main(String[] args) {
        int[] array  = {2,4,3,6,3,2,5,5};
        int[] number1 = {0};
        int[] number2 = {0};
        solution(array,number1,number2);
    }
}
