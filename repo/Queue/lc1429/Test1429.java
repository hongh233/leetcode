package repo.Queue.lc1429;

import java.util.ArrayList;
import java.util.List;

public class Test1429 {
    public static String runTest(String input) {
        int mid = input.indexOf("][");
        String opsPart = input.substring(0, mid + 1);
        String argsPart = input.substring(mid + 1);

        String[] ops = parseOps(opsPart);
        List<String> argGroups = splitTopLevelArgs(argsPart);

        List<String> out = new ArrayList<>();
        Solution1429.FirstUnique fu = null;

        for (int i = 0; i < ops.length; i++) {
            String op = ops[i];
            String rawArg = i < argGroups.size() ? argGroups.get(i) : "[]";

            switch (op) {
                case "FirstUnique": {
                    int[] nums = parseFirstUniqueConstructorArg(rawArg);
                    fu = new Solution1429.FirstUnique(nums);
                    out.add("null");
                    break;
                }
                case "add": {
                    int v = parseSingleIntArg(rawArg);
                    fu.add(v);
                    out.add("null");
                    break;
                }
                case "showFirstUnique": {
                    int ans = fu.showFirstUnique();
                    out.add(String.valueOf(ans));
                    break;
                }
                default:
                    throw new IllegalArgumentException("Unknown op: " + op);
            }
        }

        return toCompactArrayString(out);
    }

    private static String[] parseOps(String s) {
        s = s.trim();
        if (s.startsWith("[")) s = s.substring(1);
        if (s.endsWith("]")) s = s.substring(0, s.length() - 1);
        if (s.isEmpty()) return new String[0];
        String[] parts = s.split(",");
        for (int i = 0; i < parts.length; i++) parts[i] = parts[i].trim();
        return parts;
    }

    private static List<String> splitTopLevelArgs(String s) {
        s = s.trim();
        if (s.startsWith("[")) s = s.substring(1);
        if (s.endsWith("]")) s = s.substring(0, s.length() - 1);

        List<String> res = new ArrayList<>();
        int depth = 0;
        int start = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                if (depth == 0) start = i;
                depth++;
            } else if (c == ']') {
                depth--;
                if (depth == 0 && start != -1) {
                    res.add(s.substring(start, i + 1).trim());
                    start = -1;
                }
            }
        }
        return res;
    }

    private static int[] parseFirstUniqueConstructorArg(String raw) {
        String t = raw.trim();
        if (!t.startsWith("[") || !t.endsWith("]")) return new int[0];
        t = t.substring(1, t.length() - 1).trim();
        if (t.isEmpty()) return new int[0];
        if (t.equals("[]")) return new int[0];
        if (t.startsWith("[") && t.endsWith("]")) {
            t = t.substring(1, t.length() - 1).trim();
            if (t.isEmpty()) return new int[0];
            String[] parts = t.split(",");
            int[] arr = new int[parts.length];
            for (int i = 0; i < parts.length; i++) arr[i] = Integer.parseInt(parts[i].trim());
            return arr;
        }
        return parseIntCsv(t);
    }

    private static int parseSingleIntArg(String raw) {
        String t = raw.trim();
        if (t.startsWith("[")) t = t.substring(1);
        if (t.endsWith("]")) t = t.substring(0, t.length() - 1);
        t = t.trim();
        if (t.isEmpty()) return 0;
        return Integer.parseInt(t);
    }

    private static int[] parseIntCsv(String csv) {
        csv = csv.trim();
        if (csv.isEmpty()) return new int[0];
        String[] parts = csv.split(",");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) arr[i] = Integer.parseInt(parts[i].trim());
        return arr;
    }

    private static String toCompactArrayString(List<String> a) {
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
