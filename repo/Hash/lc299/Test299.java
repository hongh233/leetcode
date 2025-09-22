package repo.Hash.lc299;

public class Test299 {

    public static String runTest(String input) {
        String secret = extractValue(input, "secret");
        String guess = extractValue(input, "guess");

        Solution299 sol = new Solution299();
        String res = sol.getHint(secret, guess);

        return res == null ? "" : res.trim();
    }

    private static String extractValue(String s, String key) {
        String regex = key + "\\s*=\\s*([^,]+)";
        var m = java.util.regex.Pattern.compile(regex).matcher(s);
        return m.find() ? m.group(1).trim() : "";
    }
}
