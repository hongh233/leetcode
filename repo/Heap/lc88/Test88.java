package repo.Heap.lc88;

public class Test88 {

    public static String runTest(String input) {
        int[] nums1 = parseArray(extractArray(input, "nums1"));
        int m = extractInt(input, "m");
        int[] nums2 = parseArray(extractArray(input, "nums2"));
        int n = extractInt(input, "n");

        Solution88 sol = new Solution88();
        sol.merge(nums1, m, nums2, n);

        return arrayToString(nums1, m + n);
    }

    private static String extractArray(String s, String key) {
        String regex = key + "\\s*=\\s*\\[(.*?)]";
        var m = java.util.regex.Pattern.compile(regex).matcher(s);
        return m.find() ? m.group(1) : "";
    }

    private static int[] parseArray(String csv) {
        csv = csv == null ? "" : csv.trim();
        if (csv.isEmpty()) return new int[0];
        String[] parts = csv.split(",");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i].trim());
        }
        return arr;
    }

    private static int extractInt(String s, String key) {
        String regex = key + "\\s*=\\s*(-?\\d+)";
        var m = java.util.regex.Pattern.compile(regex).matcher(s);
        return m.find() ? Integer.parseInt(m.group(1)) : 0;
    }

    private static String arrayToString(int[] arr, int len) {
        if (arr == null) return "[]";
        len = Math.max(0, Math.min(len, arr.length));
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < len; i++) {
            if (i > 0) sb.append(',');
            sb.append(arr[i]);
        }
        sb.append(']');
        return sb.toString();
    }
}
