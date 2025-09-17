package repo.Sort.lc4;

import java.util.Locale;

public class Test4 {

    public static String runTest(String input) {
        input = input.trim();

        int l1 = input.indexOf('[');
        int r1 = input.indexOf(']');
        int l2 = input.indexOf('[', r1 + 1);
        int r2 = input.indexOf(']', l2 + 1);

        int[] nums1 = parseIntArray(slice(input, l1 + 1, r1));
        int[] nums2 = parseIntArray(slice(input, l2 + 1, r2));

        Solution4 sol = new Solution4();
        double ans = sol.findMedianSortedArrays(nums1, nums2);

        return String.format(Locale.US, "%.5f", ans);
    }

    private static String slice(String s, int start, int end) {
        if (start < 0 || end < 0 || end < start || start > s.length()) return "";
        return s.substring(start, Math.min(end, s.length())).trim();
    }

    private static int[] parseIntArray(String csv) {
        if (csv == null || csv.isEmpty()) return new int[0];
        String[] parts = csv.split(",");
        int[] a = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            a[i] = Integer.parseInt(parts[i].trim());
        }
        return a;
    }
}
