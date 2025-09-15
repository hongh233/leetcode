package repo.Sort.lc56;

public class Test56 {

    public static String runTest(String input) {
        int[][] intervals = parseIntervals(input);
        Solution56 s = new Solution56();
        int[][] merged = s.merge(intervals);
        return intervalsToString(merged);
    }

    private static int[][] parseIntervals(String input) {
        if (input == null) return new int[0][];

        String s = input.replaceAll("\\s+", "");
        int l = s.indexOf('[');
        int r = s.lastIndexOf(']');
        if (l < 0 || r < 0 || r <= l) {
            return new int[0][];
        }

        String inner = s.substring(l + 1, r);
        if (inner.isEmpty()) {
            return new int[0][];
        }

        String[] rows = inner.split("\\],\\[");
        int[][] res = new int[rows.length][2];
        for (int i = 0; i < rows.length; i++) {
            String row = rows[i];
            if (row.startsWith("[")) row = row.substring(1);
            if (row.endsWith("]")) row = row.substring(0, row.length() - 1);
            if (row.isEmpty()) {
                res[i] = new int[0];
                continue;
            }
            String[] nums = row.split(",");
            res[i] = new int[nums.length];
            for (int j = 0; j < nums.length; j++) {
                res[i][j] = Integer.parseInt(nums[j]);
            }
        }
        return res;
    }

    private static String intervalsToString(int[][] a) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < a.length; i++) {
            sb.append("[");
            for (int j = 0; j < a[i].length; j++) {
                sb.append(a[i][j]);
                if (j + 1 < a[i].length) sb.append(",");
            }
            sb.append("]");
            if (i + 1 < a.length) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
}
