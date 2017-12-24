package IEEE;// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class IEEE.Main
class Main {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int m = in.nextInt(); //维度
            int[] dimsion = new int[m];
            for(int i=0;i<m;i++){
                dimsion[i] = in.nextInt();
            }
            int sum = 1;
            for (int i=0;i<m;i++){
                sum *= dimsion[i];
            }
            int[] number = new int[sum];
            for(int i = 0;i<number.length;i++){
                number[i] = in.nextInt();
            }
            int query = in.nextInt();

            for (int i =0;i<query;i++){
                int count = 0;
                int[] start = new int[m];
                for (int j= 0;j<start.length;j++)
                    start[j] = in.nextInt();

                int[] end = new int[m];
                for (int j =0;j<end.length;j++)
                    end[j] = in.nextInt();


                for (int dim = m-1;dim>=0;dim--){ //从最后一维开始
                    if (start[dim] <= end[dim]){
                        int index = 1;
                        for (int factor = 0;factor < dim-1;factor++){
                            index = index * dimsion[factor];
                        }
                        for (int tmp = start[dim] ;tmp<=end[dim];tmp++)
                            count += number[index+tmp-1];

                     }
                    }
                    System.out.println(count);
                }

                }





            }




}