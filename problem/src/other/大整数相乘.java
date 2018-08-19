package other;

public class 大整数相乘 {
    public static void main(String[] args) {
        String s1 = "1213142124";
        String s2 = "12412412";
        int[] result = new int[s1.length()+s2.length()];
        for (int i=0;i<s1.length();i++){
            for (int j=0;j<s2.length();j++){
                result[i+j+1] += (s1.charAt(i)-'0') * (s2.charAt(j)-'0');
            }
        }
        for (int k = result.length-1;k>0;k--){
            if (result[k] >= 10){
                result[k-1] += result[k]/10;
                result[k] = result[k] % 10;
            }
        }
        for (int i=1;i<result.length;i++)
            System.out.print(result[i]);
    }
}
