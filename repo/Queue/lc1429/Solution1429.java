package repo.Queue.lc1429;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
public class Solution1429 {
    public static class FirstUnique {

        Queue<Integer> q;
        HashMap<Integer, Integer> h;

        public FirstUnique(int[] nums) {
            this.q = new LinkedList<>();
            this.h = new HashMap<>();
            for (int num : nums) {
                q.add(num);
                h.put(num, h.containsKey(num) ? h.get(num) + 1 : 1);
            }
        }

        public int showFirstUnique() {
            while(!q.isEmpty()) {
                if (h.get(q.peek()) > 1) {
                    q.poll();
                } else {
                    return q.peek();
                }
            }
            return -1;
        }

        public void add(int value) {
            q.add(value);
            h.put(value, h.containsKey(value) ? h.get(value) + 1 : 1);
        }
    }
}
