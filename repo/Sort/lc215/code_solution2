// quick select, O(n) average, O(n^2) worst case

package repo.Sort.lc215;

class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        int target_idx = nums.length - k;

        int left = 0;
        int right = nums.length - 1;

        while(true) {
            int p_idx = partition(nums, left, right);

            if (p_idx == target_idx) {
                return nums[p_idx];
            } else if (p_idx < target_idx) {
                left = p_idx + 1;
            } else {
                right = p_idx - 1;
            }
        }

    }

    // hard
    private int partition(int[] nums, int left, int right) {
        int i = left;
        int j = right;

        int pivot_idx = i;
        int pivot = nums[pivot_idx];

        while (i <= j) {
            while (nums[i] < pivot) i++;
            while (nums[j] > pivot) j--;
            if (i <= j) {
                swap(nums, i, j);
                pivot_idx = (pivot_idx == j) ? i : j;
                if (pivot_idx == j) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        return pivot_idx;
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }
}