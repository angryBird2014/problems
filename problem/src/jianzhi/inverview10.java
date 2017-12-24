package jianzhi;

/**
 * Created by xyan on 9/5/17.
 */
public class inverview10 {
    public static void fab(int n){
        int[] arr;
        arr = new int[3];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        if(n<0){
            return ;
        }
        if (n==0){
            System.out.println(0);
            return;
        }
        if (n==1){
            System.out.println(1);
            return;
        }
        if(n==2){
            System.out.println(2);
            return;
        }
        if(n>=3){
            int num1 = 1;
            int num2 = 2;
            int result = 0;
            for(int i=3;i<=n;i++){
                result = num1 + num2;
                num1 = num2;
                num2 = result;
            }
            System.out.println(result);
        }
    }
    public static void main(String[] args){
        fab(49);
    }
}
