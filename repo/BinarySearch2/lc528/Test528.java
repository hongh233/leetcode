package repo.BinarySearch2.lc528;

import java.util.ArrayList;
import java.util.List;

public class Test528 {

    public static String runTest(String input) {
        int mid = input.indexOf("][");
        String opsPart = input.substring(0, mid + 1);
        String argsPart = input.substring(mid + 1);

        String[] ops = parseOps(opsPart);
        String[][] args = parseArgs(argsPart);

        List<String> out = new ArrayList<>();
        Solution528.Solution obj = null;

        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "Solution" -> {
                    int[] w = parseArray(extractInnerArray(args[i].length == 0 ? "" : args[i][0]));
                    obj = new Solution528.Solution(w);
                    out.add("null");
                }
                case "pickIndex" -> {
                    int idx = obj.pickIndex();
                    out.add(String.valueOf(idx));
                }
                default -> throw new IllegalArgumentException("Unknown op: " + ops[i]);
            }
        }

        return joinNoSpaces(out);
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

    private static String[][] parseArgs(String s) {
        s = s.trim();
        if (s.startsWith("[")) s = s.substring(1);
        if (s.endsWith("]")) s = s.substring(0, s.length() - 1);

        List<String[]> list = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '[') {
                int j = findMatchingBracket(s, i);
                String inside = s.substring(i + 1, j).trim();
                if (inside.isEmpty()) list.add(new String[0]);
                else {
                    list.add(new String[]{inside});
                }
                i = j + 1;
            } else {
                i++;
            }
        }
        return list.toArray(new String[0][]);
    }

    private static int findMatchingBracket(String s, int start) {
        int depth = 0;
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') depth++;
            else if (c == ']') {
                depth--;
                if (depth == 0) return i;
            }
        }
        return s.length() - 1;
    }

    private static String extractInnerArray(String raw) {
        raw = raw == null ? "" : raw.trim();
        if (raw.isEmpty()) return "";
        if (raw.startsWith("[[")) raw = raw.substring(2);
        if (raw.endsWith("]]")) raw = raw.substring(0, raw.length() - 2);
        if (raw.startsWith("[")) raw = raw.substring(1);
        if (raw.endsWith("]")) raw = raw.substring(0, raw.length() - 1);
        return raw.trim();
    }

    private static int[] parseArray(String csv) {
        csv = csv == null ? "" : csv.trim();
        if (csv.isEmpty()) return new int[0];
        String[] parts = csv.split(",");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) arr[i] = Integer.parseInt(parts[i].trim());
        return arr;
    }

    private static String joinNoSpaces(List<String> list) {
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
