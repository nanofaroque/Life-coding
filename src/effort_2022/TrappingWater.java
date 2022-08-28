package effort_2022;

import java.util.ArrayList;

public class TrappingWater {
    public static void main(String[] args) {
        TrappingWater trappingWater = new TrappingWater();
        //trappingWater.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        //trappingWater.trap(new int[]{4, 2, 0, 3, 2, 5});
        trappingWater.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    }

    public int trap(int[] height) {
        int len = height.length;

        ArrayList<int[]> left = new ArrayList<>();
        int[] maxTracker = new int[]{0, height[0]};// index, max height
        left.add(0, maxTracker);

        for (int i = 1; i < len; i++) {
            left.add(i, maxTracker);

            if (height[i] > maxTracker[1]) {
                maxTracker = new int[2];
                maxTracker[0] = i;
                maxTracker[1] = height[i];
            }
        }

        ArrayList<int[]> right = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            right.add(new int[]{});
        }
        maxTracker = new int[]{len - 1, height[len - 1]}; // index, max height
        right.set(len - 1, maxTracker);

        for (int i = len - 2; i >= 0; i--) {
            right.set(i, maxTracker);

            if (height[i] > maxTracker[1]) {
                maxTracker = new int[2];
                maxTracker[0] = i;
                maxTracker[1] = height[i];
            }
        }
        int maxTotal = 0;
        for (int i = 1; i < len - 1; i++) {
            int maxHeight = Math.min(left.get(i)[1], right.get(i)[1]);
            if (maxHeight > height[i]) {
                maxTotal += maxHeight - height[i];
            }
        }
        return maxTotal;
    }
}
