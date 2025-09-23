// dp approach: O(n) time, O(n) space
/*
 * 2 -> 1 x 2  min
 *      1 x 3
 *      1 x 5
 *
 * 3 -> 2 x 2
 *      1 x 3  min
 *      1 x 5
 *
 * 4 -> 2 x 2  min
 *      2 x 3
 *      1 x 5
 *
 * 5 -> 3 x 2
 *      2 x 3
 *      1 x 5  min
 *
 * 6 -> 3 x 2  min
 *      2 x 3  min
 *      2 x 5
 *
 * 7 -> 4 x 2  min
 *      3 x 3
 *      2 x 5
 *
 * 8 -> 5 x 2
 *      3 x 3  min
 *      2 x 5
 *
 * 9 -> 5 x 2  min
 *      4 x 3
 *      2 x 5  min
 *
 * 10-> 6 x 2  min
 *      4 x 3  min
 *      3 x 5
 *
 * 11-> 8 x 2
 *      5 x 3  min
 *      3 x 5  min
 */

/*
 *   i2,i3,i5
 *    \ | /
 *      1 ---> 2 ---> 3 ---> 4 ---> 5
 */

package repo.Heap.lc264;


public class Solution264 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        for (int i = 0 ; i < n; i++) {
            int cmp2 = 2 * dp[i2];
            int cmp3 = 3 * dp[i3];
            int cmp5 = 5 * dp[i5];
            int min = Math.min(cmp2, Math.min(cmp3, cmp5));
            if (cmp2 == min) {
                i2++;
            }
            if (cmp3 == min) {
                i3++;
            }
            if (cmp5 == min) {
                i5++;
            }
            dp[i+1] = min;
        }
        return dp[dp.length-2];
    }
}
