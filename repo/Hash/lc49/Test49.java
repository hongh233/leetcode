package repo.Hash.lc49;

import java.util.*;

public class Test49 {
    public static String runTest(String input) {
        String[] strs = parseStrArray(extractArray(input, "strs"));

        Solution49 sol = new Solution49();
        List<List<String>> groups = sol.groupAnagrams(strs);

        return normalize(groups);
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

    private static String normalize(List<List<String>> groups) {
        if (groups == null) return "[]";
        if (groups.isEmpty()) return "[[]]";

        List<List<String>> copy = new ArrayList<>();
        for (List<String> g : groups) {
            List<String> one = new ArrayList<>(g == null ? Collections.emptyList() : g);
            Collections.sort(one);
            copy.add(one);
        }

        copy.sort((a, b) -> {
            String fa = a.isEmpty() ? "" : a.get(0);
            String fb = b.isEmpty() ? "" : b.get(0);
            int c = fa.compareTo(fb);
            if (c != 0) return c;
            c = Integer.compare(a.size(), b.size());
            if (c != 0) return c;
            return String.join(",", a).compareTo(String.join(",", b));
        });

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < copy.size(); i++) {
            if (i > 0) sb.append(',');
            sb.append('[');
            List<String> g = copy.get(i);
            for (int j = 0; j < g.size(); j++) {
                if (j > 0) sb.append(',');
                sb.append(g.get(j));
            }
            sb.append(']');
        }
        sb.append(']');
        return sb.toString();
    }

}
