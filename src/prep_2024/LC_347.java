package prep_2024;

import java.util.*;

public class LC_347 {
    public static void main(String[] args) {
        LC_347 l = new LC_347();
        l.topKFrequent(new int[]{5, 3, 1, 1, 1, 3, 73, 1}, 2);
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> list = new ArrayList<>();
        for (int x : nums) {
            map.compute(x, (key, value) -> value == null ? 1 : value + 1);
        }

        
        map.entrySet()
                .stream()
                .parallel()
                .forEach(e -> list.add(new int[]{e.getKey(), e.getValue()}));


        list.sort(((a, b) -> {
            if (b[1] > a[1]) return 1;
            else if (a[1] > b[1]) return -1;
            else return 0;
        }));

        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i]=list.get(i)[0];
        }
        return res;
    }
}
