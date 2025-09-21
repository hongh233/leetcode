package repo.Hash.lc73;

import java.util.ArrayList;
import java.util.List;

public class Test73 {
    public static String runTest(String input) {
        int[][] matrix = parseMatrixByKey(input, "matrix");

        Solution73 sol = new Solution73();
        sol.setZeroes(matrix);

        return toCompactMatrixString(matrix);
    }

    private static int[][] parseMatrixByKey(String s, String key) {
        String regex = key + "\\s*=\\s*(\\[.*\\])";
        var m = java.util.regex.Pattern.compile(regex).matcher(s.trim());
        if (!m.find()) return new int[0][0];
        String outer = m.group(1).trim();
        if (outer.length() < 2) return new int[0][0];
        String body = outer.substring(1, outer.length() - 1).trim();

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

        int[][] mat = new int[rows.size()][];
        for (int i = 0; i < rows.size(); i++) mat[i] = rows.get(i);
        return mat;
    }

    private static int[] parseRow(String csv) {
        if (csv.isEmpty()) return new int[0];
        String[] parts = csv.split(",");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) arr[i] = Integer.parseInt(parts[i].trim());
        return arr;
    }

    private static String toCompactMatrixString(int[][] mat) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int r = 0; r < mat.length; r++) {
            if (r > 0) sb.append(',');
            sb.append('[');
            for (int c = 0; c < mat[r].length; c++) {
                if (c > 0) sb.append(',');
                sb.append(mat[r][c]);
            }
            sb.append(']');
        }
        sb.append(']');
        return sb.toString();
    }
}
