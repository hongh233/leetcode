package repo.BinarySearch2.lc528;

import java.util.Random;

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */

public class Solution528 {
    public static class Solution {
        int[] sum;
        int total;
        Random rand;
        public Solution(int[] w) {
            this.sum = new int[w.length];
            int s = 0;
            for (int i = 0; i < w.length; i++) {
                s += w[i];
                sum[i] = s;
            }
            this.total = s;
            this.rand = new Random();
        }

        public int pickIndex() {
            int roll = rand.nextInt(1, total+1); // [1, total+1)
            int left = 0;
            int right = sum.length-1;

            while (left < right) {
                int mid = (left + right) / 2;
                if (roll > sum[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return left;
        }
    }
}
