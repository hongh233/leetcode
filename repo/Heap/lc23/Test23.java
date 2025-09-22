package repo.Heap.lc23;

import java.util.ArrayList;
import java.util.List;

public class Test23 {
    public static String runTest(String input) {
        int[][] arr2d = parse2DArray(extractArray2D(input, "lists"));
        Solution23.ListNode[] lists = new Solution23.ListNode[arr2d.length];
        for (int i = 0; i < arr2d.length; i++) {
            lists[i] = buildList(arr2d[i]);
        }

        Solution23 sol = new Solution23();
        Solution23.ListNode head = sol.mergeKLists(lists);

        return listToString(head);
    }

    private static String extractArray2D(String s, String key) {
        int keyIdx = s.indexOf(key);
        if (keyIdx < 0) return "";
        int eq = s.indexOf('=', keyIdx);
        if (eq < 0) return "";
        int i = eq + 1, n = s.length();

        while (i < n && Character.isWhitespace(s.charAt(i))) i++;
        if (i >= n || s.charAt(i) != '[') return "";
        int start = i;

        int depth = 0;
        while (i < n) {
            char c = s.charAt(i++);
            if (c == '[') depth++;
            else if (c == ']') {
                depth--;
                if (depth == 0) {
                    return s.substring(start, i);
                }
            }
        }
        return "";
    }

    private static int[][] parse2DArray(String s) {
        s = s == null ? "" : s.trim();
        if (s.isEmpty() || !s.startsWith("[")) return new int[0][0];
        if (s.equals("[]")) return new int[0][0];

        List<int[]> rows = new ArrayList<>();
        int depth = 0, rowStart = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                depth++;
                if (depth == 2) rowStart = i + 1;
            } else if (c == ']') {
                if (depth == 2 && rowStart != -1) {
                    String inside = s.substring(rowStart, i).trim();
                    if (inside.isEmpty()) {
                        rows.add(new int[0]);
                    } else {
                        String[] parts = inside.split(",");
                        int[] row = new int[parts.length];
                        for (int k = 0; k < parts.length; k++) {
                            row[k] = Integer.parseInt(parts[k].trim());
                        }
                        rows.add(row);
                    }
                    rowStart = -1;
                }
                depth--;
            }
        }
        return rows.toArray(new int[0][]);
    }

    private static Solution23.ListNode buildList(int[] arr) {
        Solution23.ListNode dummy = new Solution23.ListNode(0);
        Solution23.ListNode cur = dummy;
        for (int v : arr) {
            cur.next = new Solution23.ListNode(v);
            cur = cur.next;
        }
        return dummy.next;
    }

    private static String listToString(Solution23.ListNode head) {
        if (head == null) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Solution23.ListNode cur = head;
        boolean first = true;
        while (cur != null) {
            if (!first) sb.append(',');
            sb.append(cur.val);
            first = false;
            cur = cur.next;
        }
        sb.append(']');
        return sb.toString();
    }
}
