package leetcode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.*;
public class loudAndRich {

    HashMap<Integer, List<Integer>> richer2 = new HashMap<>();
    int res[];
    public int[] solution(int[][] richer,int[] quiet) {

        int person = quiet.length;
        int[] result = new int[person];
        ArrayList<ArrayList<Integer>> arraylist = new ArrayList<>();
        for (int i = 0; i < person; i++) {
            arraylist.add(new ArrayList<>());
            result[i] = i;
        }

        for (int i = 0; i < richer.length; i++)
            arraylist.get(richer[i][1]).add(richer[i][0]);

        for (int i = 0; i < person; i++) {
            if (arraylist.get(i).size() == 0) {
                continue;
            }
            result[i] = bfs(arraylist, quiet, i);
        }
        return result;
    }

    public int bfs(ArrayList<ArrayList<Integer>> arraylist,int[] quiet,int index){
        int result = index;
        int q = Integer.MAX_VALUE;
        int[] visited = new int[quiet.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(result);
        visited[result] = 1;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            if (quiet[cur]<q){
                result = cur;
                q = quiet[cur];
            }
            if (arraylist.get(cur).size()!=0){
                for (int next:arraylist.get(cur)) {
                    if (visited[next]!=1){
                        queue.offer(next);
                        visited[next] = 1;
                    }

                }
            }

        }
        return result;
    }


    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        for (int i = 0; i < n; ++i) richer2.put(i, new ArrayList<Integer>());
        for (int[] v : richer) richer2.get(v[1]).add(v[0]);
        res = new int[n]; Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) dfs(i, quiet);
        return res;
    }

    int dfs(int i, int[] quiet) {
        if (res[i] != -1) return res[i];
        res[i] = i;
        for (int j : richer2.get(i)) if (quiet[res[i]] > quiet[dfs(j, quiet)]) res[i] = res[j];
        return res[i];
    }

    public static void main(String[] args) {
        int[][] richer = new int[][]{{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};
        int[] result = new loudAndRich().loudAndRich(richer,new int[]{3,2,5,4,6,1,7,0});
        for (int i= 0;i<result.length;i++)
            System.out.printf(result[i]+"\t");
    }

}
