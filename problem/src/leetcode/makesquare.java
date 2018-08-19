package leetcode;

import java.util.Arrays;

public class makesquare {
    public boolean solution(int[] nums){
        if(nums==null || nums.length<4)
            return false;
        int sum = 0;
        for (int i=0;i<nums.length;i++)
            sum += nums[i];
        if (sum %4!=0)
            return false;
        int length = sum/4;

        return dfs(nums,nums.length-1,new int[]{length,length,length,length});
    }
    public boolean dfs(int[] nums,int index,int[] target){
        if (target[0]<0 || target[1]<0 || target[2]<0 || target[3] <0) return false;
        if(index<0) return target[0]==0 && target[1]==0 && target[2] == 0 && target[3] == 0;

        for (int i=0;i<target.length;i++){
            if (nums[index] > target[i]) continue;
            target[i] -= nums[index];
            if(dfs(nums,index-1,target)) return true;
            target[i] += nums[index];
        }
        return false;


    }

    public boolean solution2(int[] nums) {
        Long sum=0l;
        for(int x:nums){
            sum=sum+x;
        }
        if(sum%4!=0||nums.length<4) return false;
        long width=(sum/4);
        Arrays.sort(nums);
        long sum1=0,sum2=0,sum3=0,sum4=0;
        //return helper(nums,nums.length-1,sum1,sum2,sum3,sum4,width);
        return helper(nums,0,sum1,sum2,sum3,sum4,width);

    }
    public boolean helper(int[] a, int i,long sum1,long sum2,long sum3,long sum4, long width){
        if(sum1>width||sum2>width||sum3>width||sum4>width) return false;
        if(i==a.length){
            if(sum1==width&&sum2==width&&sum3==width&&sum4==width) return true;
            else return false;
        }
//check a[i]  belonging to side1,side2,side3,side4
        return helper(a,i+1,sum1+a[i],sum2,sum3,sum4,width)||
                helper(a,i+1,sum1,sum2+a[i],sum3,sum4,width)||
                helper(a,i+1,sum1,sum2,sum3+a[i],sum4,width)||
                helper(a,i+1,sum1,sum2,sum3,sum4+a[i],width);
    }

    public static void main(String[] args) {
        System.out.println(new makesquare().solution2(new int[]{1,1,2,2,3}));
    }
}
