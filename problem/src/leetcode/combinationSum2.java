package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class combinationSum2 {
    public List<List<Integer>> solution(int[] candidates,int target){
        List<List<Integer>> arraylist = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        if (candidates==null||candidates.length==0)
            return arraylist;
        Arrays.sort(candidates);
        helper(arraylist,tmp,candidates,0,target,0);
        //return new ArrayList<>(new HashSet<>(arraylist));
        return arraylist;
    }
    public void helper(List<List<Integer>> arraylist,List<Integer> tmp,int[] candidates,int index,int target,int cur){
        if (target==cur){
            arraylist.add(new ArrayList<>(tmp));
            return;
        }
        for (int i=index;i<candidates.length;i++){
            if (i> index && candidates[i]==candidates[i-1]) continue;
            //helper(arraylist,tmp,candidates,i+1,target,cur);
            if (candidates[i]+cur<= target){
                tmp.add(candidates[i]);
                helper(arraylist,tmp,candidates,i+1,target,cur+candidates[i]);
                tmp.remove(tmp.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> array = new combinationSum2().solution(new int[]{10,1,2,7,6,1,5},8);
        for (int i=0;i<array.size();i++)
            System.out.println(array.get(i));
    }
}
