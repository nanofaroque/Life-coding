package leetcode;

public class Problem_223 {
    public static void main(String[] args) {
        Problem_223 p = new Problem_223();
        int res = p.computeArea(-2, -2, 2, 2, 3, 3, 4, 4);
        System.out.println(res);
    }

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {

        int lx = Math.max(ax1, bx1);
        int rx = Math.min(ax2, bx2);

        int by = Math.max(ay1, by1);
        int uy = Math.min(ay2, by2);

        int a1 = (ax2 - ax1) * (ay2 - ay1);
        int a2 = (bx2 - bx1) * (by2 - by1);
        var areCrossed = lx < rx && by < uy;
        return a1 + a2 - (areCrossed ? Math.abs(by - uy) * Math.abs(lx - rx) : 0);
    }

}
