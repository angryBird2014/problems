package other;
//两个有序数组求中位数
public class two_array_median {





    public int median(int[] number1,int start1, int end1,int[] number2,int start2, int end2, int k){
        int m = end1 - start1;
        int n = end2 - start2;
        if (m > n)
            return median(number2,start2,end2,number1,start1,end1,k);
        if (m==0)
            return number2[start2+k-1];
        if (k==1)
            return Math.min(number1[start1],number2[start2]);
        int pos1 = Math.min(m,k/2);
        int pos2 = k - pos1;
        if (number1[start1+pos1-1] < number2[start2+pos2-1]){
            return median(number1,start1+pos1,end1,number2,start2,end2,k-pos1);
        }
        else if (number1[start1+pos1-1] > number2[start2+pos2-1])
            return median(number1,start1,end1,number2,start2+pos2,end2,k-pos2);
        else
            return number1[start1+pos1-1];
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{0,2,4,5,10,12,45,47};
        int[] array2 = new int[]{1,2,4,18,29,30,48};
        System.out.println(new two_array_median().median(array1,0,array1.length,array2,0,array2.length,13));
    }
}
