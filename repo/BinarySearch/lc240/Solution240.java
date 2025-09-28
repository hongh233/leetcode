// normal binary search, O(mlogn) time, O(1) space
// could be improved to O(1) time

package repo.BinarySearch.lc240;

public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            int left = 0;
            int right = n-1;
            while (left <= right) {
                int mid = (left + right) / 2;
                int midVal = matrix[i][mid];
                if (midVal == target) {
                    return true;
                } else if (midVal > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}
