package effort_2022;

import java.util.*;

public class LC_973 {
    public static void main(String[] args) {
        LC_973 p = new LC_973();
        p.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2);
    }

    public int[][] kClosest(int[][] points, int k) {
        TreeMap<Double, List<int[]>> map = new TreeMap<>();

        for (int[] p : points) {
            double res = Math.sqrt(p[0] * p[0] + p[1] * p[1]);
                //double key= map.keySet().stream().findFirst().get();
                map.compute(res, (kk, vv) -> vv == null ? new ArrayList<>() : vv).add(p);
        }
        System.out.println(map);

        int[][] result = new int[k][2];
        int idx = 0;
        while (idx < k) {
            for (Map.Entry<Double, List<int[]>> e : map.entrySet()) {
                List<int[]> values = e.getValue();
                for (int[] val : values) {
                    if (idx >= k) break;
                    result[idx++] = val;

                }
            }
        }
        //double key= map.keySet().stream().findFirst().get();
        return result;
    }
}
