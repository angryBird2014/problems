package leetcode;

public class longestSubstring {
    public int solution(String s,int k){
        char[] array = s.toCharArray();
        return divide(s,k,0,s.length());

    }

    public int divide(String s,int k,int start,int end) {
        if (end - start < k)
            return 0;
        int[] count = new int[26];
        for (int i = start; i < end; i++)
            count[s.charAt(i) - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (count[i] < k && count[i] > 0) {
                for (int j = start; j < end; j++)
                    if (s.charAt(j) == (i + 'a')) {
                        int left = divide(s, k, start, j);
                        int right = divide(s, k, j + 1, end);
                        return Math.max(left, right);
                    }
            }

        }
        return end-start;
    }

    public static void main(String[] args) {
        longestSubstring s = new longestSubstring();
        System.out.println(s.solution("aaabb",3));

    }
}
