package repo.Sort.lc179;

import java.util.*;

public class Test179 {

    public static String runTest(String input) {

        String trimmed = input.trim();
        if (trimmed.startsWith("[")) trimmed = trimmed.substring(1);
        if (trimmed.endsWith("]")) trimmed = trimmed.substring(0, trimmed.length()-1);


        if (trimmed.isEmpty()) {
            return "";
        }

        String[] parts = trimmed.split(",");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i].trim());
        }

        Solution179 sol = new Solution179();
        return sol.largestNumber(nums);
    }
}
