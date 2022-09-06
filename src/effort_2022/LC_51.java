package effort_2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_51 {
    int R, C;
    List<List<String>> result;//=new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        R = n;
        C = n;
        char[][] board = new char[n][n];
        for (int i = 0; i < R; i++) {
            Arrays.fill(board[i], '.');
        }
        dfs(board, 0);
        return result;
    }

    private void addToResult(char[][] board) {
        print(board);
        List<String> row = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            char[] r = board[i];
            row.add(new String(r));
        }
        result.add(row);
    }

    private boolean dfs(char[][] board, int col) {
        if (col >= C) {
            return true;
        }

        for (int i = 0; i < R; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 'Q';
                if (dfs(board, col + 1)) {
                    addToResult(board);
                }
                board[i][col] = '.';
            }
        }
        return false;
    }

    private void print(char[][] board) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("----------------");
    }

    private boolean isSafe(char[][] board, int row, int col) {
        int i, j;

        /* Check this row on left side */
        for (i = 0; i < col; i++)
            if (board[row][i] == 'Q')
                return false;

        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q')
                return false;

        /* Check lower diagonal on left side */
        for (i = row, j = col; j >= 0 && i < R; i++, j--)
            if (board[i][j] == 'Q')
                return false;

        return true;
    }
}
