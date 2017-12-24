package jianzhi;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by xyan on 11/6/17.
 */
public class MoreThanHalfNum_Solution {
    public int solution(int[] array){
        if (array.length==1)
            return array[0];
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i=0;i<array.length;i++){
            if(hashMap.containsKey(array[i])){
                hashMap.put(array[i],hashMap.get(array[i])+1);
            }
            else
                hashMap.put(array[i],1);
        }
        Set<Integer> keyset = hashMap.keySet();
        for(Integer key : keyset){
            if (hashMap.get(key)>array.length/2)
                return key;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,2,4,2,5,2,3};
        MoreThanHalfNum_Solution m = new MoreThanHalfNum_Solution();
        System.out.println(m.solution(array));
    }
}
