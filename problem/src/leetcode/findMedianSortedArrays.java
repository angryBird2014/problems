package leetcode;

public class findMedianSortedArrays {
    public double solution(int[] nums1,int[] nums2){
        int n = nums1.length;
        int m = nums2.length;
        int left = (n+m+1)/2;
        int right = (n+m+2)/2;
        return (getMedianNumber(nums1,0,nums1.length-1,nums2,0,nums2.length-1,left)+getMedianNumber(nums1,0,nums1.length-1,nums2,0,nums2.length-1,right))/2;
    }
    public double getMedianNumber(int[] numbers1,int start1,int end1,int[] numbers2,int start2,int end2,int k){
        int len1 = end1-start1+1;
        int len2 = end2-start2+1;
        //保证len1长度小于len2
        if (len1 > len2) return getMedianNumber(numbers2,start2,end2,numbers1,start1,end1,k);
        if (len1==0) return numbers2[start2+k-1]; //number1为空
        if (k==1) return Math.min(numbers1[start1],numbers2[start2]);
        int i = start1 + Math.min(len1,k/2)-1;
        int j = start2 + Math.min(len2,k/2)-1;
        if (numbers1[i]>numbers2[j])
            return getMedianNumber(numbers1,start1,end1,numbers2,j+1,end2,k-(j-start2+1));
        else
            return getMedianNumber(numbers1,i+1,end1,numbers2,start2,end2,k-(i-start1+1));

    }

    public static void main(String[] args) {
        System.out.println(new findMedianSortedArrays().solution(new int[]{1,2},new int[]{3,4}));
    }

}
