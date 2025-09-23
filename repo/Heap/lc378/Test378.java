package repo.Heap.lc378;

import java.util.ArrayList;
import java.util.List;

public class Test378 {

    public static String runTest(String input) {
        int[][] matrix = parse2DArray(extractArray2D(input, "matrix"));
        int k = extractInt(input, "k");

        Solution378 sol = new Solution378();
        int ans = sol.kthSmallest(matrix, k);

        return String.valueOf(ans);
    }

    private static int extractInt(String s, String key) {
        String regex = key + "\\s*=\\s*(-?\\d+)";
        var m = java.util.regex.Pattern.compile(regex).matcher(s);
        return m.find() ? Integer.parseInt(m.group(1)) : 0;
    }

    private static String extractArray2D(String s, String key) {
        int keyIdx = s.indexOf(key);
        if (keyIdx < 0) return "";
        int eq = s.indexOf('=', keyIdx);
        if (eq < 0) return "";
        int i = eq + 1, n = s.length();

        while (i < n && Character.isWhitespace(s.charAt(i))) i++;
        if (i >= n || s.charAt(i) != '[') return "";
        int start = i;

        int depth = 0;
        while (i < n) {
            char c = s.charAt(i++);
            if (c == '[') depth++;
            else if (c == ']') {
                depth--;
                if (depth == 0) {
                    return s.substring(start, i);
                }
            }
        }
        return "";
    }

    private static int[][] parse2DArray(String s) {
        s = s == null ? "" : s.trim();
        if (s.isEmpty()) return new int[0][0];

        if (!s.startsWith("[[")) {
            if (s.startsWith("[") && s.endsWith("]")) {
                s = "[" + s + "]";
            } else {
                return new int[0][0];
            }
        }

        List<int[]> rows = new ArrayList<>();
        int depth = 0, rowStart = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                depth++;
                if (depth == 2) rowStart = i + 1;
            } else if (c == ']') {
                if (depth == 2 && rowStart != -1) {
                    String inside = s.substring(rowStart, i).trim();
                    if (inside.isEmpty()) {
                        rows.add(new int[0]);
                    } else {
                        String[] parts = inside.split(",");
                        int[] row = new int[parts.length];
                        for (int j = 0; j < parts.length; j++) {
                            row[j] = Integer.parseInt(parts[j].trim());
                        }
                        rows.add(row);
                    }
                    rowStart = -1;
                }
                depth--;
            }
        }

        return rows.toArray(new int[0][]);
    }
}
