package jianzhi;

/**
 * Created by xyan on 10/7/17.
 */
public class JumpFloorII {
    public static int solution(int target){
        if(target == 1)
            return 1;
        if (target == 2)
            return 2;
        else {
            int[] array = new int[target+1];
            for (int i=0;i<array.length;i++)
                array[i] = 0;
            array[1] = 1;
            array[2] = 2;
            for (int i=3;i<=target;i++){
                for(int j= 1;j<i;j++){
                    array[i] += array[j] ;
                }
                array[i] += 1;
            }
            return array[target];
        }


    }

    public static void main(String[] args) {
        System.out.println(solution(3));
    }
}
