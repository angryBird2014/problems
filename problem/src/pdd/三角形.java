package pdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 三角形 {
    static  int count = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] points = new int[n][2];
        for (int i=0;i<n;i++){
            points[i][0] = in.nextInt();
            points[i][1] = in.nextInt();
        }
        ArrayList<int[]> arrayList =  new ArrayList<>();

        dfs(points,arrayList,0,3);
        System.out.println(count);
    }
    public static void dfs(int[][] points,ArrayList<int[]> arrayList,int index,int size){
        if (size==0 ){
            if (traingel(arrayList)){
                count ++;
            }
            return;
        }
        for (int i=index;i<points.length;i++){
            arrayList.add(points[i]);
            dfs(points,arrayList,i+1,size-1);
            arrayList.remove(arrayList.size()-1);
        }
    }

    public static boolean traingel(ArrayList<int[]> arrayList){
        int[] point1 = arrayList.get(0);
        int[] point2 = arrayList.get(1);
        int[] point3 = arrayList.get(2);
        if (point1[0]==point2[0] && point1[0]==point3[0])
            return false;
        else {
            if ((point1[1]-point2[1])*(point1[0]-point3[0]) == (point1[1]-point3[1]) * (point1[0]-point2[0]))
                return false;
        }
        return true;
    }

}
