package repo.Stack.lc1209;

public class Test1209 {

    public static String runTest(String input) {
        String s = extractString(input, "s");
        int k = extractInt(input, "k");

        Solution1209 sol = new Solution1209();
        return sol.removeDuplicates(s, k);
    }

    private static String extractString(String src, String key) {
        String regex = key + "\\s*=\\s*([^,]+)";
        var m = java.util.regex.Pattern.compile(regex).matcher(src);
        if (m.find()) {
            return m.group(1).trim();
        }
        return "";
    }

    private static int extractInt(String src, String key) {
        String regex = key + "\\s*=\\s*(-?\\d+)";
        var m = java.util.regex.Pattern.compile(regex).matcher(src);
        return m.find() ? Integer.parseInt(m.group(1)) : 0;
    }
}
