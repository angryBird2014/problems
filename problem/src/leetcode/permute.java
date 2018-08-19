package leetcode;

import jianzhi.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xyan on 1/6/18.
 */
public class permute {

    public List<List<Integer>> solution2(int[] nums){
        List<List<Integer>> array = new ArrayList<>();
        List<Integer> tmp  = new ArrayList<>();
        helper(nums,array,tmp);
        return array;
    }
    public void helper(int[] nums,List<List<Integer>> arraylist,List<Integer> tmp){
        if (tmp.size()==nums.length){
            arraylist.add(new ArrayList<>(tmp));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (tmp.contains(nums[i]))  continue;
            tmp.add(nums[i]);
            helper(nums,arraylist,tmp);
            tmp.remove(tmp.size()-1);
        }
    }

    public List<List<Integer>> solution(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmplist = new ArrayList<>();
        findSolution(list,tmplist,nums,0);
        return list;
    }
    public void findSolution(List<List<Integer>> list,List<Integer> tmpList,int[] nums,int index){
        if (index == nums.length){
            list.add(new ArrayList<Integer>(tmpList));
            return;
        }
        for (int i=index;i<nums.length;i++){
            if (i>index && nums[i]==nums[i-1]) continue;
            tmpList.add(nums[i]);
            int tmp = nums[index];
            nums[index] = nums[i];
            nums[i] = tmp;
            findSolution(list,tmpList,nums,index+1);//有时候是index,有时候是i，有时候是i+1!!!
            tmp = nums[index];
            nums[index] = nums[i];
            nums[i] = tmp;
            tmpList.remove(tmpList.size()-1);
        }
    }

    public static void main(String[] args) {
        permute s = new permute();
        List<List<Integer>> list = s.solution2(new int[]{1,2,3});
        for (List<Integer> nums:list){
            System.out.println(nums);
        }

    }
}
