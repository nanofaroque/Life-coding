package effort_2022;

import java.util.PriorityQueue;

public class LC_4 {
    public static void main(String[] args) {
        LC_4 p = new LC_4();
        double result = p.findMedianSortedArrays(new int[]{3}, new int[]{-2, -1});
        System.out.println(result);
    }

    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        for (int n : nums1) {
            process(max, min, n);
        }
        for (int n : nums2) {
            process(max, min, n);
        }
        if (min.size() == max.size()) {
            return ((double) min.poll() + (double) max.poll()) / 2;
        } else {
            if (max.size() != 0 && min.size() != 0) {
                swap(max, min);
            }
            return (double) Math.max(min.size() == 0 ? Integer.MIN_VALUE : min.poll(), max.size() == 0 ? Integer.MIN_VALUE : max.poll());
        }

    }

    private void process(PriorityQueue<Integer> max, PriorityQueue<Integer> min, int n) {
        if (min.size() == max.size()) {
            min.add(n);
        }
        if (min.size() < max.size()) {
            min.add(n);
            swap(max, min);
        } else {
            max.add(n);
            swap(max, min);
        }
    }

    private void swap(PriorityQueue<Integer> max, PriorityQueue<Integer> min) {
        int maxValue = max.poll();
        int minValue = min.poll();
        max.add(minValue);
        min.add(maxValue);
    }
}
