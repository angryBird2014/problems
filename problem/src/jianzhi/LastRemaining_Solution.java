package jianzhi;

/**
 * Created by xyan on 12/20/17.
 */
public class LastRemaining_Solution {
    public static int solution(int n,int m){
        if (n==0)
            return -1;
        int[] flag = new int[n];
        for (int i=0;i<flag.length;i++)
            flag[i] = 0;
        int start = 0;
        int count = 1;
        int flag_count = n;
        while (flag_count!=1){
            while (count < m){
                if (flag[start]==0){
                    count ++;
                }
                start = (start+1)%n;
                while (flag[start]!=0)
                    start = (start+1)%n;
            } //找到最后的start
            count = 1;
            flag[start] = 1;
            while (flag[start]!=0)
                start = (start+1)%n;
            flag_count --;
        }
        System.out.println(start);
        return start;
    }

    public static void main(String[] args) {
        solution(0,0);
    }
}
