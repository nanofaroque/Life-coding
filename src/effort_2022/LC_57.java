package effort_2022;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC_57 {
    public static void main(String[] args) {
        LC_57 lc = new LC_57();
        lc.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        if (len == 0) return new int[][]{newInterval};
        List<int[]> merged = new ArrayList<>();
        merged.add(newInterval);
        for (int i = 0; i < len; i++) {
            merged.add(intervals[i]);
        }
        Collections.sort(merged, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        res.add(merged.get(0));
        for (int i = 1; i < merged.size(); i++) {
            int[] curr = merged.get(i);
            int[] last = res.get(res.size() - 1);

            if (isCollision(last, curr)) {
                curr[0] = Math.min(curr[0], last[0]);
                curr[1] = Math.max(curr[1], last[1]);

                res.set(res.size() - 1, curr);
            } else {
                res.add(curr);
            }

        }


        for (int[] data : res) {
            System.out.println("start: " + data[0] + " end: " + data[1]);
        }

        int[][] result = new int[res.size()][2];
        int idx = 0;
        for (int[] data : res)
            result[idx++] = data;
        return result;
    }

    public boolean isCollision(int[] x, int[] y) {
        if ((y[0] <= x[0] && y[1] >= x[0]) | (y[0] >= x[0] && y[0] <= x[1]))
            return true;
        return false;
    }
}
