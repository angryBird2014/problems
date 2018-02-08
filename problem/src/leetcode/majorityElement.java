package leetcode;

/**
 * Created by xyan on 1/8/18.
 */
public class majorityElement {
    public  int solution(int[] nums){

        int time = 1;
        int tmp = nums[0];
        for (int i=1;i<nums.length;i++){
            if (time==0){
                tmp = nums[i];
                time++;
            }
            else{
                if (nums[i]==tmp){
                    time++;
                }
                else {
                    time--;
                }
            }
        }
        return tmp;
    }

    public static void main(String[] args) {
        majorityElement s =  new majorityElement();
        System.out.println(s.solution(new int[]{1,1,2,2,3,3,3}));
    }
}
