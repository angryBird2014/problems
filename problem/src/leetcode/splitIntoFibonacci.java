package leetcode;

import java.util.ArrayList;
import java.util.List;

public class splitIntoFibonacci {
    public List<Integer> solution(String S){
        ArrayList<Integer> arrayList = new ArrayList<>();
        helper(S,arrayList,0);
        return arrayList;
    }
    public boolean helper(String s,ArrayList<Integer> arrayList,int index){
        if (index==s.length() && arrayList.size()>=3)
            return true;
        for (int i=index;i<s.length();i++){
            if (i>index && s.charAt(i)=='0')
                break;
            int num = Integer.valueOf(s.substring(index,i+1));
            if (num > Integer.MAX_VALUE)
                break;
            if (arrayList.size()>=2 && num > (arrayList.get(arrayList.size()-1)+arrayList.get(arrayList.size()-2)))
                break;
            if (arrayList.size()<=1 || num == (arrayList.get(arrayList.size()-1)+arrayList.get(arrayList.size()-2))){
                arrayList.add(num);
                if (helper(s,arrayList,i+1))
                    return true;
                arrayList.remove(arrayList.size()-1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new splitIntoFibonacci().solution("123456579"));
    }
}
