package leetcode;

import jianzhi.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xyan on 1/6/18.
 */
public class permute {
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
        List<List<Integer>> list = new ArrayList<>();
        list = s.solution(new int[]{0,1,0,0,9});
        for (List<Integer> nums:
                list) {
            for (int num:
                    nums) {
                //System.out.println();
                System.out.print(num+" ");
            }
            System.out.println("");
        }
    }
}
