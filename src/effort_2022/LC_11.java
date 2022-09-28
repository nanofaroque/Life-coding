package effort_2022;

public class LC_11 {
    public static void main(String[] args) {
        LC_11 p = new LC_11();
        p.maxArea(new int[]{1, 2,1});
    }

    public int maxArea(int[] height) {

        int max=0;
        int left=0;
        int right=height.length-1;
        while(left<right){
            int hRight = height[right];
            int hLeft=height[left];
            max = Math.max((right -left) * Math.min(hRight, hLeft), max);
            if(hLeft<=hRight) left++;
            else right--;
        }
        System.out.println(max);
        return max;

    }
}
