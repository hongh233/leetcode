package repo.BinarySearch1.lc33;

public class Test33 {
    public static String runTest(String input) {
        int[] nums = parseIntArray(extractArray(input, "nums"));
        int target = parseInt(extractValue(input, "target"));

        Solution33 sol = new Solution33();
        int ans = sol.search(nums, target);

        return String.valueOf(ans);
    }

    private static String extractArray(String s, String key) {
        String regex = key + "\\s*=\\s*\\[(.*?)]";
        var m = java.util.regex.Pattern.compile(regex).matcher(s);
        return m.find() ? m.group(1) : "";
    }

    private static String extractValue(String s, String key) {
        String regex = key + "\\s*=\\s*([^,\\]]+)";
        var m = java.util.regex.Pattern.compile(regex).matcher(s);
        return m.find() ? m.group(1) : "";
    }

    private static int[] parseIntArray(String csv) {
        csv = csv == null ? "" : csv.trim();
        if (csv.isEmpty()) return new int[0];
        String[] parts = csv.split(",");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i].trim());
        }
        return arr;
    }

    private static int parseInt(String s) {
        return Integer.parseInt(s.trim());
    }
}
