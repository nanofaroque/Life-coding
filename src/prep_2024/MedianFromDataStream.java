package prep_2024;

import java.util.PriorityQueue;

public class MedianFromDataStream {
    public static void main(String[] args) {
        MedianFromDataStream m = new MedianFromDataStream();
        m.addNum(1);
        m.addNum(2);
        System.out.println(m.findMedian());
        m.addNum(3);
        System.out.println(m.findMedian());
    }
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;


    public MedianFromDataStream() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((a,b)->b-a);
    }

    public void addNum(int num) {
        if(min.size()>max.size()){
            max.add(num);
            swipe(min,max);
        }else {
            min.add(num);
            swipe(min,max);
        }
    }

    private void swipe(PriorityQueue<Integer> min, PriorityQueue<Integer> max) {
        max.add(min.poll());
        min.add(max.poll());
    }

    public double findMedian() {
        if(min.size()==max.size()){
            int m = min.peek();
            int n= max.peek();
            return (double)(m+n)/2;
        }
        System.out.println("min: "+min.peek());
        System.out.println("max: "+max.peek());
        return min.size()>max.size()? min.peek():max.peek();
    }
}
