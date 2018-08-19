package leetcode;

import java.util.ArrayList;
import java.util.List;

public class letterCasePermutation {
    public List<String> solution(String S){
        List<String> arrayList = new ArrayList<>();
        helper(S,arrayList,0,"");
        return arrayList;
    }
    public void helper(String s,List<String> arrayList,int index,String result){
        if (index==s.length()){
            arrayList.add(result);
            return;
        }

        if (s.charAt(index)>='0' && s.charAt(index)<='9')
           helper(s,arrayList,index+1,result+s.charAt(index));
        else if (s.charAt(index)>='a' && s.charAt(index)<='z'){
            //不变
            helper(s,arrayList,index+1,result+s.charAt(index));
            //变
            helper(s,arrayList,index+1,result+(char)(s.charAt(index)-('a'-'A')));
        }
        else{
            helper(s,arrayList,index+1,result+s.charAt(index));
            helper(s,arrayList,index+1,result+(char)(s.charAt(index)+('a'-'A')));
        }

    }

    public static void main(String[] args) {
        //System.out.println((char)('a'-10));
        System.out.println(new letterCasePermutation().solution("a1b2"));
    }
}
