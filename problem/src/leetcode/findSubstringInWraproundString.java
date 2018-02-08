package leetcode;

/**
 * Created by xyan on 1/5/18.
 */
//这题好好体会
public class findSubstringInWraproundString {
    public static int solution(String p){
        int[] count = new int[26];
        int currentMax = 0;
        for (int i=0;i<p.length();i++){
            if (i>0 && (p.charAt(i)-p.charAt(i-1)==1 || (p.charAt(i)-p.charAt(i-1))==-25))
                currentMax ++;
            else
                currentMax = 1;
            count[p.charAt(i)-'a'] = Math.max(currentMax,count[p.charAt(i)-'a']);
        }
        int s = 0;
        for (int i=0;i<count.length;i++)
            s += count[i];
        return s;
    }

    public static void main(String[] args) {
        System.out.println(solution("zab"));
    }
}
