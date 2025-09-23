// use two heap, O(log(n)) time, O(n) space

package repo.Heap.lc295;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

public class Solution295 {
    public static class MedianFinder {

        // maxPQ.size <= minPQ.size
        PriorityQueue<Integer> minPQ;
        PriorityQueue<Integer> maxPQ;
        public MedianFinder() {
            this.minPQ = new PriorityQueue<>(
                    new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o1.compareTo(o2);
                        }
                    }
            );
            this.maxPQ = new PriorityQueue<>(
                    new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o2.compareTo(o1);
                        }
                    }
            );
        }

        public void addNum(int num) {
            maxPQ.add(num);
            minPQ.add(maxPQ.poll());
            maxPQ.add(minPQ.poll());
            if (maxPQ.size() > minPQ.size()) {
                minPQ.add(maxPQ.poll());
            }
        }

        public double findMedian() {
            if (maxPQ.size() == minPQ.size()) {
                return (maxPQ.peek() + minPQ.peek()) / 2.0;
            } else {
                return minPQ.peek();
            }
        }
    }
}
