// binary search solution, find monotonically increase array:
// remain missing number of i_th elem: num[i]-num[0]-i

package repo.BinarySearch2.lc1060;

public class Solution1060 {
    public int missingElement(int[] nums, int k) {

        int lastIdx = nums.length-1;
        int lastMissVal = nums[lastIdx]-nums[0]-lastIdx;
        if (lastMissVal < k) {
            return nums[lastIdx] + (k - lastMissVal);
        }

        int l = 0;
        int r = nums.length-1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int midVal = nums[mid]-nums[0]-mid;
            if (midVal < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l] - ((nums[l]-nums[0]-l) - k + 1);
    }

}
