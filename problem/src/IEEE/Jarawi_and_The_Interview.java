package IEEE;

import java.util.Scanner;

/**
 * Created by xyan on 10/15/17.
 */
public class Jarawi_and_The_Interview {
    //P是T的子序列
    public static int getSubsequence(char P[], char T[],int start)
    {
        int j = 0;
        int i;
        int m = P.length;
        int n = T.length;
        for (i = start; i < m; i++)
        {
            //让P序列中的每一个字符和T序列中的字符进行比较
            while (P[i] != T[j])
            {
                j++;
                if (j == n)
                {
                    return 0;
                }
            }
            j++;
            if (j == n)
            {
                if (i==m-1)
                    return 1;
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.next();
        int q = in.nextInt();
        for (int i =0;i<q;i++){
            char[] query = in.next().toCharArray();
            int j = 0;
            for (;j<query.length;j++){
                Boolean flag = false;

                if (getSubsequence(query,s.toCharArray(),j)==1){
                    flag = true;
                }
                if (flag){
                    System.out.println(query.length-1-j+1);
                    break;
                }
            }
            if (j==query.length)
                System.out.println(0);
        }
    }
}
