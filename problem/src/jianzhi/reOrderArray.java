package jianzhi;

/**
 * Created by xyan on 10/10/17.
 */
public class reOrderArray {
    public static  void solution(int[] array){
        int first=0,last = 0;
        int i = 0;
        while(first <= array.length-1){

            while (first <= array.length-1 && array[first] % 2 == 1) first ++; //找到第一个偶数
            if (first >= array.length)
                return ;
            last = first+1;

            while (last <= array.length-1 && array[last] % 2  == 0) last++; //找到第一个奇数
            if (last >= array.length)
                break;

            for (i = last;i>=first+1;i--){
                int tmp = array[i];
                array[i] = array[i-1];
                array[i-1] = tmp;
            }


        }
        for (int j=0;j<array.length;j++)
            System.out.println(array[j]);

    }

    public static void main(String[] args) {
       //int[] array = {2,4,6,1,3,5,7};
        int[] array = {1,2,3,4,5,6,7,8};
        solution(array);
    }
}
