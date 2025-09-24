// two pointers (same direction) + min max heap

package repo.Heap.lc1438;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1438 {

    static class Pair {
        Pair(int idx, int value) {
            this.idx= idx;
            this.value = value;
        }
        int value;
        int idx;
    }

    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Pair> minPQ = new PriorityQueue<>(
                new Comparator<Pair>() {
                    @Override
                    public int compare(Pair o1, Pair o2) {
                        return o1.value-o2.value;
                    }
                }
        );
        PriorityQueue<Pair> maxPQ = new PriorityQueue<>(
                new Comparator<Pair>() {
                    @Override
                    public int compare(Pair o1, Pair o2) {
                        return o2.value-o1.value;
                    }
                }
        );

        int maxLen = 0;
        int size = nums.length;
        int idx1 = 0;
        int idx2 = 0;
        maxPQ.add(new Pair(idx1, nums[idx1]));
        minPQ.add(new Pair(idx2, nums[idx2]));
        while (idx1 < size || idx2 < size) {

            if (minPQ.peek().idx < idx1) {
                minPQ.poll();
                continue;
            }
            if (maxPQ.peek().idx < idx1) {
                maxPQ.poll();
                continue;
            }
            int currMin = minPQ.peek().value;
            int currMax = maxPQ.peek().value;
            if (currMax - currMin <= limit) {
                maxLen = Math.max(maxLen, idx2-idx1+1);
                idx2++;
                if (idx2 == size) {
                    break;
                }
                maxPQ.add(new Pair(idx2, nums[idx2]));
                minPQ.add(new Pair(idx2, nums[idx2]));
            } else {
                idx1++;
            }
        }

        return maxLen;
    }
}
