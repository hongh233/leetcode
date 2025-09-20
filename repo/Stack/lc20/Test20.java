package repo.Stack.lc20;

public class Test20 {
    public static String runTest(String input) {
        String expr = extractExpr(input);
        Solution20 sol = new Solution20();
        boolean ans = sol.isValid(expr);
        return String.valueOf(ans);
    }

    private static String extractExpr(String s) {
        s = s.trim();
        if (s.startsWith("s =")) {
            return s.substring(3).trim();
        }
        return s;
    }
}
