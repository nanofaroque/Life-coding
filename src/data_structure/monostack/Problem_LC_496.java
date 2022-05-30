package data_structure.monostack;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class Problem_LC_496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int num : nums2) {
            if (stack.isEmpty()) {
                stack.push(num);
            } else {
                while (!stack.isEmpty() && stack.peek() < num) {
                    map.put(stack.peek(), num);
                    stack.poll();
                }
                stack.push(num);
            }
        }

        int[] res = new int[nums1.length];

        int start = 0;
        for (int n : nums1) {
            res[start++] = map.get(n) == null ? -1 : map.get(n);
        }
        return res;
    }
}
