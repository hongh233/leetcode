package repo.BinarySearch1.lc74;

public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int mid_i = T(mid, n)[0];
            int mid_j = T(mid, n)[1];
            if (matrix[mid_i][mid_j] == target) {
                return true;
            } else if (matrix[mid_i][mid_j] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    private int[] T(int num, int n) {
        return new int[]{num/n, num-n*(num/n)};
    }
}
