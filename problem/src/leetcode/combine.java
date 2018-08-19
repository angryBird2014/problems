package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class combine {
    public List<List<Integer>> solution(int n ,int k){
        List<List<Integer>> array = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        helper(n,k,array,tmp,1);
        return array;
    }
    public void helper(int n,int k,List<List<Integer>> array,List<Integer> tmp,int index){
        if (k==0){
            array.add(new ArrayList<>(tmp));
            return;
        }
        for (int i=index;i<=n;i++){
            tmp.add(i);
            helper(n,k-1,array,tmp,i+1);
            tmp.remove(tmp.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new combine().solution(4,2);
        for (List<Integer> num:result) {
            System.out.println(num);
        }
    }


}
