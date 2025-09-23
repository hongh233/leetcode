// use hashmap<int, pq<int>>

package repo.Heap.lc1086;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution1086 {
    public int[][] highFive(int[][] items) {

        HashMap<Integer, PriorityQueue<Integer>> hm = new HashMap<>();
        for (int[] pair : items) {
            int key = pair[0];
            int score = pair[1];
            if (!hm.containsKey(key)) {
                PriorityQueue<Integer> pq = new PriorityQueue<>(
                        new Comparator<Integer>() {
                            @Override
                            public int compare(Integer o1, Integer o2) {
                                return o1-o2;
                            }
                        }
                );
                pq.add(score);
                hm.put(key, pq);
            } else {
                PriorityQueue<Integer> exist_pq = hm.get(key);
                exist_pq.add(score);
                if (exist_pq.size() > 5) {
                    exist_pq.poll();
                }
            }
        }

        int[][] result = new int[hm.size()][2];
        int i = 0;
        for (Map.Entry<Integer, PriorityQueue<Integer>> map : hm.entrySet()) {
            PriorityQueue<Integer> pq = map.getValue();
            int total = 0;
            while (!pq.isEmpty()) {
                total += pq.poll();
            }
            int avg = total / 5;
            result[i] = new int[]{map.getKey(), avg};
            i++;
        }
        return result;
    }

}
