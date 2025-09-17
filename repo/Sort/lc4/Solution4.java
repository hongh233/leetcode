package repo.Sort.lc4;

import java.util.LinkedList;

public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        LinkedList<Integer> list = new LinkedList<>();
        int i = 0;

        int ptr1 = 0;
        int ptr2 = 0;
        int mergedArrSize = nums1.length + nums2.length;
        while (i <= mergedArrSize / 2) {
            if (ptr1 >= nums1.length) {
                list.add(nums2[ptr2]);
                ptr2++;
            } else if (ptr2 >= nums2.length) {
                list.add(nums1[ptr1]);
                ptr1++;
            } else if (nums1[ptr1] <= nums2[ptr2]) {
                list.add(nums1[ptr1]);
                ptr1++;
            } else {
                list.add(nums2[ptr2]);
                ptr2++;
            }
            i++;
        }
        i--;

        double result;
        if (mergedArrSize % 2 == 0) {
            result = (list.get(i) + list.get(i-1)) / 2.0;
        } else {
            result = list.get(i) * 1.0;
        }
        return result;
    }
}