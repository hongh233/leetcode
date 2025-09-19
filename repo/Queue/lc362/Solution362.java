package repo.Queue.lc362;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */

// both timestamp from hit() and getHit() follows chronological order

public class Solution362 {
    public static class HitCounter {

        static class Node {
            Node (int timestamp, int num) {
                this.timestamp = timestamp;
                this.num = num;
            }
            int timestamp;
            int num;
        }
        Deque<Node> q;
        int getHits;
        int currTimestamp;
        public HitCounter() {
            this.q = new LinkedList<>();
            this.getHits = 0;
            this.currTimestamp = 0;
        }

        public void hit(int timestamp) {
            if (q.isEmpty()) {
                q.add(new Node(timestamp, 1));
            } else if (q.getLast().timestamp == timestamp) {
                q.getLast().num++;
            } else {
                q.add(new Node(timestamp, 1));
            }
            currTimestamp = timestamp;
            getHits++;

            while (!q.isEmpty() && q.peek().timestamp <= timestamp - 300) {
                getHits = getHits - q.pop().num;
            }
        }

        public int getHits(int timestamp) {
            while (!q.isEmpty() && q.peek().timestamp <= timestamp - 300) {
                getHits = getHits - q.pop().num;
            }
            return getHits;
        }
    }

}
