package repo.Heap.lc1438;

public class Test1438 {
    public static String runTest(String input) {
        int[] nums = parseArray(extractArray(input, "nums"));
        int limit = extractInt(input, "limit");

        Solution1438 sol = new Solution1438();
        int ans = sol.longestSubarray(nums, limit);

        return String.valueOf(ans);
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
}
