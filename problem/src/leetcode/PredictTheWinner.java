package leetcode;

/**
 * Created by xyan on 12/26/17.
 */
//http://tianshilei.me/2017/02/08/leetcode486/
public class PredictTheWinner {
    public static boolean solution(int[] nums){

    }

    public static int[] DFS(int[] nums,int[] flag,int i,int j,int[] sum){
        /*
        while (i<nums.length && flag[i]==1)
            i++;
        while (j>=0 && flag[i]==1)
            j--;
        */
        if (i>j){ //遍历完毕
            return sum;
        }
        while (i<=j && i>=0 && j<=nums.length){
            //player1尝试选取第一个,palyer2选取接下来的一个
            flag[i] = 1;sum[0] += nums[i];i++;
            flag[i] = 1;sum[1] += nums[i];i++;
            int[] sum1 = DFS(nums,flag,i,j,sum);
            i--;sum[1] -= nums[i];flag[i]=0;i--;sum[0] -= nums[i];flag[i]=0;

            //player1尝试选取第一个,player2选取另外一端的最后一个
            flag[i] = 1;sum[0]+=nums[i];i++;
            flag[j] = 1;sum[1]+=nums[j];j--;
            int[] sum2 = DFS(nums,flag,i,j,sum);
            j++;sum[1]-=nums[j];flag[j]=0;i--;sum[0]-=nums[i];flag[i]=0;

            //player1尝试选取最后一个,player2选取接下来的一个
            flag[j]=1;sum[0]+=nums[j];j--;
            flag[j]=1;sum[1]+=nums[j];j--;
            int[] sum3 = DFS(nums,flag,i,j,sum);
            j++;sum1[1]-=nums[j];flag[j]=0;j++;sum[0]-=nums[j];flag[j]=0;

            //player尝试选取最后一个，player2选取另外一边的第一个
            flag[j]=1;sum[0]+=nums[j];j--;
            flag[i]=1;sum[1]+=nums[i];i++;
            int[] sum4 = DFS(nums,flag,i,j,sum);
            i--;sum1[1]-=nums[i];flag[i]=0;j++;sum[0]-=nums[j];flag[j]=0;

        }
    }
}
