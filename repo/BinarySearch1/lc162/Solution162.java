package repo.BinarySearch1.lc162;

public class Solution162 {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        } else if (nums.length == 2) {
            return nums[0] > nums[1] ? 0 : 1;
        }

        int left = 0;
        int right = nums.length-1;
        int mid;
        while (true) {
            mid = (left + right) / 2;

            if (mid == 0 && nums[mid] > nums[mid+1]) {
                return mid;
            } else if (mid == nums.length-1 && nums[mid-1] < nums[mid]) {
                return mid;
            } else if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                return mid;
            }

            if (nums[mid] < nums[mid+1]) {
                left = mid + 1;
            } else {
                right = mid; // should not be mid-1 since curr mid could be optimal
            }
        }

    }
}
