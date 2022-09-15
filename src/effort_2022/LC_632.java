package effort_2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LC_632 {
    public static void main(String[] args) {
        LC_632 p=new LC_632();
        List<List<Integer>> input=new ArrayList<>();
        input.add(Arrays.asList(1,2,3));
        input.add(Arrays.asList(1,2,3));
        input.add(Arrays.asList(1,2,3));
        p.smallestRange(input);
    }
    public int[] smallestRange(List<List<Integer>> input) {
        PriorityQueue<int[]> temp=new PriorityQueue<>((a, b)->a[0]-b[0]);
        PriorityQueue<Integer> element=new PriorityQueue<>((a,b)->b-a);

        for(int i=0;i<input.size();i++){
            List<Integer> l=input.get(i);

            element.add(l.get(0));
            temp.add(new int[]{l.get(0),0,i});


        }
        System.out.println(temp);
        int gMin=Integer.MAX_VALUE;
        int[] result=null;
        while(!temp.isEmpty()){
            int[] item= temp.poll();
            int value=item[0];
            int idx=item[1];
            int parentIdx=item[2];

            int max=element.peek();
            if(max-value<gMin){
                result=new int[]{value,max};
                gMin=max-value;
            }

            element.remove(value);

            // append
            if(idx+1>=input.get(parentIdx).size()) break;
            int newValue =input.get(parentIdx).get(idx+1);
            element.add(newValue);
            temp.add(new int[]{newValue, idx+1,parentIdx});
        }

        return result;
    }
}
