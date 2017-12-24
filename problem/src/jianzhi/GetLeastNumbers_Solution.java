package jianzhi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Created by xyan on 11/10/17.
 */
public class GetLeastNumbers_Solution {
    public ArrayList<Integer> solution(int[] input,int k){

        ArrayList<Integer> arrayList = new ArrayList<>();
        if(k<=0 ||input==null|| input.length<k){
            return arrayList;
        }
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i=0;i<input.length;i++){
            if (maxheap.size() < k){
                maxheap.add(input[i]);
            }
            else {
                int maxvalue = maxheap.peek();
                if (maxvalue>input[i]){
                    maxheap.poll();
                    maxheap.offer(input[i]);
                }

            }
        }
        Iterator<Integer> it = maxheap.iterator();
        while (it.hasNext()){
            int tmp = it.next();
            System.out.println(tmp);
            arrayList.add(tmp);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        GetLeastNumbers_Solution s = new GetLeastNumbers_Solution();
        int[] array = {4,5,1,6,2,7,3,8};
        int k = 4 ;
        s.solution(array,4);
    }
}
