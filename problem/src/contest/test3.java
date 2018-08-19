package contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class test3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> array = new ArrayList<>();
        for (int i=0;i<n;i++){
            int m = in.nextInt();
            if(count<10){
                if (!map.containsKey(m)){
                    count++;
                    map.put(m,1);
                    array.add(m);
                }

            }
            else
                break;
        }
        System.out.println(array.size());
        for(int i=0;i<array.size();i++)
            System.out.println(array.get(i));
    }


}
