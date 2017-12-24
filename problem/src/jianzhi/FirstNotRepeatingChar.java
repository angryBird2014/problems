package jianzhi;

import java.util.HashMap;

/**
 * Created by xyan on 12/16/17.
 */
public class FirstNotRepeatingChar {
    public static int solution(String str){
        HashMap<Character,Integer> map_count = new HashMap<>();
        for (int i=0;i<str.length();i++){
            if(map_count.containsKey(str.charAt(i))){
                map_count.put(str.charAt(i),map_count.get(str.charAt(i))+1);
            }
            else
                map_count.put(str.charAt(i),1);
        }
        for (int i=0;i<str.length();i++){
            if (map_count.get(str.charAt(i))==1){
                System.out.println(i);
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        solution("abaaaac");
    }
}
