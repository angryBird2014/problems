package huawei;



import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class 时间段 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(",");
        int start = Integer.valueOf(line[0]);
        int end = Integer.valueOf(line[1]);
        if(start < 12) start = 12;
        if (end >= 20) end = 20;
        int[] number = new int[8];
        while (start!=-1 && end!=-1){
            int j = start;
            while (j < end){
                number[j-12] += 1;
                j++;
            }
            line = scanner.nextLine().split(",");
            start = Integer.valueOf(line[0]);
            end = Integer.valueOf(line[1]);
            if(start < 12) start = 12;
            if (end >= 20) end = 20;
        }
        for (int i=0;i<number.length;i++){
            System.out.println("["+(i+12)+","+(i+13)+"):"+number[i]);
        }
    }
}
