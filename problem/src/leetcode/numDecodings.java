package leetcode;

/**
 * Created by xyan on 12/22/17.
 */
//这题可以把代码整合起来，有更好的写法
public class numDecodings {
    public static int solution(String s){
        if (s.length()==0||s.startsWith("0"))
            return 0;
        int[] nums = new int[s.length()];
        if (s.length()==1)
            nums[0] = 1;
        if (s.length()>=2){
            String s2 = s.substring(0,2);
            if (s2.compareTo("27")>=0){
                if (s2.charAt(1)=='0'){
                    nums[0]=1;
                    nums[1]=0;
                }
                else{
                    nums[0]=1;
                    nums[1]=1;
                }
            }
            else{
                if (s2.charAt(1)=='0'){
                    nums[0]=1;
                    nums[1]=1;
                }
                else {
                    nums[0] = 1;
                    nums[1] = 2;
                }

            }
        }


        for(int i=2;i<s.length();i++){
            String tmp = s.substring(i-1,i+1);
            int tmp1,tmp2;
            if(s.charAt(i)!='0')
                tmp1 = nums[i-1];
            else
                tmp1 = 0;
            if (tmp.compareTo("27")>=0 || tmp.charAt(0)=='0')
                tmp2 = 0;
            else
                tmp2 = nums[i-2];
            nums[i] = tmp1+tmp2;

        }
        System.out.println(nums[s.length()-1]);
        return nums[s.length()-1];
    }

    public static void main(String[] args) {
        solution("301");
    }
}
