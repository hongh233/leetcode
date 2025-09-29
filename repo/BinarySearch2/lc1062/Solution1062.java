// binary search the length of substring:
// if duplicate does not exist, search smaller; otherwise search larger

package repo.BinarySearch2.lc1062;

import java.util.HashSet;
import java.util.Set;

public class Solution1062 {
    public int longestRepeatingSubstring(String s) {
        int length = s.length();
        int l = 0;
        int r = length-1;

        while (l < r) {
            int mid = l + (r - l + 1) / 2; // not l+(r-l)/2
            int amount = length-mid+1;
            Set<String> set = new HashSet<>();
            boolean findDuplicate = false;
            for (int i = 0; i < amount; i++) {
                String subStr = s.substring(i, i+mid);
                if (set.contains(subStr)) {
                    l = mid;
                    findDuplicate = true;
                    break;
                } else {
                    set.add(subStr);
                }
            }
            if (!findDuplicate) {
                r = mid - 1;
            }
        }
        return l;
    }
}
