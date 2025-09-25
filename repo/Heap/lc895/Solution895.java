// hashmap + heap solution, k is size of heap, O(k) space
// push: O(logk) time
// pop:  O(logk) time
// could improve to O(1) time for both push and pop

// TD:
// two hashmap solution, k is size of heap, O(k) space
// push: O(1) time
// pop:  O(1) time

package repo.Heap.lc895;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
public class Solution895 {
    public static class FreqStack {

        static class Pair {
            Pair(int value, int freq, int timestamp) {
                this.value = value;
                this.freq = freq;
                this.timestamp = timestamp;
            }
            int value;
            int freq;
            int timestamp;
        }
        PriorityQueue<Pair> pq;        // [0]: val; [1]: freq; [2]: timestamp
        HashMap<Integer, Integer> map;  // k: value; v: freq
        int timestamp;

        public FreqStack() {
            this.pq = new PriorityQueue<>(
                    new Comparator<Pair>() {
                        @Override
                        public int compare(Pair o1, Pair o2) {
                            if (o1.freq == o2.freq) {
                                return o2.timestamp-o1.timestamp;
                            } else {
                                return o2.freq-o1.freq;
                            }
                        }
                    }
            );
            this.map = new HashMap<>();
            this.timestamp = 0;
        }

        public void push(int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
            pq.add(new Pair(val, map.get(val), timestamp));
            timestamp++;
        }

        public int pop() {
            Pair top = pq.poll();
            int val = top.value;
            map.put(val, map.get(val)-1);

            if (map.get(val) == 0) {
                map.remove(val);
            }
            return val;
        }

    }
}
