package repo.Stack.lc1472;

import java.util.ArrayList;
import java.util.List;

public class Test1472 {

    public static String runTest(String input) {
        int mid = input.indexOf("][");
        String opsPart = input.substring(0, mid + 1);
        String argsPart = input.substring(mid + 1);

        String[] ops = parseOps(opsPart);
        String[][] args = parseArgs(argsPart);

        List<String> out = new ArrayList<>();
        Solution1472.BrowserHistory bh = null;

        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "BrowserHistory" -> {
                    String homepage = args[i][0];
                    bh = new Solution1472.BrowserHistory(homepage);
                    out.add("null");
                }
                case "visit" -> {
                    bh.visit(args[i][0]);
                    out.add("null");
                }
                case "back" -> {
                    int steps = Integer.parseInt(args[i][0]);
                    out.add(bh.back(steps));
                }
                case "forward" -> {
                    int steps = Integer.parseInt(args[i][0]);
                    out.add(bh.forward(steps));
                }
                default -> throw new IllegalArgumentException("Unknown op: " + ops[i]);
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

    private static String[][] parseArgs(String s) {
        s = s.trim();
        if (s.startsWith("[")) s = s.substring(1);
        if (s.endsWith("]")) s = s.substring(0, s.length() - 1);

        List<String[]> list = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '[') {
                int j = s.indexOf(']', i);
                String inside = s.substring(i + 1, j).trim();
                if (inside.isEmpty()) {
                    list.add(new String[0]);
                } else {
                    String[] parts = inside.split(",");
                    for (int k = 0; k < parts.length; k++) {
                        parts[k] = parts[k].trim();
                    }
                    list.add(parts);
                }
                i = j + 1;
            } else {
                i++;
            }
        }
        return list.toArray(new String[0][]);
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
