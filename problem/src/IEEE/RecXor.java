package IEEE;

import java.util.Scanner;

/**
 * Created by xyan on 10/14/17.
 */
public class RecXor {

    public static int findXORofRange(int m, int n) {
        int[] patternTracker;

        if(m % 2 == 0)
            patternTracker = new int[] {n, 1, n^1, 0};
        else
            patternTracker = new int[] {m, m^n, m-1, (m-1)^n};

        return patternTracker[(n-m) % 4];
    }



    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int m=0;m<t;m++){
            int l,h,n,d1,d2;
            l = in.nextInt(); //列
            h = in.nextInt(); //行
            n = in.nextInt(); //元素起始位置
            int sum = 0;
            d1 = in.nextInt();
            d2 = in.nextInt();
            int first_row = (d1-n)/l;//第一个元素的列,d1要么在左上角，要么在右上角
            int first_col = (d1-n)%l;
            int sec_row = (d2-n)/l;
            int sec_col = (d2-n)%l;
            int col = Math.min(first_col,sec_col);
            int row = Math.min(first_row,sec_row);
            if (first_col == col && first_row == row){ //d1在左上角
                    if (d1-1>=n)
                        sum = findXORofRange(n,d1-1);
                    else
                        sum = 0;
                    int start = d1 + sec_col-first_col+1;
                    int end = d1 + l-1;
                    if ((start-n)%l >= l){
                        if (end >= d1+l||((end-n)/l<=first_row)){ //start越界 ,end越界
                            start = 0;
                            end =0;
                        }
                        else {      //start越界 ,end未越界
                            start = d1 + l-first_col;
                        }
                    }


                    for (int i=first_row;i<sec_row;i++){
                        sum ^= findXORofRange(start,end);
                        start = start + l;
                        end = end +l;
                    }
                    sum ^= findXORofRange(d2+1,n+l*h-1);



            }
            else {      //d1在右上角
                if (d1-(first_col-sec_col)-1<n)
                    sum = 0;
                else
                    sum = findXORofRange(n,d1-(first_col-sec_col)-1);
                int start = d1 +1;
                //int end = d1+(l-first_col)+1;
                int end = (l-(first_col-sec_col))+d1-1;
                if ((start-n)/l>first_row){
                    //end = d1+(l-first_col);
                    if ((end-n)%l >= sec_col) //start,end越界
                    {
                        start = 0;
                        end = 0;
                    }
                    else            //start越界
                    {
                        start = d1 +1;
                    }
                }

                for (int i = first_row;i<sec_row;i++){
                    sum ^= findXORofRange(start,end);
                    start = start +l;
                    end = end+l;
                }
                sum ^= findXORofRange(d2+first_col-sec_col+1,n+l*h-1);
            }
            System.out.println(sum);
        }



    }


}
