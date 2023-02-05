package leetcode.contests.contest_331;

import java.util.PriorityQueue;

public class TakeGiftFromRichestPile {
    public static void main(String[] args) {
        TakeGiftFromRichestPile t=new TakeGiftFromRichestPile();
        long res= t.pickGifts(new int[]{25,64,9,4,100},4);
        System.out.println(res);
    }
    public long pickGifts(int[] gifts, int k) {

        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);

        for(int g:gifts){
            pq.add(g);
        }

        int step=0;

        while (step<k){
            int n= pq.poll();
            pq.offer((int) Math.sqrt(n));
            step++;
        }

        long total=0;
        while (!pq.isEmpty()){
            total+=pq.poll();
        }
        return total;

    }
}
