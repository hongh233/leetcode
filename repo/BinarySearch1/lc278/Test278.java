package repo.BinarySearch1.lc278;

public class Test278 {
    public static String runTest(String input) {
        int n = parseInt(extractValue(input, "n"));
        int bad = parseInt(extractValue(input, "bad"));

        Solution278 sol = new Solution278(bad);
        int ans = sol.firstBadVersion(n);

        return String.valueOf(ans);
    }

    private static String extractValue(String s, String key) {
        String regex = key + "\\s*=\\s*([0-9]+)";
        var m = java.util.regex.Pattern.compile(regex).matcher(s);
        return m.find() ? m.group(1) : "0";
    }

    private static int parseInt(String s) {
        return Integer.parseInt(s.trim());
    }
}
