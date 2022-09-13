package effort_2022;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_994 {
    public static void main(String[] args) {
        LC_994 p = new LC_994();
        p.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}});
        System.out.println(min);
    }

    int R, C;
    static int min = 0;
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int orangesRotting(int[][] grid) {
        if (grid.length == 0) return 0;
        Queue<int[]> q = new LinkedList<>();
        R = grid.length;
        C = grid[0].length;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    q.add(new int[]{r, c});

                }
            }
        }
        dfs(grid, q);
        return min;
    }

    private void dfs(int[][] grid, Queue<int[]> q) {
        min = 0;
        int size = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            if (size <= q.size()) {
                min = -1;
                break;
            }

            size = q.size();
            min += 1;
            ArrayList<int[]> markedForRotten = new ArrayList<>();
            List<int[]> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int[] pulled = q.poll();
                boolean isMarked = false;
                for (int[] dir : dirs) {
                    int nr = dir[0] + pulled[0];
                    int nc = dir[1] + pulled[1];
                    if (inBoundary(nr, nc) && grid[nr][nc] == 2) {
                        markedForRotten.add(pulled);
                        isMarked = true;
                        break;
                    }
                }
                if (!isMarked) {
                    temp.add(pulled);
                }
            }

            for (int[] marked : markedForRotten) {
                grid[marked[0]][marked[1]] = 2;
            }
            q.addAll(temp);
        }
    }

    private boolean inBoundary(int r, int c) {
        return r < R && r >= 0 && c < C && c >= 0;
    }
}
