package repo.Queue.lc362;

import java.util.ArrayList;
import java.util.List;

public class Test362 {

    public static String runTest(String input) {
        int mid = input.indexOf("][");
        String opsPart = input.substring(0, mid + 1);
        String argsPart = input.substring(mid + 1);

        String[] ops = parseOps(opsPart);
        String[][] args = parseArgs(argsPart);

        List<String> out = new ArrayList<>();
        Solution362.HitCounter hc = null;

        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "HitCounter" -> {
                    hc = new Solution362.HitCounter();
                    out.add("null");
                }
                case "hit" -> {
                    int t = Integer.parseInt(args[i][0]);
                    hc.hit(t);
                    out.add("null");
                }
                case "getHits" -> {
                    int t = Integer.parseInt(args[i][0]);
                    out.add(String.valueOf(hc.getHits(t)));
                }
                default -> throw new IllegalArgumentException("Unknown op: " + ops[i]);
            }
        }

        return out.toString();
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
                    for (int k = 0; k < parts.length; k++) parts[k] = parts[k].trim();
                    list.add(parts);
                }
                i = j + 1;
            } else {
                i++;
            }
        }
        return list.toArray(new String[0][]);
    }
}
