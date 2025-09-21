package repo.Hash.lc128;

import java.util.HashSet;

public class Solution128 {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int final_maxLen = 1;
        for (int currInt : set) {
            if (!set.contains(currInt - 1)) {
                int j = 1;
                int maxLen = 1;
                while (set.contains(currInt + j)) {
                    maxLen++;
                    j++;
                }
                final_maxLen = Math.max(final_maxLen, maxLen);
            }
        }
        return final_maxLen;
    }
}
