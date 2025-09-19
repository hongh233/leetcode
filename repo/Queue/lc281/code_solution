package repo.Queue.lc281;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */

public class Solution281 {
    public static class ZigzagIterator {

        Queue<Iterator<Integer>> q;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            this.q = new LinkedList<>();
            if (v1 != null && !v1.isEmpty()) {
                q.add(v1.iterator());
            }
            if (v2 != null && !v2.isEmpty()) {
                q.add(v2.iterator());
            }
        }

        public ZigzagIterator(List<List<Integer>> vectors) {
            this.q = new LinkedList<>();
            for (List<Integer> li : vectors) {
                q.add(li.iterator());
            }
        }

        public int next() {
            Iterator<Integer> arr = q.remove();
            int result = arr.next();
            if (arr.hasNext()) {
                q.add(arr);
            }
            return result;
        }

        public boolean hasNext() {
            return !this.q.isEmpty();
        }
    }
}
