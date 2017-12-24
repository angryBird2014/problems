package jianzhi;

import java.util.*;

/**
 * Created by xyan on 11/5/17.
 */
public class Permutation {
    public ArrayList<String> solution(String str){
          ArrayList<String> result = new ArrayList<>();
          if (str == null || str.length()<1)
              return result;
          char[] array = str.toCharArray();
          HashSet<String> medialResult = new HashSet<>();
          permutation_medical(medialResult,array,0,array.length-1);
          Collections.sort(result);
        result.addAll(medialResult);
            for (String s:result)
                System.out.println(s);

          return result;
    }

    public void permutation_medical(HashSet<String> medialResult,char[] array,int start,int end){
        if (start==end){
            StringBuilder sb=new StringBuilder();
            for(char c:array){
                sb.append(c);
            }
            medialResult.add(sb.toString());
            //System.out.println(Arrays.toString(array));
            return;
        }
        else {
            for(int i=start;i<=end;i++){
                swap(array,start,i);
                permutation_medical(medialResult,array,start+1,end);
                swap (array,start,i);
            }
        }
    }


    public void swap(char[] str, int i, int j) {
        if (i != j) {
            char t = str[i];
            str[i] = str[j];
            str[j] = t;
            }
        }

    public static void main(String[] args) {
        Permutation s = new Permutation();
        s.solution("abc");
    }
}
