package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xyan on 1/6/18.
 */
public class subsets {
    public List<List<Integer>> solution(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        findSolution(nums,list,tmpList,0);
        return list;
    }
    public void findSolution(int[] nums,List<List<Integer>> list,List<Integer> tmpList,int index){
        list.add(new ArrayList<Integer>(tmpList));
        for(int i=index;i<nums.length;i++){
            if (i>index && nums[i]== nums[i-1]) continue;  //有重复的子集
            tmpList.add(nums[i]);
            findSolution(nums,list,tmpList,i+1);
            tmpList.remove(tmpList.size()-1);
        }
    }
    public static void main(String[] args) {
        subsets s3 = new subsets();
        List<List<Integer>> list = new ArrayList<>();
        list = s3.solution(new int[]{1,2,2});
        for (List<Integer> nums:
                list) {
            for (int num:
                    nums) {
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }

}
