// f(value) = sum(min(arr[i],value)), which is monotonically increase
// we want to use binary search f(value) to get min|f(value)-target|

package repo.BinarySearch2.lc1300;

public class Solution1300 {
    public int findBestValue(int[] arr, int target) {
        int max = 0;
        for (int x : arr) max = Math.max(max, x);

        int l = 0;
        int r = max;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int sum = sumUp(arr, mid);
            if (sum < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        int try1 = sumUp(arr, l);
        int try2 = sumUp(arr, l-1);
        if (Math.abs(try1-target) < Math.abs(try2-target)) {
            return l;
        } else {
            return l-1;
        }
    }

    private int sumUp(int[] arr, int value) {
        int s = 0;
        for (int i : arr) {
            s += Math.min(i, value);
        }
        return s;
    }
}
