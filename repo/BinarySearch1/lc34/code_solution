package repo.BinarySearch1.lc34;

public class Solution34 {
    public int[] searchRange(int[] nums, int target) {

        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        int left = 0;
        int right = nums.length - 1;
        int leftIdx = -1;
        while (true) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                leftIdx = mid;
                right = mid - 1;
            }
            if (left > right) {
                break;
            }
        }

        left = 0;
        right = nums.length - 1;
        int rightIdx = -1;
        while (true) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                rightIdx = mid;
                left = mid + 1;
            }
            if (left > right) {
                break;
            }
        }

        return new int[]{leftIdx, rightIdx};
    }
}
