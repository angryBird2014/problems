package IEEE;

import java.util.Scanner;
import java.math.BigInteger;
/**
 * Created by xyan on 10/14/17.
 */
public class Math_challenge {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        for (int i = 1;i<=number;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            BigInteger big_a = new BigInteger(a+"");
            BigInteger big_b_c = func1(b,c);
            BigInteger  big_c = func(c);
            long pow_bc = big_b_c.divide(big_c).longValue();
            long k = (long)Math.pow(10,9)+7;
            //Fast_Power(a,pow_bc,pow_bc)
            System.out.println(mod(a,pow_bc,k));
        }
    }

    public static  BigInteger func(int n){
        BigInteger result =new BigInteger("1");
        for (int i = 1;i<=n;i++){
            String temp = Integer.toString(i);
            BigInteger temp2 = new  BigInteger(temp);
            result = result.multiply(temp2);
        }
        return result;
    }

    public static BigInteger Fast_Power(BigInteger x ,BigInteger n, BigInteger mod)
    {
        BigInteger ret = BigInteger.ONE;
        while(n.compareTo(BigInteger.ZERO) > 0)
        {
            if(n.mod( BigInteger.valueOf(2) ).compareTo(BigInteger.ONE) == 0)
                ret = ret.multiply(x).mod(mod);
            x = x.multiply(x).mod(mod);
            n = n.divide(BigInteger.valueOf(2));
        }
        return ret;
    }

    public static int QuickPow02 (int base_number,long n)
    {
        BigInteger base = new BigInteger(base_number+"");
        if(n == 0) return 1;
        //long ans = 1;
        BigInteger ans = new BigInteger("1");
        while(n!=0){
            if(n%2==1) // 若幂为奇数
                //ans *= base_number;
                ans = ans.multiply(base);
            //base_number *= base_number;
            base = base.multiply(base);
            n >>= 1; // 右位移等价于除以2
        }
        //return ans.mod();
        return 0;
    }

    public static BigInteger func1(int start,int end){
        BigInteger result =new BigInteger("1");
        for(int i = start+1;i<=end;i++){
            String temp = Integer.toString(i);
            BigInteger temp2 = new  BigInteger(temp);
            result = result.multiply(temp2);
        }
        return result;
    }

    public  static  long   mod(long  n,long k,long m){
        long   mod=1;
        long   base=n;
        long  res=1;
        if(n>m){//先减小以下n的值,不然容易超long的范围
            n=n%m;
            base=n;
        }else if(n==m) {
            return 1;
        }
        while(k!=0){
            if((k&1)==1){    //取k的二进制最后一位,若为1,则表示存在该项
                mod*=(base%m);
                if(mod==0){
                    return 0;  //只要有一个数模为0,直接返回0
                }else if(mod>m){
                    mod%=m;        //若模大于除数,则可以进行一次求模
                }
                base=base%m;     //base求余,根据余数来算模,以免超出long的范围
            }
            base*=base; //将余数进行平方来算模,能减小数的大小
            base=base%m;
            k>>=1;          //将k的二进制往右移动一位
        }
        return  mod;
    }
}
