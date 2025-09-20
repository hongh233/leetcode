package repo.Stack.lc224;

public class Test224 {
    public static String runTest(String input) {
        String expr = extractExpr(input);
        Solution224 sol = new Solution224();
        int ans = sol.calculate(expr);
        return String.valueOf(ans);
    }

    private static String extractExpr(String s) {
        int idx = s.indexOf('=');
        if (idx < 0) return s.trim();
        return s.substring(idx + 1).trim();
    }
}
