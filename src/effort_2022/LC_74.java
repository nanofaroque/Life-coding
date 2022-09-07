package effort_2022;

import java.util.Arrays;

public class LC_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        while (row >= 0) {
            if (matrix[row][0] <= target) break;
            row--;
        }
        int result = row < 0 ? Arrays.binarySearch(matrix[0], target) : Arrays.binarySearch(matrix[row], target);
        return result >= 0;
    }
}
