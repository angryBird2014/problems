package leetcode;

import java.util.*;

/**
 * Created by xyan on 1/5/18.
 */
public class combinationSum {
    List<List<Integer>> array = new ArrayList<>();
    public List<List<Integer>> solution(int[] candidates,int target){
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        findSolution(candidates,target,0,list,0);
        return array;
    }
    public void findSolution(int[] candidates,int target,int currentSum,List<Integer> list,int index){
        if (currentSum>target)
            return;
        else if (currentSum==target)
            array.add(new ArrayList<>(list));
        else
            for (int i=index;i<candidates.length;i++){
                currentSum += candidates[i];
                list.add(candidates[i]);
                //最后一位设置为i,还是设置为i+1,还是设置为index(0)，好好体会
                findSolution(candidates,target,currentSum,list,i);
                list.remove(list.size()-1);
                currentSum -= candidates[i];
            }
    }


    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        combinationSum s = new combinationSum();
        List<List<Integer>> list = new LinkedList<>();
        list = s.solution(new int[]{2,3,6,7},7);
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
