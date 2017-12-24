package leetcode;

/**
 * Created by xyan on 12/22/17.
 */
public class minCostClimbingStairs {
    public static int solution(int[] cost){
        //mincost[i]表示经过i所需要的最小代价
        int[] minCost = new int[cost.length];
        for (int i=0;i<cost.length;i++){
            if (i<2)
                minCost[i] = cost[i];
            else {
                minCost[i] = Math.min(minCost[i-2]+cost[i],minCost[i-1]+cost[i]);
            }
        }
        System.out.println(Math.min(minCost[cost.length-1],minCost[cost.length-2]));
        return Math.min(minCost[cost.length-1],minCost[cost.length-2]);
    }

    public static void main(String[] args) {
        solution(new int[]{10, 15, 20});
    }
}
