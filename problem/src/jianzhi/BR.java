package jianzhi;

/**
 * Created by xyan on 9/7/17.
 */
public class BR {
    public static int binarySearch(int[] array,int k){
        int low = 0;
        int high = array.length -1;
        if(low > high)
            return -1;
        while(low<=high){
            int middle = (low+high)/2;
            if (array[middle]>k)
                high = middle - 1;
            else if(array[middle] <k )
                low = middle +1 ;
            else
                return middle;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {0,1,2,3,4,5,9,10};
        int k = binarySearch(array,99);
        System.out.println(k);
    }
}
