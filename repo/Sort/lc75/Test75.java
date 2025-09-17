package repo.Sort.lc75;

import java.util.*;

public class Test75 {

    public static String runTest(String input) {
        String trimmed = input.trim();
        if (trimmed.startsWith("[")) trimmed = trimmed.substring(1);
        if (trimmed.endsWith("]")) trimmed = trimmed.substring(0, trimmed.length() - 1);

        int[] nums;
        if (trimmed.isEmpty()) {
            nums = new int[0];
        } else {
            String[] parts = trimmed.split(",");
            nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i].trim());
            }
        }

        Solution75 sol = new Solution75();
        sol.sortColors(nums);

        return toCompactArrayString(nums);
    }

    private static String toCompactArrayString(int[] a) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < a.length; i++) {
            if (i > 0) sb.append(',');
            sb.append(a[i]);
        }
        sb.append(']');
        return sb.toString();
    }
}
