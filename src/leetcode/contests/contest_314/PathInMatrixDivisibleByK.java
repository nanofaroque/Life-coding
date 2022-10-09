package leetcode.contests.contest_314;

import java.util.LinkedList;
import java.util.Queue;

public class PathInMatrixDivisibleByK {
    public static void main(String[] args) {
        PathInMatrixDivisibleByK p=new PathInMatrixDivisibleByK();
        //int result= p.numberOfPaths(new int[][]{{5,2,4},{3,0,5},{0,7,2}},3);
        //int result= p.numberOfPaths(new int[][]{{0}},1);
        int result= p.numberOfPaths(new int[][]{{1,5,3,7,3,2,3,5}},
        29);
        System.out.println(result);
    }
    int R,C;
    int[][] dirs=new int[][]{{1,0},{0,1}};
    int MOD=1000000007;
    public int numberOfPaths(int[][] grid, int k) {
        R=grid.length;
        C=grid[0].length;
        int count=0;
        Queue<int[]> q=new LinkedList<>();

        q.add(new int[]{0,0,grid[0][0]});

        while (!q.isEmpty()){
            int size=q.size();

            for(int i=0;i<size;i++){
                int[] curr=q.poll();
                int r=curr[0];
                int c=curr[1];
                if(r==R-1 && c==C-1){
                    if(curr[2]%k==0) count++;
                }
                int val=curr[2];
                for(int[] dir:dirs){
                    int nr=r+dir[0];
                    int nc=c+dir[1];
                    if(!inBoundary(nr,nc)) continue;

                    int newVal=(val+grid[nr][nc])%MOD;
                    System.out.println(newVal);
                    if(nr==R-1 && nc==C-1){
                        if(newVal%k==0) count++;
                    }else{
                        q.add(new int[]{nr,nc,newVal});
                    }
                }
            }
        }
        return count;
    }

    public boolean inBoundary(int r, int c){
        return r>=0 && c>=0 && r<R && c<C;
    }
}
