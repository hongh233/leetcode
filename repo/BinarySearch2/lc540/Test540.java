package repo.BinarySearch2.lc540;

public class Test540 {
    public static String runTest(String input) {
        int[] nums = parseArray(extractArray(input, "nums"));

        Solution540 sol = new Solution540();
        int ans = sol.singleNonDuplicate(nums);

        return String.valueOf(ans);
    }

    private static String extractArray(String s, String key) {
        String regex = key + "\\s*=\\s*\\[(.*?)]";
        var m = java.util.regex.Pattern.compile(regex).matcher(s);
        return m.find() ? m.group(1) : "";
    }

    private static int[] parseArray(String content) {
        content = content.trim();
        if (content.isEmpty()) return new int[0];
        String[] parts = content.split(",");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i].trim());
        }
        return arr;
    }
}
