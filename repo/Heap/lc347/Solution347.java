// use Hashmap + Heap, time O(nlogk), space O(n)

package repo.Heap.lc347;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {

        // k: elem, v: freq
        HashMap<Integer, Integer> h = new HashMap<>();
        for (int num : nums) {
            h.put(num, h.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] a1, int[] a2) {
                        return a1[1]-a2[1];
                    }
                }
        );
        for (Map.Entry<Integer, Integer> entry : h.entrySet()) {
            pq.add(new int[]{entry.getKey(), entry.getValue()});
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[pq.size()];
        int i = 0;
        for (int[] elem : pq) {
            result[i] = elem[0];
            i++;
        }
        return result;
    }
}
