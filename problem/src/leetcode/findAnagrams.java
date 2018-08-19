package leetcode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class findAnagrams {


    public static List<Integer> solution4(String s,String t){
        int[] array = new int[256];
        Arrays.fill(array,0);
        for (int i=0;i<t.length();i++)
            array[t.charAt(i)]++;
        int[] arraycopy = Arrays.copyOf(array,array.length);
        int begin = 0;
        List<Integer> result = new ArrayList<>();
        for (int i=begin;i<s.length()-t.length();i++){
            boolean flag = true;
            for (int j=begin;j<t.length();j++){
                if(arraycopy[s.charAt(j)]<=0){
                    flag = false;
                    break;
                }
                else{
                    arraycopy[j]--;
                }
            }
            if(flag == true )
                result.add(i);
            arraycopy = Arrays.copyOf(array,array.length);
        }
        return result;

    }

    public static List<Integer> solution(String s,String p){
        int[] flag = new int[p.length()];
        Arrays.fill(flag,0);
        String source = p;
        ArrayList<Integer> arrayList = new ArrayList<>();
        HashMap<Character,Integer> source_map = new HashMap<>();
        for (int i=0;i<source.length();i++)
            if (!source_map.containsKey(source.charAt(i)))
                source_map.put(source.charAt(i),1);
            else
                source_map.put(source.charAt(i),source_map.get(source.charAt(i))+1);

        for (int i=0;i<s.length()-p.length()+1;i++){
                HashMap<Character,Integer> map = new HashMap<>(source_map);
                if (isSubstring(map,s.substring(i,i+p.length()))){
                    System.out.println(i);
                    arrayList.add(i);
                }

        }
        return arrayList;
    }

    public static boolean isSubstring(HashMap<Character,Integer> source_map, String target){
        for(int j =0;j<target.length();j++){
            if (!source_map.containsKey(target.charAt(j)))
                return false;
            if (source_map.get(target.charAt(j))==0)
                return false;
            else
                source_map.put(target.charAt(j),source_map.get(target.charAt(j))-1);
        }
        return true;
    }

    /*
    下面这种利用滑动窗口Sliding Window的方法也比较巧妙，首先统计字符串p的字符个数，然后用两个变量left和right表示滑动窗口的左右边界，用变量cnt表示字符串p中需要匹配的字符个数，
    然后开始循环，如果右边界的字符已经在哈希表中了，说明该字符在p中有出现，则cnt自减1，然后哈希表中该字符个数自减1，右边界自加1，如果此时cnt减为0了，
    说明p中的字符都匹配上了，那么将此时左边界加入结果res中。如果此时right和left的差为p的长度，说明此时应该去掉最左边的一个字符，我们看如果该字符在哈希表中的个数大于等于0，
    说明该字符是p中的字符，为啥呢，因为上面我们有让每个字符自减1，如果不是p中的字符，那么在哈希表中个数应该为0，自减1后就为-1，
    所以这样就知道该字符是否属于p，如果我们去掉了属于p的一个字符，cnt自增1，参见代码如下：
     */

    public static List<Integer> solution3(String s,String t){
        List<Integer> result = new LinkedList<>();
        if(t.length()> s.length()) return result;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();

        int begin = 0, end = 0;
        int head = 0;
        int len = Integer.MAX_VALUE;


        while(end < s.length()){
            char c = s.charAt(end);
            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) counter--;
            }
            end++;

            while(counter == 0){
                char tempc = s.charAt(begin);
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);
                    if(map.get(tempc) > 0){
                        counter++;
                    }
                }
                if(end-begin == t.length()){
                    result.add(begin);
                }
                begin++;
            }

        }
        return result;
    }

    public static List<Integer> solution2(String s,String p){
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        int[] hash = new int[256]; //character hash
        //record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            //move right everytime, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            if (hash[s.charAt(right++)]-- >= 1) count--;

            //when the count is down to 0, means we found the right anagram
            //then add window's left to result list
            if (count == 0) {
                System.out.println(left);list.add(left);}

            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> result = solution4("cbaebabccd","abc");
        for(int i=0;i<result.size();i++)
            System.out.println(result.get(i));

    }
}
