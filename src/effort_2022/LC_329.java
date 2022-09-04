package effort_2022;

import others.MasterPrinter;

import java.util.Arrays;

public class LC_329 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };
        LC_329 p = new LC_329();
        p.longestIncreasingPath(matrix);

        MasterPrinter.printMatrix(p.cache);
    }

    int max = 1;
    int r, c;
    int[][] cache;

    public int longestIncreasingPath(int[][] matrix) {
        r = matrix.length;
        c = matrix[0].length;
        cache = new int[r][c];
        for (int i = 0; i < r; i++) {
            Arrays.fill(cache[i], 1);
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int res = dfs(matrix, i, j, cache);
                //cache[i][j]
            }
        }
        return max;
    }

    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int dfs(int[][] matrix, int r, int c, int[][] cache) {

        if (cache[r][c] != 1) return cache[r][c];

        for (int[] dir : dirs) {
            int nr = dir[0] + r;
            int nc = dir[1] + c;
            if (isInBoundary(nr, nc) && matrix[nr][nc] > matrix[r][c]) {
                int result = dfs(matrix, nr, nc, cache) + 1;
                cache[r][c] = Math.max(cache[r][c], result);
                max = Math.max(max, cache[r][c]);
            }
        }

        return cache[r][c];
    }

    private boolean isInBoundary(int nx, int ny) {
        return nx >= 0 && nx < r && ny >= 0 && ny < c;
    }
}
