package pdd;

import java.util.Scanner;

public class 变换 {
    static  int countof = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int len = s.length();
        for (int i = 1; i<len; i++)
        {
            String s1 = s.substring(0, i);
            String s2 = s.substring(i);
            int count1 = countll(s1);
            int count2 = countll(s2);
            countof += count1*count2;
        }
        System.out.println(countof);
    }



    public static  int countll(String s)
    {
        if (s.length() == 1)
            return 1;
        else
        {
            if (s.charAt(0) == '0')
            {
                if (s.charAt(s.length() - 1) == '0')
                    return 0;
                else
                    return 1;
            }
            else if (s.charAt(s.length() - 1) == '0')
                return 1;
            else
                return s.length();
        }
    }
}
