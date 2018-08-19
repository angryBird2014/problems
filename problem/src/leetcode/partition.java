package leetcode;

import java.util.ArrayList;

import java.util.List;

public class partition {
    public List<List<String>> solution(String s){
        List<List<String>> result = new ArrayList<>();
        ArrayList<String> tmp = new ArrayList<>();
        helper(s,0,result,tmp);
        return result;
    }

    public boolean ishuiwen(String s,int start,int end){
        if (start==end)
            return true;
        for (int i=start,j = end;i<=j;i++,j--){
            if (s.charAt(i)!=s.charAt(j))
                return false;
        }
        return true;
    }

    public void helper(String s,int index,List<List<String>> result,ArrayList<String> tmp){
        if(index>=s.length()){
            result.add(new ArrayList<>(tmp));
        }
        for (int i=index;i<s.length();i++){
            if (ishuiwen(s,index,i)){
                if(i==index)
                    tmp.add(s.charAt(i)+"");
                else
                    tmp.add(s.substring(index,i+1));
                helper(s,i+1,result,tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> result = new partition().solution("aab");
        for (int i=0;i<result.size();i++){
            List<String> tmp = result.get(i);
            System.out.println(tmp);
        }
    }
}
