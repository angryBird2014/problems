package leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xyan on 12/25/17.
 */
public class shoppingOffers {

    //dfs
    public static int solution2(List<Integer> price,List<List<Integer>> special,List<Integer> needs){



        int result = Integer.MAX_VALUE;
        //遍历offer,使用深搜尝试要不要offer
        for (int i=0;i<special.size();i++){
            List<Integer> offerTem = special.get(i);
            boolean flag = true;
            for (int j=0;j<needs.size();j++){
                int remain = needs.get(j)-offerTem.get(j);
                needs.set(j,remain);
                if (remain<0 && flag){
                    flag = false;
                }
            }
            if (flag){   //offer有效
                result = Math.min(result,solution2(price,special,needs)+offerTem.get(needs.size()));
            }
            //offer无效(或者上一层递归回来)
            for (int j=0;j<needs.size();j++){
                needs.set(j,needs.get(j)+offerTem.get(j));
            }
        }
        int nonOffer = 0;
        for (int i=0; i<needs.size(); i++) {
            nonOffer += price.get(i) * needs.get(i);
        }
        return Math.min(result,nonOffer);
    }

    /*没有AC
    public static int solution(List<Integer> price,List<List<Integer>> special,List<Integer> needs){
        int offerSum = 0,n = needs.size(),noSum = 0;
        //不用offer
        for (int i=0;i<n;i++){
            noSum += price.get(i);
        }

        //用offer
        offerSum = trace(0,price,special,0,needs);
        return Math.min(offerSum,noSum);

    }
    public static int trace(int sum,List<Integer> price,List<List<Integer>> special,int position,List<Integer> needs){
        if (position==special.size()){

            for (int i=0;i<needs.size();i++){
                if (needs.get(i)!=0){
                    sum += needs.get(i)*price.get(i);
                }
            }
            return sum;

        }
        List<Integer> offerTem = special.get(position);
        int tmpSum  = sum + offerTem.get(offerTem.size()-1);
        List<Integer> tmpNeeds = new LinkedList<Integer>(needs);
        //Collections.copy(tmpNeeds,needs);

        boolean flag = true;
        for(int j=0;j<offerTem.get(position)-1;j++){
            if (needs.get(j)<offerTem.get(j)){
                flag = false;
                break;
            }
        }
        if (flag){
            for (int j=0;j<offerTem.get(position)-1;j++){
                tmpNeeds.set(j,tmpNeeds.get(j)-offerTem.get(j));
            }
        }
        return Math.min(trace(sum,price,special,position+1,needs),
                trace(tmpSum,price,special,position+1,tmpNeeds));
    }
    */

    public static void main(String[] args) {
        List<Integer> price = new LinkedList<>();
        price.add(2);price.add(3);price.add(4);
        List<List<Integer>> offers = new LinkedList<>();
        List<Integer> offer1 = new LinkedList<>();
        offer1.add(1);offer1.add(1);offer1.add(0);offer1.add(4);

        List<Integer> offer2 = new LinkedList<>();
        offer2.add(2);offer2.add(2);offer2.add(1);offer2.add(9);

        offers.add(offer1);offers.add(offer2);

        List<Integer> needs = new LinkedList<>();
        needs.add(1);needs.add(2);needs.add(1);

        System.out.println(solution2(price,offers,needs));
    }
}
