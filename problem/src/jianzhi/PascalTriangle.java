package jianzhi; /**
 * Created by xyan on 9/11/17.
 */

import java.util.LinkedList;
import java.util.List;

/**
 * [
    [1],
    [1,1],
    [1,2,1],
    [1,3,3,1],
    [1,4,6,4,1]
 ]
 */
public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> arr = new LinkedList<List<Integer>>();

        for(int i = 1;i<=numRows;i++){
            int num = i;

            LinkedList<Integer> inter = new LinkedList<Integer>();
            if(num==1){
                inter.add(1);
            }
            else if(num==2){
                inter.add(1);
                inter.add(1);
            }
            else {
                inter.add(1);
                for(int j = 2;j<num;j++){       //
                    inter.add(arr.get(num-2).get(j-1)+arr.get(num-2).get(j-2));
                }
                inter.add(1);
            }

            arr.add(inter);
        }

        return arr;
    }

    public static void main(String[] args) {
        List<List<Integer>> arr = new LinkedList<List<Integer>>();
        arr = generate(5);
        for(int i=0;i<arr.size();i++){
            for (int j = 0;j<arr.get(i).size();j++)
                System.out.print(arr.get(i).get(j));

        }
    }
}
