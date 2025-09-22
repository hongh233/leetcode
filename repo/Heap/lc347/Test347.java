package repo.Heap.lc347;

import java.util.Arrays;

public class Test347 {

    public static String runTest(String input) {
        int[] nums = parseArray(extractArray(input, "nums"));
        int k = extractInt(input, "k");

        Solution347 sol = new Solution347();
        int[] res = sol.topKFrequent(nums, k);

        if (res == null) res = new int[0];
        Arrays.sort(res);
        return arrayToString(res);
    }

    private static String extractArray(String s, String key) {
        String regex = key + "\\s*=\\s*\\[(.*?)]";
        var m = java.util.regex.Pattern.compile(regex).matcher(s);
        return m.find() ? m.group(1) : "";
    }

    private static int[] parseArray(String csv) {
        csv = csv == null ? "" : csv.trim();
        if (csv.isEmpty()) return new int[0];
        String[] parts = csv.split(",");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i].trim());
        }
        return arr;
    }

    private static int extractInt(String s, String key) {
        String regex = key + "\\s*=\\s*(-?\\d+)";
        var m = java.util.regex.Pattern.compile(regex).matcher(s);
        return m.find() ? Integer.parseInt(m.group(1)) : 0;
    }

    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) sb.append(',');
            sb.append(arr[i]);
        }
        sb.append(']');
        return sb.toString();
    }
}
