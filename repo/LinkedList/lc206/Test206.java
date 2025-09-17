package repo.LinkedList.lc206;

public class Test206 {

    public static String runTest(String input) {

        int[] arr = parseArray(input);
        Solution206.ListNode head = buildList(arr);
        Solution206 sol = new Solution206();
        Solution206.ListNode newHead = sol.reverseList(head);
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

    private static Solution206.ListNode buildList(int[] arr) {
        Solution206.ListNode dummy = new Solution206.ListNode(0);
        Solution206.ListNode curr = dummy;
        for (int v : arr) {
            curr.next = new Solution206.ListNode(v);
            curr = curr.next;
        }
        return dummy.next;
    }

    private static String listToString(Solution206.ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Solution206.ListNode curr = head;
        boolean first = true;
        while (curr != null) {
            if (!first) sb.append(",");
            sb.append(curr.val);
            first = false;
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
