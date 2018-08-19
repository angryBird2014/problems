package leetcode;
import java.util.*;

public class sum4 {
    public List<List<Integer>> solution(int[] nums,int target){
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        //List<Integer> array = new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            //if (i+1<nums.length && nums[i+1]==nums[i]) continue;
            for (int j=i+1;j<nums.length;j++){
                //if (j+1<nums.length && nums[j+1]==nums[j]) continue;
                List<Integer> array = new ArrayList<>();
                int begin = j+1;
                int end = nums.length-1;
                int target_tmp = target-nums[i]-nums[j];
                while (begin<end){
                    if (nums[begin]+nums[end]==target_tmp){
                        array.add(nums[i]);
                        array.add(nums[j]);
                        array.add(nums[begin]);
                        array.add(nums[end]);
                        result.add(array);
                        array = new ArrayList<>();
                        begin++;
                        end--;
                    }
                    else if(nums[begin]+nums[end]<target_tmp)
                        begin++;
                    else
                        end--;
                }

            }
        }
        return new ArrayList<>(result);
    }

    public List<Integer> find2sum(int[] nums,int target,int begin){
        int end = nums.length-1;
        List<Integer> list = new ArrayList<>();
        while (begin<end){
            if (nums[begin]+nums[end]==target){
                list.add(nums[begin]);
                list.add(nums[end]);
                begin++;
                end--;
            }
            else if(nums[begin]+nums[end]<target)
                begin++;
            else
                end--;
        }
        return list;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new sum4().solution(new int[]{1,0,-1,0,-2,2},0);
        for (int i=0;i<result.size();i++)
            System.out.println(result.get(i));
    }
}
