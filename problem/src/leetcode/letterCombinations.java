package leetcode;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xyan on 1/9/18.
 */
public class letterCombinations {
    public List<String> solution(String digits){
        String[] str = new String[]{"","","abc","def","ghi",
                "jkl","mno","pqrs","tuv","wxyz"};
        List<String> list = new ArrayList<>();
        if (digits.length()==0)
            return list;
        String tmp  = "";
        findSolution(list,digits,0,str,tmp);
        return list;
    }
    public void findSolution(List<String> list,String digits,int index,String[] total,String str){
        if (index >= digits.length()){
            list.add(str);
            return;
        }
        String select = total[digits.charAt(index)-'0'];
        for (int j=0;j<select.length();j++){
            findSolution(list,digits,index+1,total,str+select.charAt(j));
        }

    }

    public static void main(String[] args) {
        letterCombinations s = new letterCombinations();
        System.out.println(s.solution(""));
    }
}
