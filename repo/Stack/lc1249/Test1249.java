package repo.Stack.lc1249;

public class Test1249 {
    public static String runTest(String input) {
        String s = extractInput(input);
        Solution1249 sol = new Solution1249();
        return sol.minRemoveToMakeValid(s);
    }

    private static String extractInput(String src) {
        String trimmed = src.trim();
        int eq = trimmed.indexOf('=');
        if (eq >= 0) {
            return trimmed.substring(eq + 1).trim();
        }
        return trimmed;
    }
}
