package leetcode;

import java.util.*;

public class Problem_658{
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        TreeMap<Integer,List<Integer>> pq=new TreeMap<>();
        for(int i=0;i<arr.length;i++){
            int diff=Math.abs(x-arr[i]);
            // System.out.println(diff);
            pq.compute(diff,(key,value)->value==null?new ArrayList<>():value).add(arr[i]);
        }


        List<Integer> result=new ArrayList<>();

        for(Map.Entry<Integer,List<Integer>> e:pq.entrySet()){
            List<Integer> list=e.getValue();
            Collections.sort(list);
            int size=list.size();
            int temp=0;
            while(k>0 && temp<size){
                result.add(list.get(temp++));
                k--;
            }

        }

        Collections.sort(result);
        return result;

    }
}

