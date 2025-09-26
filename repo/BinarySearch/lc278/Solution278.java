package repo.BinarySearch.lc278;

public class Solution278 {
    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
    private int badVersion;
    public Solution278(int badVersion) {
        this.badVersion = badVersion;
    }
    private boolean isBadVersion(int version) {
        return version >= badVersion;
    }

    // answer it here:
    public int firstBadVersion(int n) {
        long left = 1;
        long right = n;

        while (left < right) {
            long mid = (left + right) / 2;
            if (isBadVersion((int)mid)) {
                right = mid;
            } else {
                left = mid+1;
            }
        }

        return (int) left;
    }
}
