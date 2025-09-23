package repo.Heap.lc264;

public class Test264 {
    public static String runTest(String input) {
        int n = extractInt(input, "n");

        Solution264 sol = new Solution264();
        int ans = sol.nthUglyNumber(n);

        return String.valueOf(ans);
    }

    private static int extractInt(String s, String key) {
        String regex = key + "\\s*=\\s*(-?\\d+)";
        var m = java.util.regex.Pattern.compile(regex).matcher(s);
        return m.find() ? Integer.parseInt(m.group(1)) : 0;
    }
}
