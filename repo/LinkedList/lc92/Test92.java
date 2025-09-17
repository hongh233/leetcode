package repo.LinkedList.lc92;

public class Test92 {

    public static String runTest(String input) {
        int[] arr = parseArray(extractArray(input, "head"));
        int left  = extractInt(input, "left");
        int right = extractInt(input, "right");

        Solution92.ListNode head = buildList(arr);

        Solution92 sol = new Solution92();
        Solution92.ListNode newHead = sol.reverseBetween(head, left, right);

        return listToString(newHead);
    }

    private static String extractArray(String s, String key) {
        String regex = key + "\\s*=\\s*\\[(.*?)]";
        var m = java.util.regex.Pattern.compile(regex).matcher(s);
        return m.find() ? m.group(1) : "";
    }

    private static int extractInt(String s, String key) {
        String regex = key + "\\s*=\\s*(-?\\d+)";
        var m = java.util.regex.Pattern.compile(regex).matcher(s);
        return m.find() ? Integer.parseInt(m.group(1)) : 0;
    }

    private static int[] parseArray(String csv) {
        if (csv == null || csv.isEmpty()) return new int[0];
        String[] parts = csv.split(",");
        int[] a = new int[parts.length];
        for (int i = 0; i < parts.length; i++) a[i] = Integer.parseInt(parts[i].trim());
        return a;
    }

    private static Solution92.ListNode buildList(int[] arr) {
        Solution92.ListNode dummy = new Solution92.ListNode(0);
        Solution92.ListNode cur = dummy;
        for (int v : arr) {
            cur.next = new Solution92.ListNode(v);
            cur = cur.next;
        }
        return dummy.next;
    }

    private static String listToString(Solution92.ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        boolean first = true;
        while (head != null) {
            if (!first) sb.append(',');
            sb.append(head.val);
            first = false;
            head = head.next;
        }
        sb.append(']');
        return sb.toString();
    }
}
