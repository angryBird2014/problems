package leetcode;

import java.util.*;

public class findOrder {
    public int[] solution(int numCourses, int[][] prerequisites){
        //1.构建领结链表
        int[] node = new int[numCourses];
        List<List<Integer>> adjs = new ArrayList<>(numCourses);
       for (int i=0;i<numCourses;i++)
            adjs.add(new ArrayList<>());
        for (int[] edgs:prerequisites){
            int after = edgs[0];
            int before = edgs[1];
            node[after] ++ ; //统计每个节点的入度
            adjs.get(before).add(after);
        }

        int[] order = new int[numCourses];
        int visit = 0;
        //开始广度优先遍历
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<numCourses;i++)
            if (node[i]==0)
                queue.offer(i);
        while (!queue.isEmpty()){
            int number = queue.poll();

            order[visit++] = number;
            for (int e:adjs.get(number)){
                node[e]--;
                if (node[e]==0)
                    queue.offer(e);
            }
        }
        return visit == numCourses? order : new int[0];
    }

    public static void main(String[] args) {
        int number = 4;
        int[][] array = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        int[] result = new findOrder().solution(number,array);
        for (int i=0;i<result.length;i++)
            System.out.println(result[i]);
    }
}
