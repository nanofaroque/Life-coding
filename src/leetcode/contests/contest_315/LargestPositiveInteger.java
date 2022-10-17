package leetcode.contests.contest_315;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LargestPositiveInteger {

    public static void main(String[] args) {
        LargestPositiveInteger p=new LargestPositiveInteger();
        p.findMaxK(new int[]{14,33,40,-33,8,-24,-42,30,-18,-34});
    }

    public int findMaxK(int[] nums) {

        PriorityQueue<Integer> max=new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> min=new PriorityQueue<>();

        for(int num:nums){
            max.add(num);
            min.add(num);
        }

        while (!max.isEmpty() && !min.isEmpty()){
            int l=max.poll();

            while (!min.isEmpty() && min.peek()<-l){
                min.poll();
            }
            if(!min.isEmpty() && min.peek()==-l){
                return l;
            }
        }
        return -1;
    }
}
