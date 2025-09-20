package repo.Stack.lc150;

public class Test150 {
    public static String runTest(String input) {
        String[] tokens = parseTokens(input);
        Solution150 sol = new Solution150();
        int ans = sol.evalRPN(tokens);
        return String.valueOf(ans);
    }

    private static String[] parseTokens(String s) {
        String regex = "tokens\\s*=\\s*\\[(.*?)]";
        var m = java.util.regex.Pattern.compile(regex).matcher(s);
        if (!m.find()) return new String[0];
        String inside = m.group(1).trim();
        if (inside.isEmpty()) return new String[0];

        String[] parts = inside.split(",");
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
        }
        return parts;
    }
}
