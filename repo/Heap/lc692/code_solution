// heap solution, O(nlogk) time, O(n) space

package repo.Heap.lc692;
import java.util.*;

public class Solution692 {
    public List<String> topKFrequent(String[] words, int k) {

        // k: word, v: frequency
        HashMap<String, Integer> hm = new HashMap<>();
        for (String s : words) {
            hm.put(s, hm.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        if (o1.getValue().equals(o2.getValue())) {
                            // frequency is same, compare str follows lexicographical order
                            return o2.getKey().compareTo(o1.getKey());
                        } else {
                            // frequency is not same, compare frequency
                            return o1.getValue().compareTo(o2.getValue());
                        }
                    }
                }
        );

        for (Map.Entry<String, Integer> map : hm.entrySet()) {
            pq.add(map);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        LinkedList<String> li = new LinkedList<>();
        while (!pq.isEmpty()) {
            li.addFirst(pq.poll().getKey());
        }

        return li;
    }
}
