package repo.Heap.lc692;

import java.util.List;

public class Test692 {

    public static String runTest(String input) {
        String[] words = parseStrArray(extractArray(input, "words"));
        int k = extractInt(input, "k");

        Solution692 sol = new Solution692();
        List<String> res = sol.topKFrequent(words, k);

        return listToString(res);
    }

    private static String extractArray(String s, String key) {
        String regex = key + "\\s*=\\s*\\[(.*?)]";
        var m = java.util.regex.Pattern.compile(regex).matcher(s);
        return m.find() ? m.group(1) : "";
    }

    private static String[] parseStrArray(String csv) {
        csv = csv == null ? "" : csv.trim();
        if (csv.isEmpty()) return new String[0];
        String[] parts = csv.split(",");
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
        }
        return parts;
    }

    private static int extractInt(String s, String key) {
        String regex = key + "\\s*=\\s*(-?\\d+)";
        var m = java.util.regex.Pattern.compile(regex).matcher(s);
        return m.find() ? Integer.parseInt(m.group(1)) : 0;
    }

    private static String listToString(List<String> list) {
        if (list == null || list.isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) sb.append(',');
            sb.append(list.get(i));
        }
        sb.append(']');
        return sb.toString();
    }
}
