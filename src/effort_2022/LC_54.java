package effort_2022;

import java.util.ArrayList;
import java.util.List;

public class LC_54 {
    public static void main(String[] args) {
        LC_54 p = new LC_54();
        p.spiralOrder(new int[][]{
                {1,2,3},{4,5,6},{7,8,9}
        });
    }
    int R, C;
    int[][] matrix;
    public List<Integer> spiralOrder(int[][] matrix) {
        this.matrix=matrix;
        R=matrix.length;
        if(R==0) return new ArrayList<Integer>();
        C=matrix[0].length;
        int total= R*C;
        int r=0,c=0;
        int dir=0; // 0 is right 1 is down # 2 is left # 3 is up
        int count=1;
        List<Integer> result=new ArrayList<>();
        while(count<total+1){
            if(dir==0){
                result.add(matrix[r][c]);
                count++;
                if(isSafe(r,c+1,dir)){
                    matrix[r][c]=Integer.MAX_VALUE;
                    c++;
                }else{
                    dir=1;
                    r++;
                }
            }
            //down
            else if(dir==1){
                result.add(matrix[r][c]);
                count++;
                if(isSafe(r+1,c,dir)){
                    matrix[r][c]=Integer.MAX_VALUE;
                    r++;

                }else{
                    dir=2;
                    c-=1;
                }
            }
            // left
            else if(dir==2){
                result.add(matrix[r][c]);
                count++;
                if(isSafe(r,c-1,dir)){
                    matrix[r][c]=Integer.MAX_VALUE;
                    c--;

                }else{
                    dir=3;
                    r-=1;
                }
            }
            // up
            else if(dir==3){
                result.add(matrix[r][c]);
                count++;
                if(isSafe(r-1,c,dir)){
                    matrix[r][c]=Integer.MAX_VALUE;
                    r--;
                }else{
                    dir=0;
                    c++;
                }
            }
        }
        return result;
    }

    private boolean isSafe(int r, int c, int dir){
        if(dir==0 && c<C && matrix[r][c]!=Integer.MAX_VALUE  ) return true;
        else if(dir==1 && r<R && matrix[r][c]!=Integer.MAX_VALUE ) return true;
        else if(dir==2 && c >=0 && matrix[r][c]!=Integer.MAX_VALUE ) return true;
        else if(dir==3 && c>=0 && matrix[r][c]!=Integer.MAX_VALUE ) return true;
        else return false;
    }
}
