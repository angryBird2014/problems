package leetcode;

/**
 * Created by xyan on 1/9/18.
 */
//没有AC
public class findKthLargest {
    public int solution(int[] nums,int k){
        int result = findSolution(nums,nums.length-k,0,nums.length-1);
        return result;
    }
    public int findSolution(int[] nums,int k,int low,int high){

        if (low==high)
            return nums[low];
        int pos = partition(nums,low,high);
        int index = pos + low - 1;
        if(index==k){
            return nums[index];
        }
        else if (index > k){
            return findSolution(nums,k,low,pos-1);
        }
        else
           return findSolution(nums,k-index,pos+1,high);
    }

    public int partition(int[] nums,int low ,int high){
        int pivot = nums[low];

        while (low<high){
            while (low<high && nums[high]>=pivot) --high;
            nums[low] = nums[high];
            while (low<high && nums[low]<=pivot) ++low;
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        return low;
    }

    public static void main(String[] args) {
        findKthLargest s = new findKthLargest();
        System.out.println(s.solution(new int[]{2,1},1));
    }
}
