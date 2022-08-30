package effort_2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC_56 {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        int len = intervals.length;

        for (int i = 1; i < len; i++) {
            int[] intl = intervals[i];
            int[] last = result.get(result.size() - 1);
            if (isConflict(last, intl)) {
                // merge
                int start = Math.min(last[0], intl[0]);
                int end = Math.max(last[1], intl[1]);
                result.set(result.size() - 1, new int[]{start, end});
                continue;
            } else {
                result.add(intl);
            }


        }
        int[][] resultArray = new int[result.size()][2];
        int idx = 0;
        for (int[] arr : result) {
            System.out.println(arr[0] + "-" + arr[1]);
            resultArray[idx++] = arr;
        }
        return resultArray;
    }

    public boolean isConflict(int[] x, int[] y) {
        if ((y[0] <= x[0] && y[1] >= x[0]) | (y[0] >= x[0] && y[0] <= x[1]))
            return true;
        return false;
    }
}
