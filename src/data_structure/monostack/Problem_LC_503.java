package data_structure.monostack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem_LC_503 {
    public static void main(String[] args) {
        Problem_LC_503 p = new Problem_LC_503();
        p.nextGreaterElements(new int[]{1, 2, 3, 4, 3});
    }

    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        boolean[] filled = new boolean[nums.length];
        Arrays.fill(ans, -1);
        Deque<Integer> st = new ArrayDeque<>();

        // first pass

        // This will create the stack from top to down in a increasing order.
        // violations will be removed from the stack
        for (int i = nums.length - 1; i >= 0; --i) {
            while (!st.isEmpty() && nums[i] >= st.peek()) st.pop();
            if (!st.isEmpty()) {
                ans[i] = st.peek();
                filled[i] = true;
            }
            st.push(nums[i]);
        }
        // since the beginning numbers are at the top
        // violated number has the chance to find anything greater than them
        for (int i = nums.length - 1; i >= 0; --i) {
            if (!filled[i]) {
                while (!st.isEmpty() && nums[i] >= st.peek()) st.pop();
                if (!st.isEmpty()) {
                    ans[i] = st.peek();
                    filled[i] = true;
                }
            }
        }
        return ans;
    }
}
