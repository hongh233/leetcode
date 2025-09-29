package repo.BinarySearch2.lc1062;

public class Test1062 {
    public static String runTest(String input) {
        String s = extractString(input, "s");

        Solution1062 sol = new Solution1062();
        int ans = sol.longestRepeatingSubstring(s);

        return String.valueOf(ans);
    }

    private static String extractString(String s, String key) {
        String regex = key + "\\s*=\\s*([a-zA-Z0-9]+)";
        var m = java.util.regex.Pattern.compile(regex).matcher(s);
        return m.find() ? m.group(1) : "";
    }
}
