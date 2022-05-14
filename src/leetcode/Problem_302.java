package leetcode;

public class Problem_302 {
    public static void main(String[] args) {
        Problem_302 p = new Problem_302();
      /*  int res= p.minArea(new char[][]{
                {'0', '0', '1', '0'},
                {'0', '1', '1', '0'},
                {'0', '1', '0', '0'},
        },0,2);*/
        int res= p.minArea(new char[][]{{'1'}},0,0);
        System.out.println(res);
    }

    int minX = Integer.MAX_VALUE;
    int minY = Integer.MAX_VALUE;
    int maxX = Integer.MIN_VALUE;
    int maxY = Integer.MIN_VALUE;
    int[][] dirs = new int[][]{
            {0, 1}, {0, -1}, {-1, 0}, {1, 0}
    };
    int R = 0;
    int C = 0;

    public int minArea(char[][] image, int x, int y) {
        R = image.length;
        C = image[0].length;
        System.out.println("length: "+R+"<->"+C);
        dfs(image, x, y);

        int length = maxX - minX+1;
        int width = maxY - minY+1;
        return length * width;

    }

    private void dfs(char[][] image, int x, int y) {
        System.out.println(x+"-"+y);
        if (image[x][y] == '1') {
            minX = Math.min(x, minX);
            minY = Math.min(y, minY);
            maxX = Math.max(x, maxX);
            maxY = Math.max(y, maxY);
            image[x][y]='2';
        } else return;

        for (int[] dir : dirs) {
            int nr = x + dir[0];
            int nc = y + dir[1];
            if (isInBoundary(nr,nc)){
                 dfs(image,nr,nc);
            }
        }
    }

    private boolean isInBoundary(int r, int c) {
        return (r >= 0 && r < R && c >= 0 && c < C);
    }
}
