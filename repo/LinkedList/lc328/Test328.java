package repo.LinkedList.lc328;

public class Test328 {

    public static String runTest(String input) {
        int[] arr = parseArray(input);
        Solution328.ListNode head = buildList(arr);

        Solution328 sol = new Solution328();
        Solution328.ListNode newHead = sol.oddEvenList(head);

        return listToString(newHead);
    }

    private static int[] parseArray(String s) {
        s = s.trim();
        if (s.startsWith("[")) s = s.substring(1);
        if (s.endsWith("]")) s = s.substring(0, s.length() - 1);
        if (s.isEmpty()) return new int[0];
        String[] parts = s.split(",");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i].trim());
        }
        return arr;
    }

    private static Solution328.ListNode buildList(int[] arr) {
        Solution328.ListNode dummy = new Solution328.ListNode(0);
        Solution328.ListNode curr = dummy;
        for (int v : arr) {
            curr.next = new Solution328.ListNode(v);
            curr = curr.next;
        }
        return dummy.next;
    }

    private static String listToString(Solution328.ListNode head) {
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
