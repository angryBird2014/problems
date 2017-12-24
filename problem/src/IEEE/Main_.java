package IEEE;// Don't place your source in a package
import org.omg.CORBA.MARSHAL;

import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class IEEE.Main_
class Main_ {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int[][] array = new int[3][3];
            int[] rows = new int[9];
            int[] columns = new int[9];
            int count = 0;
            for(int i=0;i<9;i++){
                int m,n;
                m = in.nextInt();
                n = in.nextInt();
                array[m-1][n-1] = count++;
                rows[i] = m;
                columns[i] = n;
            }

            //按照优先级遍历，如果共线，则判断优先级
            for (int i=2;i<9;i++){
                int row_i = rows[i];
                int col_i = columns[i];
                int[][] position = new int[3][3]; // 保存优先级2个
                position[0][0] = row_i;
                position[0][1] = col_i;
                int sum = 27 ;
                if (row_i == 1 && col_i == 1){
                    sum = Math.min(sum,array[0][0]+array[0][1]+array[0][2]); //行
                    position[1][0] = 0;position[1][1] = 1;position[2][1] = 0;position[2][2] = 2;
                    if (sum<array[0][0]+array[1][0]+array[2][0]){   //列
                        sum = array[0][0]+array[1][0]+array[2][0];
                        position[1][0] = 1;position[1][1] = 0;position[2][1] = 1;position[2][2] = 0;
                    }
                    if (sum<array[0][0]+array[1][1] +array[2][2]){  //斜对角
                        sum = array[0][0]+array[1][0]+array[2][0];
                        position[1][0] = 1;position[1][1] = 1;position[2][1] = 2;position[2][2] = 2;
                    }

                }
                if (row_i == 1 && col_i == 2){
                    if (sum<array[0][1]+array[1][1] +array[1][1]){  //列
                        sum = array[0][1]+array[1][1] +array[1][2];
                        position[0][0] =0;position[0][1] = 1;position[1][0] = 1;position[1][1] = 1;position[2][1] = 2;position[2][2] = 1;
                    }
                }
                if (row_i == 1 && col_i == 3){
                    if (sum<array[0][2]+array[1][2] +array[1][2]){  //列
                        sum = array[0][2]+array[1][2] +array[1][2];
                        position[0][0] =0;position[0][1] = 2;position[1][0] = 1;position[1][1] = 2;position[2][1] = 2;position[2][2] = 2;
                    }
                    if (sum<array[0][2]+array[1][1] +array[2][0]){
                        sum = array[0][2]+array[1][1] +array[2][0];
                        position[0][0] =0;position[0][1] = 2;position[1][0] = 1;position[1][1] = 2;position[2][1] = 2;position[2][2] = 0;
                    }

                }
                if (row_i == 2 && col_i == 1){
                    if (sum<array[1][0]+array[1][1] +array[1][2]){
                        sum = array[1][0]+array[1][1] +array[1][2];
                        position[0][0] =1;position[0][1] = 0;position[1][0] = 1;position[1][1] = 1;position[2][1] = 1;position[2][2] = 2;
                    }
                }

            }



        }



    }
}