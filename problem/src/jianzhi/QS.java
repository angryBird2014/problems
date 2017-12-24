package jianzhi;

import java.util.Random;

public class QS {

    public static int part(int[] array,int start,int end){

        /*//将开头当做privo
        int i=start,j=end;
        int privo = array[start];
        while (i<j){
            while(i<j && array[j]>=privo)
                --j;
            array[i] = array[j];
            while (i<j && array[i] <= privo)
                ++i;
            array[j] = array[i];

        }
        array[i] = privo;
        return i;
        */
        //将结尾当做privo
        int privo = array[end];

        int small = start -1;   //small指向privo应该在的位置的前一个,下标小于small都比privo小，大于small的都比privo大
        for(int index=start;index<end;index++){
            if(array[index]<privo){
                small ++;
                if(small != index){
                    int tempj = array[small];
                    array[small] = array[index];
                    array[index] = tempj;
                }
            }
        }
        small ++;
        //array[small] = privo;
        int temp = array[end];
        array[end] = array[small];
        array[small] = temp;
        return small;

    }

    public static void qsort(int[] arr,int low,int high){
        if(low<high){
            int privo = part(arr,low,high);
            qsort(arr,low,privo-1);
            qsort(arr,privo+1,high);
        }


    }






    public static void main(String[] args) {
        int[] arr = {3,4,5,6,1,1,4,45};
        qsort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]);
    }


}
