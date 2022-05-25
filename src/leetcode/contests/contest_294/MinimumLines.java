package leetcode.contests.contest_294;

import java.util.Arrays;

public class MinimumLines {
    public static void main(String[] args) {
        MinimumLines ml = new MinimumLines();
      /*  int result= ml.minimumLines(new int[][]{{1, 7}, {2, 6}, {3, 5}, {4, 4}, {5, 4}, {6, 3}, {7, 2}, {8, 1}});
        System.out.println(result);*/

       /* int[][] input=new int[][]{
                {1,1000000000},{1000000000,1000000000},{999999999,1},{2,999999999}//,[25,19],[91,30],[52,73],[10,9],[99,71],[47,22],[19,30],[80,63],[18,15],[48,17],[77,16],[46,27],[66,87],[55,84],[65,38],[30,9],[50,42],[100,60],[75,73],[98,53],[22,80],[41,61],[37,47],[95,8],[51,81],[78,79],[57,95]]
        };*/

        int[][] input = new int[][]{
                {1, 1}, {500000000, 499999999}, {1000000000, 999999998}};
        int result = ml.minimumLines(input);
        System.out.println(result);
    }

    public int minimumLines(int[][] stockPrices) {
        if (stockPrices.length < 2) return 0;
        if (stockPrices.length == 2) return 1;
        Arrays.sort(stockPrices, (a, b) -> a[0] - b[0]);

        int[] prev = stockPrices[0];
        int[] curr = stockPrices[1];
        int dy= (curr[1] - prev[1]);
        int dx=(curr[0] - prev[0]);

        double gcd=gcd(dy,dx);
        double gdy=(double) dy/gcd;
        double gdx=(double) dx/gcd;
        int count = 1;
        for (int i = 2; i < stockPrices.length; i++) {
            curr = stockPrices[i];
            prev = stockPrices[i - 1];
            dy= (curr[1] - prev[1]);
            dx=(curr[0] - prev[0]);

            gcd=gcd(dy,dx);
            double gdyCurrent=(double) dy/gcd;
            double gdxCurrent=(double) dx/gcd;
            if (gdxCurrent!=gdx || gdyCurrent!=gdy) {
                count += 1;
            }
            gdx = gdxCurrent;
            gdy = gdyCurrent;
        }
        return count;
    }
    static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
