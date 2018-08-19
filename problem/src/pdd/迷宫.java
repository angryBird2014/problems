package pdd;

import java.util.Scanner;

public class 迷宫 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int offset = in.nextInt();
            int n = in.nextInt();
            int length1 = in.nextInt();
            int length2 = in.nextInt();
            if (offset<length1){
                if (n+offset<=length1)
                    System.out.println(offset+" "+(offset+n)+" "+"0 0");
                else {
                    int shengyu = n+offset-length1;
                    if (shengyu<=length2)
                        System.out.println(offset+" "+length1+" "+0+" "+shengyu);
                    else
                        System.out.println(offset+" "+length1+" "+0+" "+length2);
                }
            }
            else {

                int offset2 = offset-length1;

                if (offset2 >= length2){
                    System.out.println(length1+" "+length1+" "+length2+" "+length2);
                }
                else {
                    if (n+offset2<=length2)
                        System.out.println(length1+" "+length1 +" "+offset2+" "+(n+offset2));
                    else {
                        System.out.println(length1+" "+ length1 +" "+offset2+" "+length2);
                    }
                }


            }
        }
    }
}
