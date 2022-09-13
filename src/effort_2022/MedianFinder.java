package effort_2022;

import java.util.PriorityQueue;

public class MedianFinder {
    public static void main(String[] args) {
        MedianFinder m=new MedianFinder();
        m.addNum(1);
        m.addNum(2);
        m.findMedian();
        m.addNum(3);
        //m.addNum(4);
        System.out.println(m.findMedian());
    }
    PriorityQueue<Integer> maxQ;
    PriorityQueue<Integer> minQ;
    public MedianFinder() {
        maxQ=new PriorityQueue<>((a,b)->b-a);
        minQ=new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(maxQ.size()< minQ.size()){
            maxQ.add(num);
            int max=maxQ.poll();
            minQ.add(max);

            int min=minQ.poll();
            maxQ.add(min);
        }else{
            minQ.add(num);

            int min=minQ.poll();
            maxQ.add(min);

            int max=maxQ.poll();
            minQ.add(max);
        }

    }

    public double findMedian() {
        if(minQ.size()>maxQ.size()) return (double)minQ.peek();
        else if(maxQ.size()>minQ.size()) return (double)maxQ.peek();
        else{
            double max=(double) maxQ.peek();
            double min=minQ.peek();
            return (max+min)/2;
        }

    }
}
