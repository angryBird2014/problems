package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xyan on 1/6/18.
 */
public class combinationSum3 {
    public List<List<Integer>> solution(int k,int n){
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmplist = new ArrayList<>();
        findsolution(list,tmplist,k,n,1);
        return list;
    }

    public void findsolution(List<List<Integer>> list,List<Integer> tmplist,int k,int remain,int index){
        if (tmplist.size()==k){
            if (remain==0)
                list.add(new ArrayList<Integer>(tmplist));
            else
                return;
        }
        for (int i=index;i<=9;i++){
            tmplist.add(i);
            findsolution(list,tmplist,k,remain-i,i+1);
            tmplist.remove(tmplist.size()-1);
        }
    }

    public static void main(String[] args) {
        combinationSum3 s3 = new combinationSum3();
        List<List<Integer>> list = new ArrayList<>();
        list = s3.solution(3,9);
        for (List<Integer> nums:
             list) {
            for (int num:
                 nums) {
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}
