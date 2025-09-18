package repo.Queue.lc225;

import java.util.*;

public class Test225 {

    public static String runTest(String input) {
        int mid = input.indexOf("][");
        String opsPart = input.substring(0, mid + 1);
        String argsPart = input.substring(mid + 1);

        String[] ops = parseOps(opsPart);
        String[][] args = parseArgs(argsPart);

        List<String> results = new ArrayList<>();
        Solution225.MyStack stack = null;

        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "MyStack" -> {
                    stack = new Solution225.MyStack();
                    results.add("null");
                }
                case "push" -> {
                    int val = Integer.parseInt(args[i][0]);
                    stack.push(val);
                    results.add("null");
                }
                case "pop" -> results.add(String.valueOf(stack.pop()));
                case "top" -> results.add(String.valueOf(stack.top()));
                case "empty" -> results.add(String.valueOf(stack.empty()));
            }
        }

        return results.toString();
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

        List<String[]> args = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '[') {
                int j = s.indexOf(']', i);
                String inside = s.substring(i + 1, j).trim();
                if (inside.isEmpty()) {
                    args.add(new String[0]);
                } else {
                    String[] parts = inside.split(",");
                    for (int k = 0; k < parts.length; k++) parts[k] = parts[k].trim();
                    args.add(parts);
                }
                i = j + 1;
            } else {
                i++;
            }
        }
        return args.toArray(new String[0][]);
    }
}
