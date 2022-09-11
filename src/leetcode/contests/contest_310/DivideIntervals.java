package leetcode.contests.contest_310;

import java.util.*;


public class DivideIntervals {
    public static void main(String[] args) {
        DivideIntervals d=new DivideIntervals();
        d.minGroups(new int[][]{{5,10},{6,8},{1,5},{2,3},{1,10}});
    }

    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        
        TreeMap<Integer,PriorityQueue<int[]>> list=new TreeMap<>();
        
        int group=0;
        for(int[] in:intervals){
            if(list.isEmpty()){
                PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
                pq.add(in);
                list.put(in[1],pq);
                group+=1;
            }else{
                boolean isGrouped=false;
                PriorityQueue<int[]> temp = null;
                int existingKey=Integer.MIN_VALUE;
                for(Map.Entry<Integer,PriorityQueue<int[]>>  entry: list.entrySet()){
                    int[] peeked= entry.getValue().peek();
                    
                    if(peeked[1]<in[0]){
                        temp=entry.getValue();
                        temp.add(in);
                        existingKey=entry.getKey();
                        isGrouped=true;
                        break;
                    }
                    
                }
                
                if(!isGrouped){
                    PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
                    pq.add(in);
                    list.put(in[1],pq);
                    group+=1;
                }else{
                    list.remove(existingKey);
                    list.put(in[1],temp);
                }
            }
        }
        System.out.println(group);
        return group;
    }

    private void print(int[][] arr){
        for(int[] data: arr){
            System.out.println(data[0]+"-"+data[1]);
        }
    }
}
