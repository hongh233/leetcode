// use Heap, time O(nlogk), space O(k)

package repo.Heap.lc973;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution973 {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] a1, int[] a2) {
                        int dist_a1 = a1[0]*a1[0]+a1[1]*a1[1];
                        int dist_a2 = a2[0]*a2[0]+a2[1]*a2[1];
                        return dist_a2-dist_a1;
                    }
                }
        );

        for (int[] cor : points) {
            pq.add(cor);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] result = new int[pq.size()][2];
        int i = 0;
        for (int[] arr : pq) {
            result[i] = arr;
            i++;
        }
        return result;
    }

}
