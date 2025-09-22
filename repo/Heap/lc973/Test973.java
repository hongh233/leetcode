package repo.Heap.lc973;

import java.util.ArrayList;
import java.util.List;

public class Test973 {

    public static String runTest(String input) {
        int[][] points = parse2DArray(extractArray2D(input, "points"));
        int k = extractInt(input, "k");

        Solution973 sol = new Solution973();
        int[][] res = sol.kClosest(points, k);

        return array2DToString(res);
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
        for (; i < n; i++) {
            char c = s.charAt(i);
            if (c == '[') depth++;
            else if (c == ']') {
                depth--;
                if (depth == 0) {
                    return s.substring(start, i + 1);
                }
            }
        }
        return "";
    }

    private static int[][] parse2DArray(String s) {
        s = s == null ? "" : s.trim();
        if (s.isEmpty() || !s.startsWith("[[")) return new int[0][0];

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
                    if (!inside.isEmpty()) {
                        String[] parts = inside.split(",");
                        int[] row = new int[parts.length];
                        for (int k = 0; k < parts.length; k++) row[k] = Integer.parseInt(parts[k].trim());
                        rows.add(row);
                    }
                    rowStart = -1;
                }
                depth--;
            }
        }
        return rows.toArray(new int[0][]);
    }

    private static String array2DToString(int[][] arr) {
        if (arr == null || arr.length == 0) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) sb.append(',');
            sb.append('[').append(arr[i][0]).append(',').append(arr[i][1]).append(']');
        }
        sb.append(']');
        return sb.toString();
    }
}
