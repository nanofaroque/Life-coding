package effort_2022;

import java.util.*;

public class LC_621 {
    class Task {
        char c;
        int frequency;

        Task(char c, int fre) {
            this.c = c;
            this.frequency = fre;
        }
    }

    public static void main(String[] args) {
        LC_621 p = new LC_621();
        p.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2);
    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }

        PriorityQueue<Task> pq = new PriorityQueue<>((t1, t2) -> t2.frequency - t1.frequency);
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            pq.add(new Task(e.getKey(), e.getValue()));
        }
        System.out.println(pq);
        Map<Character, Integer> lastUsed = new HashMap<>();
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int size = pq.size();
            List<Task> list = new ArrayList<>();
            boolean isUpdated = false;
            for (int i = 0; i < size; i++) {
                Task t = pq.poll();
                if (lastUsed.get(t.c) == null || lastUsed.get(t.c) < idx - n) {
                    lastUsed.put(t.c, idx);
                    sb.append(t.c);
                    idx++;
                    isUpdated = true;
                    if (t.frequency - 1 > 0) {
                        pq.add(new Task(t.c, t.frequency - 1));

                    }
                    break;
                } else {
                    list.add(t);
                }
            }
            pq.addAll(list);

            if (!isUpdated) {
                sb.append('#');
                idx++;
            }
            ;

        }
        System.out.println(idx);
        System.out.println(sb.toString());
        return 0;
    }
}
