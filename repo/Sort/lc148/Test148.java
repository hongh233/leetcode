package repo.Sort.lc148;

public class Test148 {
    public static String runTest(String input) {
        // Extract the content inside brackets (e.g., head = [4,2,1,3] → "4,2,1,3")
        String listStr = input.replaceAll(".*\\[", "").replaceAll("].*", "").trim();
        if (listStr.isEmpty()) return "[]";

        // Parse into an integer array and build the linked list
        String[] tokens = listStr.split(",");
        Solution148.ListNode dummy = new Solution148.ListNode(0);
        Solution148.ListNode curr = dummy;
        for (String token : tokens) {
            int val = Integer.parseInt(token.trim());
            curr.next = new Solution148.ListNode(val);
            curr = curr.next;
        }

        // Call the sorting function
        Solution148 solution = new Solution148();
        Solution148.ListNode sorted = solution.sortList(dummy.next);

        // Convert the sorted linked list back to string format "[a,b,c]"
        return listToString(sorted);
    }

    private static String listToString(Solution148.ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append(",");
            head = head.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
