package effort_2022;

import java.util.HashSet;
import java.util.Set;

class LC_73 {
    int R,C;
    Set<Integer> pRows; //=new HashSet<>();
    Set<Integer> pCols; //=new HashSet<>();
    public void setZeroes(int[][] matrix) {
        R=matrix.length;
        C=matrix[0].length;
        Set<int[]> zeros=new HashSet<>();
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(matrix[i][j]==0) zeros.add(new int[]{i,j});
            }
        }
        pRows=new HashSet<>();
        pCols=new HashSet<>();
        
        for(int[] zero:zeros){
            int r=zero[0];
            int c=zero[1];
            
            if(!pRows.contains(r)) changeToZeroForRow(r,matrix);
            if(!pCols.contains(c)) changeToZeroForCol(c,matrix);
        }
        
    }
    
    private void changeToZeroForCol(int col, int[][] matrix){
        for(int r=0;r<R;r++){
            matrix[r][col]=0;
        }
        pCols.add(col);
    }
    
    private void changeToZeroForRow(int row, int[][] matrix){
        for(int c=0;c<C;c++){
            matrix[row][c]=0;
        }
        pRows.add(row);
    }
}
