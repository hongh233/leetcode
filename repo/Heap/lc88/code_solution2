// use two pointer, build from last
// O(m+n) time, O(1) space

package repo.Heap.lc88;

public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // handle edge case
        if (n == 0) {
            return;
        } else if (m == 0) {
            for (int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        int idx1 = m-1;
        int idx2 = n-1;
        int k = nums1.length - 1;
        while (true) {
            if (idx1 < 0 && idx2 < 0) {
                break;
            }

            if (idx1 < 0) {
                nums1[k] = nums2[idx2];
                idx2--;
            } else if (idx2 < 0) {
                nums1[k] = nums1[idx1];
                idx1--;
            } else if (nums1[idx1] >= nums2[idx2]) {
                nums1[k] = nums1[idx1];
                idx1--;
            } else if (nums1[idx1] < nums2[idx2]) {
                nums1[k] = nums2[idx2];
                idx2--;
            }
            k--;
        }
    }

}
