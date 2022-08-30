package effort_2022;

import java.util.Collections;
import java.util.TreeSet;

public class LC_268 {
    public int missingNumber(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for (int num : nums) {
            set.add(num);
        }
        int len = set.first();
        for (int i = 0; i <= len; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return set.first() + 1;
    }
}
