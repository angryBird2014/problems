package contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int n = in.nextInt();
        int[] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = in.nextInt();
        }
       //Arrays.sort(array);
        dfs(array,100,0,result,0,output);
        result = output.get(0);
        Collections.sort(result);
        System.out.println(result.size());
        for (int i=0;i<result.size();i++)
            System.out.println(result.get(i));
    }
    public static void dfs(int[] array,int target,int index,ArrayList<Integer> arrayList,int sum,ArrayList<ArrayList<Integer>> output){
        if(sum==target){
            output.add(new ArrayList<>(arrayList));
            return;
        }
        else if (sum>target)
            return;
        else {

            for(int i = index; i < array.length; i++){
                arrayList.add(i);
                dfs(array, target,i+1, arrayList, sum+array[i],output);
                arrayList.remove(arrayList.size()-1);
            }
        }




    }

}
