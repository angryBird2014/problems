package leetcode;
import sun.nio.cs.ext.MacArabic;

import java.util.*;

public class maxDepth {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public int solution(Node root){
        if (root==null)
            return 0;
        int max = 0;
        for (int i=0;i<root.children.size();i++){
            max = Math.max(max,solution(root.children.get(i)))+1;
        }
        return max;
    }



}
