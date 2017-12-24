package IEEE; /**
 * Created by xyan on 10/14/17.
 */

import java.util.Scanner;
import java.util.Stack;

public class DP {

    public static void main (String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int[][] forest = new int[205][205];
            int[][] array = new int[205][205];
            int m = in.nextInt();
            int n = in.nextInt();
            for(int i=0;i<m;i++){
                for (int j=0;j<n;j++){
                    forest[i][j] = in.nextInt();
                }
            }
            for (int j= 1 ;j<m;j++){    //列初始化

                array[j][0] = array[j-1][0] + forest[j][0];
            }
            for (int i = 1;i<n;i++){

                array[0][i] = array[0][i-1] + forest[0][i]; //行初始化
            }
            for (int i=1;i<m;i++){
                for(int j=1;j<n;j++){
                    int count_down = array[i-1][j] +forest[i][j];
                    int count_right = array[i][j-1]+forest[i][j];
                    if (count_down< 0 && count_right < 0 ){
                        array[i][j] = -Math.min(-count_down,-count_right);
                    }
                    if (count_down>=0 && count_right >= 0)
                        array[i][j] = count_down;
                    if (count_down<0 && count_right >=0)
                        array[i][j] = count_right;
                    if (count_down>=0 && count_right >=0)
                        array[i][j] = Math.min(count_down,count_right);
                }
            }
            if (array[m-1][n-1]>0)
                System.out.println(1);
            else
                System.out.println(1-array[m-1][n-1]);

        }
    }



}
