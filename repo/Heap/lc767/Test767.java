package repo.Heap.lc767;

public class Test767 {
    public static String runTest(String input) {
        String s = extractString(input, "s");

        Solution767 sol = new Solution767();
        String ans = sol.reorganizeString(s);

        return ans == null ? "" : ans;
    }

    private static String extractString(String s, String key) {
        String regex = key + "\\s*=\\s*([a-zA-Z0-9]*)";
        var m = java.util.regex.Pattern.compile(regex).matcher(s);
        return m.find() ? m.group(1) : "";
    }
}
