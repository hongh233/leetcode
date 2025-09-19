package repo.Queue.lc54;

import java.util.ArrayList;
import java.util.List;

public class Test54 {
    public static String runTest(String input) {
        int[][] matrix = parseMatrixByKey(input, "matrix");
        Solution54 sol = new Solution54();
        List<Integer> ans = sol.spiralOrder(matrix);
        return toCompactArrayString(ans);
    }

    private static int[][] parseMatrixByKey(String s, String key) {
        String regex = key + "\\s*=\\s*\\[(.*)]\\s*$";
        var m = java.util.regex.Pattern.compile(regex).matcher(s.trim());
        if (!m.find()) {
            regex = key + "\\s*=\\s*(\\[.*\\])";
            m = java.util.regex.Pattern.compile(regex).matcher(s.trim());
            if (!m.find()) return new int[0][0];
        }
        String body = m.group(1).trim();

        List<int[]> rows = new ArrayList<>();
        int depth = 0, start = -1;
        for (int i = 0; i < body.length(); i++) {
            char c = body.charAt(i);
            if (c == '[') {
                if (depth == 0) start = i;
                depth++;
            } else if (c == ']') {
                depth--;
                if (depth == 0 && start != -1) {
                    String row = body.substring(start + 1, i).trim();
                    rows.add(parseRow(row));
                    start = -1;
                }
            }
        }
        int[][] matrix = new int[rows.size()][];
        for (int i = 0; i < rows.size(); i++) matrix[i] = rows.get(i);
        return matrix;
    }

    private static int[] parseRow(String csv) {
        if (csv.isEmpty()) return new int[0];
        String[] parts = csv.split(",");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) arr[i] = Integer.parseInt(parts[i].trim());
        return arr;
    }

    private static String toCompactArrayString(List<Integer> a) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < a.size(); i++) {
            if (i > 0) sb.append(',');
            sb.append(a.get(i));
        }
        sb.append(']');
        return sb.toString();
    }
}
