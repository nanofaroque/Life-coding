package careercup;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinRangeInKSortedList_16759664 {

    /**
     * Problem Statement:
     * You have k lists of sorted integers. Find the smallest range that includes at least one number from each of the k lists.
     * <p>
     * For example,
     * List 1: [4, 10, 15, 24, 26]
     * List 2: [0, 9, 12, 20]
     * List 3: [5, 18, 22, 30]
     * <p>
     * The smallest range here would be [20, 24] as it contains 24 from list 1, 20 from list 2, and 22 from list 3.
     */

    MinRangeInKSortedList_16759664 minRangeInKSortedList;

    @BeforeEach
    public void init() {
        minRangeInKSortedList = new MinRangeInKSortedList_16759664();

    }

    @Test
    public void firstTest(){
        int res= minRangeInKSortedList.findRange(
                List.of(List.of(4, 10, 15, 24, 26),
                        List.of(0, 9, 12, 20),
                        List.of(5, 18, 22, 30)));
        Assertions.assertEquals(res,4);
    }

    @Test
    public void secondTest(){
        int res= minRangeInKSortedList.findRange(
                List.of(List.of(1,2),
                        List.of(2,3,4,5),
                        List.of(4,5,6)));
        Assertions.assertEquals(res,2);
    }
    int findRange(List<List<Integer>> input) {
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[] max=new int[3];
        max[0]=Integer.MIN_VALUE;
        for(int i=0;i<input.size();i++){
            int data=input.get(i).get(0);
            if(data>max[0]){
                max=new int[]{data,i,0}; // data, list, position
            }
            pq.add(new int[]{data,i,0});
        }
        int minRange=Integer.MAX_VALUE;
        while (!pq.isEmpty()){
            int[] min=pq.poll();
            minRange=Math.min(minRange,max[0]-min[0]);

            int listLoc=min[1];
            int pos=min[2];

            if(pos+1>=input.get(listLoc).size()) break;
            int num=input.get(listLoc).get(pos+1);
            if(num>max[0]){
                max[0]=input.get(listLoc).get(pos+1);
                max[1]=listLoc;
                max[2]=pos+1;
            }
            pq.add(new int[]{input.get(listLoc).get(pos+1),listLoc,pos+1});
        }
        return minRange;
    }
}
