package jianzhi;

import java.util.HashMap;

/**
 * Created by xyan on 12/21/17.
 */
public class duplicate {
    public static boolean solution(int numbers[],int length,int [] duplication){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<length;i++){
            if (map.containsKey(numbers[i])){
                if (map.get(numbers[i])==1){
                    duplication[0] = numbers[i];
                    System.out.println(duplication[0]);
                    return true;
                }
            }
            else
                map.put(numbers[i],1);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{10,11,1,0,2,5,3},7,new int[1]));
    }
}
