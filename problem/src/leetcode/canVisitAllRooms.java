package leetcode;

import java.util.*;

public class canVisitAllRooms {
    public boolean solution(List<List<Integer>> rooms){

        if(rooms==null||rooms.size()==0)
            return true;
        Stack<Integer> dfs = new Stack<>();
        dfs.add(0);
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        while (!dfs.isEmpty()){
            int ele = dfs.pop();
            for (int a:rooms.get(ele)) {
                if (!set.contains(a)){
                    dfs.add(a);
                    set.add(a);
                    if (set.size()==rooms.size())
                        return true;
                }
            }
        }
        return set.size()==rooms.size();
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> room1 = new ArrayList<>();room1.add(1);room1.add(3);
        ArrayList<Integer> room2 = new ArrayList<>();room2.add(3);room2.add(0);room2.add(1);
        ArrayList<Integer> room3 = new ArrayList<>();room3.add(2);
        ArrayList<Integer> room4 = new ArrayList<>();room3.add(0);
        result.add(room1);result.add(room2);result.add(room3);result.add(room4);
        System.out.println(new canVisitAllRooms().solution(result));
    }

}

