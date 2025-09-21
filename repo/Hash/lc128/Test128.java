package repo.Hash.lc128;

public class Test128 {

    public static String runTest(String input) {
        int[] nums = parseArray(extractArray(input, "nums"));
        Solution128 sol = new Solution128();
        int res = sol.longestConsecutive(nums);
        return String.valueOf(res);
    }

    private static String extractArray(String s, String key) {
        String regex = key + "\\s*=\\s*\\[(.*?)]";
        var m = java.util.regex.Pattern.compile(regex).matcher(s);
        return m.find() ? m.group(1) : "";
    }

    private static int[] parseArray(String csv) {
        if (csv == null || csv.isEmpty()) return new int[0];
        String[] parts = csv.split(",");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i].trim());
        }
        return arr;
    }
}
