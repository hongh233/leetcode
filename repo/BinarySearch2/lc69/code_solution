package repo.BinarySearch2.lc69;

public class Solution69 {
    public int mySqrt(int x) {
        if (x == 1 || x == 2) {
            return 1;
        }

        long left = 0;
        long right = x / 2;
        long mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            long midSq = mid * mid;
            long midNextSq = (mid + 1) * (mid + 1);
            if (midSq <= x && x < midNextSq) {
                return (int)mid;
            } else if (midSq > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return (int)mid;
    }
}
