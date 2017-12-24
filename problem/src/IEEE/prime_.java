package IEEE;

import java.math.BigInteger;

/**
 * Created by xyan on 10/15/17.
 */
public class prime_ {

    public  int prime(BigInteger n){
        int[] prime_table = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103,107,109,113,127,131,137,139,149};
        BigInteger[] result = new BigInteger[50];

        BigInteger sum = new BigInteger("1");
        int i = 0;
        while (sum.compareTo(n)==-1 || sum.compareTo(n)==0){ //小于或等于
            BigInteger str = new BigInteger(prime_table[i]+"");
            sum = sum.multiply(str);
            i++;
        }
        return i-1;

    }

    public static void main(String[] args) {
        prime_ p =new prime_();
        BigInteger n = new BigInteger("31");
        System.out.println(p.prime(n));
    }
}
