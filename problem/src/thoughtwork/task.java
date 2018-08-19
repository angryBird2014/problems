package thoughtwork;


import java.util.ArrayList;


import java.util.Arrays;
import java.util.Scanner;

public class task {
    private int row;
    private int column;
    private int[][] directions;
    private ArrayList<ArrayList<int[]>> arrayList;
    private int direction;
    private int[] point;
    public task(){
        this.row = 0;
        this.column = 0;
        this.arrayList = new ArrayList<>();
        this.direction = -10;
        this.point = new int[2];
        this.directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    }

    public boolean validInteger(int number,int mode,int rowFlag){
        if (mode==1){
            if (number>0 && number<Integer.MAX_VALUE)
                return true;
        }
        else if (mode==2){
            if (rowFlag==1){
                if (number >=0 && number < this.row)
                    return true;
            }
            else{
                if (number >=0 && number < this.column)
                    return true;
            }
        }

        return false;

    }

    public boolean validPosition(int[] point1,int[] point2){
        //0上，1下,2左，3右
        boolean flag = false;
        for (int i=0;i<this.directions.length;i++){
            if ((point1[0]+directions[i][0] == point2[0]) &&
                    (point1[1]+directions[i][1] == point2[1])){
                flag = true;
                this.direction = i;
            }
        }
        return flag == true;
    }

    public boolean validFormat(String[] points,int mode){
        if (points.length!=2){
            System.out.println("Incorrect command format.");
            return false;
        }
        try {
            int x = Integer.valueOf(points[0]);
            int y = Integer.valueOf(points[1]);
            if (!(validInteger(x,mode,1) && validInteger(y,mode,0))){
                System.out.println("Number out of range​.");
                return false;
            }
            this.point[0] = x;
            this.point[1] = y;
        }
        catch (Exception e){
            System.out.println("Invalid number format.");
            return false;
        }
        return true;
    }

    public int check(String input,int mode){
        if(mode==1){
            String[] point = input.split(" ");
            if (validFormat(point,mode)){
                this.row = this.point[0];
                this.column = this.point[1];
            }
            else
                return -1;
        }
        else if(mode==2){
            // 0,1 0,2;0,0 1,0;0,1 1,1;0,2 1,2;1,0 1,1;1,1 1,2;1,1 2,1;1,2 2,2;2,0 2,1
            String[] lines = input.split(";");
            for (int i=0;i<lines.length;i++){
                String[] cell = lines[i].split(" ");
                if (cell.length!=2){
                    System.out.println("Incorrect command format.");
                    return -1;
                }

                int[] key = new int[2];
                int[] value = new int[2];

                String[] cellFirst = cell[0].split(",");
                if (validFormat(cellFirst,mode)){
                    key[0] = this.point[0];
                    key[1] = this.point[1];
                }
                else
                    return -1;
                String[] cellSencond = cell[1].split(",");
                if (validFormat(cellSencond,mode)){
                    value[0] = this.point[0];
                    value[1] = this.point[1];
                }
                else
                    return -1;
                if (validPosition(key,value)){
                    ArrayList<int[]> tmp = new ArrayList<>();
                    tmp.add(key);tmp.add(value);tmp.add(new int[]{direction,0});
                    this.arrayList.add(tmp);
                }
                else{
                    System.out.println("Maze format error.");
                    return -1;
                }
            }

        }
        return 0;
    }

    public void print(){

        int mazzyRow = this.row * 2 + 1;
        int mazzyColumn = this.column * 2 + 1;
        int[][] result = new int[mazzyRow][mazzyColumn];
        for (int i=0;i<result.length;i++)
            Arrays.fill(result[0],0);
        for (int i=0;i<this.arrayList.size();i++){
            int zouwei = this.arrayList.get(i).get(2)[0];
            int[] point1 = this.arrayList.get(i).get(0);
            int[] point2 = this.arrayList.get(i).get(1);
            for (int k=0;k<point1.length;k++){
                point1[k] = point1[k] * 2 +1;
                point2[k] = point2[k] * 2 +1;
            }
            switch (zouwei){
                case 0:{
                    for (int index = point2[0];index<=point1[0];index++)
                        result[index][point2[1]] = 1;
                    break;
                }
                case 1:{
                    for (int index = point1[0];index<=point2[0];index++)
                        result[index][point1[1]] = 1;
                    break;
                }
                case 2:{
                    for (int index = point2[1];index<=point1[1];index++)
                        result[point2[0]][index] = 1;
                    break;
                }
                case 3:{
                    for (int index = point1[1];index<=point2[1];index++){
                        result[point1[0]][index] = 1;
                    }
                    break;
                }
            }
        }
        String[] output = new String[result.length];
        for (int i=0;i<mazzyRow;i++){
            output[i] = "";
            for (int j=0;j<mazzyColumn;j++){
                if (result[i][j]==0)
                    output[i] += "[W]";
                else
                    output[i] += "[R]";
                if (j!=mazzyColumn-1)
                    output[i] += "\t";
            }
        }
        for (int i=0;i<output.length;i++)
            System.out.println(output[i]);

    }

    public void thougthwork() {
        Scanner in = new Scanner(System.in);
        String sizeString = in.nextLine();
        String mazzy = in.nextLine();
        if (check(sizeString,1)!=-1 && check(mazzy,2)!=-1)
            print();
        return;
    }

    public static void main(String[] args) {
        new  task().thougthwork();
    }

}
