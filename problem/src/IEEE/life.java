package IEEE;// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class IEEE.Main
class life {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);

            int m = in.nextInt();
            int n = in.nextInt();
            int c = in.nextInt();
            char[][] board = new char[30][30];
            char[][] tmp = new char[30][30];
            for (int i=0;i<m;i++){
                board[i] = in.next().toCharArray();
            }
            for (int i=0;i<m;i++)
                for (int j=0;j<n;j++)
                    tmp[i][j] = board[i][j];
            for (int iter = 1;iter<=c;iter++){

                for (int i=0;i<m;i++){
                    for (int j=0;j<n;j++){
                        int count = 0;
                        int left = (j-1+n)%n;
                        int right = (j+1+n)%n;
                        int up = (i-1+m)%m;
                        int down = (i+1+m)%m;
                        if (isDeatchorlive(up,left,board))   //左上
                            count++;
                        if (isDeatchorlive(up,j,board)) //正上
                            count++;
                        if (isDeatchorlive(up,right,board)) //右上
                            count++;
                        if (isDeatchorlive(i,left,board)) //左
                            count++;
                        if (isDeatchorlive(i,right,board)) //右
                            count++;
                        if (isDeatchorlive(down,left,board)) //左下
                            count++;
                        if (isDeatchorlive(down,j,board)) //下
                            count++;
                        if(isDeatchorlive(down,right,board))
                            count++;

                        if (isDeatchorlive(i,j,board)) {
                            if (count < 2) {
                                //1.存活单位周边的存活单位少于2个，该单位死亡
                                tmp[i][j] = '-';
                            } else if (count == 2 || count == 3) {
                                //2.存活单位周边的存活单位有2-3个，该单位继续存活
                                tmp[i][j] = '*';
                            } else {
                                //3.存活单位周边的存活单位多余3个，该单位死亡
                                tmp[i][j] = '-';
                            }
                        }
                        else {
                            if (count == 3) {
                                //4.死亡单位周边的存活单位恰好为3个，该单位变为存活状态
                                tmp[i][j] = '*';
                            }
                        }
                    }
                }


                for (int i=0;i<m;i++)
                    for (int j=0;j<n;j++)
                        board[i][j] = tmp[i][j];
            }

            for (int i=0;i<m;i++){
                for (int j=0;j<n;j++)
                    System.out.print(board[i][j]);
                System.out.println();
            }

        }





    public static Boolean isDeatchorlive(int i,int j,char[][] array){
        if (array[i][j]=='*')
            return true;
        return false;
    }


}