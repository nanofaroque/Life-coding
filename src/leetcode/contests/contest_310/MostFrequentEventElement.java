package leetcode.contests.contest_310;

import java.util.*;

public class MostFrequentEventElement {
    public static void main(String[] args) {
        MostFrequentEventElement p=new MostFrequentEventElement();
        System.out.println(p.mostFrequentEven(new int[]{29,47,21,41,13,37,25,7}));
    }
    public int mostFrequentEven(int[] nums) {
        Map<Integer,Integer> count=new HashMap<>();
        Map<Integer, TreeSet<Integer>> frequency=new TreeMap<>(Comparator.reverseOrder());


        for(int num:nums){
            if(num%2==0)
                count.compute(num,(k,v)->v==null?1:v+1);
        }

        for(int key:count.keySet()){
            int val=count.get(key);
            frequency.compute(val,(k,v)->v==null ? new TreeSet<>():v).add(key);
        }

        if(frequency.size()==0) return -1;
        int frequencyKey= frequency.keySet().stream().findFirst().get();
        //if(frequency.get(frequencyKey).size()>1) return -1;
            TreeSet<Integer> set = frequency.get(frequencyKey);
            return set.stream().findFirst().get();
    }
}
