package repo.Queue.lc346;

import java.util.LinkedList;
import java.util.Queue;

public class Solution346 {
    /**
     * Your MovingAverage object will be instantiated and called as such:
     * MovingAverage obj = new MovingAverage(size);
     * double param_1 = obj.next(val);
     */
    public static class MovingAverage {

        int size;
        double sum;
        Queue<Integer> queue;

        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            this.size = size;
            this.sum = 0;
            queue = new LinkedList<>();
        }

        public double next(int val) {
            if (queue.size() == size) {
                sum -= queue.poll();
            }
            queue.add(val);
            sum += val;
            return sum / queue.size();
        }
    }
}
