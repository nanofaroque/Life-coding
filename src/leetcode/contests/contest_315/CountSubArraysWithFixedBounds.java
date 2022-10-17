package leetcode.contests.contest_315;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSubArraysWithFixedBounds {
    public static void main(String[] args) {
        CountSubArraysWithFixedBounds p = new CountSubArraysWithFixedBounds();
        long res = p.countSubarrays(new int[]{35054,398719,945315,945315,820417,945315,35054,945315,171832,945315,35054,109750,790964,441974,552913},
        35054,
        945315);
        System.out.println(res);
    }

    public long countSubarrays(int[] nums, int minK, int maxK) {
        List<Integer> good_part=new ArrayList<>();
        long result = 0;

        for (int i : nums) {
            if (i < minK || i > maxK) {
                // a good_part ends here
                result += CountSubarraysWithMinAndMax (good_part, minK, maxK);
                good_part.clear();
                continue;
            }

            good_part.add(i);
        }

        result += CountSubarraysWithMinAndMax (good_part, minK, maxK);
        return result;

    }

    private long CountSubarraysWithMinAndMax(List<Integer> arr, int mn, int mx) {
        int n = arr.size();
        if (n == 0) return 0;

        int[] last_max_pos=new int[n+1];
        Arrays.fill(last_max_pos,n);
        int[] last_min_pos=new int[n+1];
        Arrays.fill(last_min_pos,n);

        for (int j = n-1; j >= 0; j --) {
            last_max_pos[j] = (arr.get(j) == mx)? j : last_max_pos[j+1];
            last_min_pos[j] = (arr.get(j) == mn)? j : last_min_pos[j+1];
        }

        long result = 0;
        for (int start_ind = 0; start_ind < n; start_ind ++) {
            int first_complete_ind = Math.max (last_min_pos[start_ind], last_max_pos[start_ind]);
            if (first_complete_ind == n) continue;

            result += (n - first_complete_ind);
        }
        return result;
    }

}
