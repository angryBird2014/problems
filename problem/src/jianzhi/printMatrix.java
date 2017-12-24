package jianzhi;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by xyan on 10/21/17.
 */
public class printMatrix {
    public ArrayList<Integer> solution(int[][] matrix){
        ArrayList<Integer> array = new ArrayList<>();
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] visited = new int[row][column];
        for (int i=0;i<row;i++)
            for (int j=0;j<column;j++)
                visited[i][j] = 0;
        //定义左上和右下元素
        int left = 0,top = 0, right = column-1,bottom = row-1;
        while (left<=right && top <= bottom){
            //从左到右
            for (int i = left;i<=right && visited[top][i]==0;i++){
                array.add(matrix[top][i]);
                visited[top][i] = 1;
            }
            //
            for (int i=top+1;i<=bottom && visited[i][right]==0;i++){
                array.add(matrix[i][right]);
                visited[i][right] =1;
            }
            //从右到左
            for (int i=right-1;i>=left && visited[bottom][i]==0;i--){
                array.add(matrix[bottom][i]);
                visited[bottom][i] =1;
            }
            for (int i=bottom-1;i>=top && visited[i][left]==0;i--){
                array.add(matrix[i][left]);
                visited[i][left] = 1;
            }
            left++;top++;bottom--;right--;
        }
        return array;
    }

    public static void main(String[] args) {
        printMatrix p = new printMatrix();
        int[][] matrix = new int[4][4];
        int count = 1;
        for (int i=0;i<4;i++)
            for (int j=0;j<4;j++)
                matrix[i][j] = count++;
        ArrayList<Integer> array = p.solution(matrix);
        Iterator<Integer> IT = array.iterator();
        while (IT.hasNext()){
            System.out.print(IT.next()+" ");
        }

    }


}
