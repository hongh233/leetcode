package repo.Queue.lc281;

import java.util.*;

public class Test281 {

    public static String runTest(String input) {
        input = input.trim();

        int[] a1 = parseArrayByKey(input, "v1");
        int[] a2 = parseArrayByKey(input, "v2");
        int[] a3 = parseArrayByKey(input, "v3");

        List<Integer> out = new ArrayList<>();

        if (a3 != null) {
            List<List<Integer>> vectors = new ArrayList<>();
            vectors.add(toList(a1));
            vectors.add(toList(a2));
            vectors.add(toList(a3));
            Solution281.ZigzagIterator it = new Solution281.ZigzagIterator(vectors);
            while (it.hasNext()) out.add(it.next());
        } else {
            Solution281.ZigzagIterator it = new Solution281.ZigzagIterator(toList(a1), toList(a2));
            while (it.hasNext()) out.add(it.next());
        }

        return toCompactArrayString(out);
    }

    private static int[] parseArrayByKey(String s, String key) {
        String regex = key + "\\s*=\\s*\\[(.*?)]";
        var m = java.util.regex.Pattern.compile(regex).matcher(s);
        if (!m.find()) {
            return null;
        }
        String inside = m.group(1).trim();
        if (inside.isEmpty()) return new int[0];
        String[] parts = inside.split(",");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) arr[i] = Integer.parseInt(parts[i].trim());
        return arr;
    }

    private static List<Integer> toList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        if (arr != null) {
            for (int v : arr) list.add(v);
        }
        return list;
    }

    private static String toCompactArrayString(List<Integer> a) {
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
