package repo.BinarySearch2.lc69;

public class Test69 {
    public static String runTest(String input) {
        int x = extractInt(input, "x");

        Solution69 sol = new Solution69();
        int ans = sol.mySqrt(x);

        return String.valueOf(ans);
    }

    private static int extractInt(String s, String key) {
        String regex = key + "\\s*=\\s*(\\d+)";
        var m = java.util.regex.Pattern.compile(regex).matcher(s);
        return m.find() ? Integer.parseInt(m.group(1)) : 0;
    }
}
