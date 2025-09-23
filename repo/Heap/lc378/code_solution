// use heap, O(klog(n)) time, O(n) space

package repo.Heap.lc378;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution378 {
    public int kthSmallest(int[][] matrix, int k) {
        // k: [row idx, col idx, value]
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[2]-o2[2];
                    }
                }
        );

        for (int i = 0; i < matrix.length; i++) {
            pq.add(new int[]{i, 0, matrix[i][0]});
        }

        for (int i = 0; i < k-1; i++) {
            int[] arr = pq.poll();
            if (arr[1] < matrix.length-1) {
                int[] newElem = new int[]{arr[0], arr[1]+1, matrix[arr[0]][arr[1]+1]};
                pq.add(newElem);
            }
        }
        return pq.poll()[2];
    }
}
