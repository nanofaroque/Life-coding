package leetcode.contests.contest_297;

import others.MasterPrinter;

import java.util.Arrays;

public class MinPathCostInGrid {
    public static void main(String[] args) {
        MinPathCostInGrid minPathCostInGrid = new MinPathCostInGrid();
        int result= minPathCostInGrid.minPathCost(new int[][]{{5, 3}, {4, 0}, {2, 1}},
                new int[][]{{9, 8}, {1, 5}, {10, 12}, {18, 6}, {2, 4}, {14, 3}});
        System.out.println(result);
    }

    public int minPathCost(int[][] grid, int[][] moveCost) {
        int R = grid.length;
        int C = grid[0].length;
        int[][] cache = new int[R][C];
        for (int i = 0; i < R; i++) {
            if (i == 0) {
                for (int c = 0; c < C; c++) {
                    cache[i][c] = grid[i][c];
                }
            } else {
                Arrays.fill(cache[i], Integer.MAX_VALUE);
            }
        }

        for (int r = 0; r < R-1; r++) {
            for (int c = 0; c < C; c++) {
                int cost = grid[r][c];
                int[] costArray = moveCost[cost];

                for (int i = 0; i < costArray.length; i++) {
                    int newCost = costArray[i] + cache[r][c] + grid[r+1][i];
                    cache[r+1][i] = Math.min(cache[r+1][i], newCost);
                }
                MasterPrinter.printMatrix(cache);
            }
        }
        MasterPrinter.printMatrix(cache);
        return Arrays.stream(cache[R-1]).min().getAsInt();

    }
}
