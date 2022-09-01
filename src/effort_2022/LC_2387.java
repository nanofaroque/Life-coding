package effort_2022;

import java.util.PriorityQueue;

public class LC_2387 {
    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);

    public int matrixMedian(int[][] grid) {
        for (int[] arr : grid) {
            for (int n : arr) {
                process(max, min, n);
            }
        }

        if (min.size() == max.size()) {
            return (min.poll() + max.poll()) / 2;
        } else {
            if (max.size() != 0 && min.size() != 0) {
                swap(max, min);
            }
            return Math.max(min.size() == 0 ? Integer.MIN_VALUE : min.poll(), max.size() == 0 ? Integer.MIN_VALUE : max.poll());
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
