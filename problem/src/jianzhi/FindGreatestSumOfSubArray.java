package jianzhi;

/**
 * Created by xyan on 11/14/17.
 */
public class FindGreatestSumOfSubArray {
    public int solution(int[] array){
        int currentSum = 0;
        int maxSum = -999999999;

        for(int i=0;i<array.length;i++){
            if(currentSum <= 0){
                currentSum = array[i];
            }
            else
                currentSum += array[i];
            if (currentSum > maxSum){
                maxSum = currentSum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        FindGreatestSumOfSubArray s = new FindGreatestSumOfSubArray();
        int[] array = {-2,-8,-1,-5,-9};
        int result = s.solution(array);
        System.out.println(result);
    }
}
