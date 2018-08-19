package leetcode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permuteUnique {
    public List<List<Integer>> solution(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        if (nums==null||nums.length==0)
            return result;
        Arrays.sort(nums);
        int[] used = new int[nums.length];
        helper(nums,result,tmp,used);
        return result;
    }
    public void helper(int[] nums,List<List<Integer>> result,List<Integer> tmp,int[] used){
        if (tmp.size()==nums.length){
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (used[i]==1 || i>0 && nums[i]==nums[i-1] && used[i-1]==0) continue;
            tmp.add(nums[i]);
            used[i] = 1;
            helper(nums,result,tmp,used);
            used[i] = 0;
            tmp.remove(tmp.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new permuteUnique().solution(new int[]{1,1,2});
        for (List<Integer> num:result) {
            System.out.println(num);

        }
    }

}
