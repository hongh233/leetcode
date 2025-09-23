package repo.Heap.lc1086;

public class Test1086 {

    public static String runTest(String input) {
        int[][] items = parse2DArray(extract2DArray(input, "items"));

        Solution1086 sol = new Solution1086();
        int[][] ans = sol.highFive(items);

        return format2D(ans);
    }

    private static String extract2DArray(String s, String key) {
        String regex = key + "\\s*=\\s*(\\[\\[.*]])";
        var m = java.util.regex.Pattern.compile(regex).matcher(s);
        return m.find() ? m.group(1) : "[]";
    }

    private static int[][] parse2DArray(String s) {
        s = s.trim();
        if (s.equals("[]")) return new int[0][0];
        if (s.startsWith("[[")) s = s.substring(2);
        if (s.endsWith("]]")) s = s.substring(0, s.length() - 2);

        String[] parts = s.split("],\\s*\\[");
        int[][] arr = new int[parts.length][];
        for (int i = 0; i < parts.length; i++) {
            String[] nums = parts[i].split(",");
            arr[i] = new int[nums.length];
            for (int j = 0; j < nums.length; j++) {
                arr[i][j] = Integer.parseInt(nums[j].trim());
            }
        }
        return arr;
    }

    private static String format2D(int[][] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) sb.append(',');
            sb.append('[');
            for (int j = 0; j < arr[i].length; j++) {
                if (j > 0) sb.append(',');
                sb.append(arr[i][j]);
            }
            sb.append(']');
        }
        sb.append(']');
        return sb.toString();
    }
}
