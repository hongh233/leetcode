package repo.LinkedList.lc141;

public class Test141 {

    public static String runTest(String input) {
        int l = input.indexOf('[');
        int r = input.indexOf(']');
        int[] arr = parseArray(slice(input, l + 1, r));

        int pos = extractInt(input, "pos");
        Solution141.ListNode head = buildListWithCycle(arr, pos);
        Solution141 sol = new Solution141();
        boolean has = sol.hasCycle(head);

        return String.valueOf(has);
    }

    private static String slice(String s, int start, int end) {
        if (start < 0 || end < 0 || end < start || start > s.length()) return "";
        return s.substring(start, Math.min(end, s.length())).trim();
    }

    private static int[] parseArray(String csv) {
        if (csv == null || csv.isEmpty()) return new int[0];
        String[] parts = csv.split(",");
        int[] a = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            a[i] = Integer.parseInt(parts[i].trim());
        }
        return a;
    }

    private static int extractInt(String s, String key) {
        String regex = key + "\\s*=\\s*(-?\\d+)";
        var m = java.util.regex.Pattern.compile(regex).matcher(s);
        return m.find() ? Integer.parseInt(m.group(1)) : 0;
    }

    private static Solution141.ListNode buildListWithCycle(int[] arr, int pos) {
        Solution141.ListNode dummy = new Solution141.ListNode(0);
        Solution141.ListNode curr = dummy;
        Solution141.ListNode cycleEntry = null;

        for (int i = 0; i < arr.length; i++) {
            curr.next = new Solution141.ListNode(arr[i]);
            curr = curr.next;
            if (i == pos) cycleEntry = curr;
        }

        if (pos >= 0 && cycleEntry != null) {
            curr.next = cycleEntry;
        }

        return dummy.next;
    }
}
