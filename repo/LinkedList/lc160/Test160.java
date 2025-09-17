package repo.LinkedList.lc160;

import java.util.*;

public class Test160 {

    public static String runTest(String input) {
        int intersectVal = extractInt(input, "intersectVal");
        int skipA = extractInt(input, "skipA");
        int skipB = extractInt(input, "skipB");
        int[] arrA = parseArray(extractArray(input, "listA"));
        int[] arrB = parseArray(extractArray(input, "listB"));

        NodePair pair = buildLists(arrA, arrB, skipA, skipB, intersectVal);

        Solution160 sol = new Solution160();
        Solution160.ListNode node = sol.getIntersectionNode(pair.headA, pair.headB);

        if (node == null) return "No intersection";
        return "Intersected at " + node.val;
    }

    private static int extractInt(String s, String key) {
        String regex = key + "\\s*=\\s*(-?\\d+)";
        var m = java.util.regex.Pattern.compile(regex).matcher(s);
        return m.find() ? Integer.parseInt(m.group(1)) : 0;
    }

    private static String extractArray(String s, String key) {
        String regex = key + "\\s*=\\s*\\[(.*?)]";
        var m = java.util.regex.Pattern.compile(regex).matcher(s);
        return m.find() ? m.group(1) : "";
    }

    private static int[] parseArray(String csv) {
        if (csv == null || csv.isEmpty()) return new int[0];
        String[] parts = csv.split(",");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i].trim());
        }
        return arr;
    }

    private static class NodePair {
        Solution160.ListNode headA, headB;
        NodePair(Solution160.ListNode a, Solution160.ListNode b) { headA = a; headB = b; }
    }

    private static NodePair buildLists(int[] arrA, int[] arrB, int skipA, int skipB, int intersectVal) {
        Solution160.ListNode headA = buildList(arrA);
        Solution160.ListNode nodeAAtSkipA = headA;
        for (int i = 0; i < skipA && nodeAAtSkipA != null; i++) nodeAAtSkipA = nodeAAtSkipA.next;

        if (intersectVal == 0 || nodeAAtSkipA == null) {
            return new NodePair(headA, buildList(arrB));
        }

        Solution160.ListNode headB = null, tailB = null;
        for (int i = 0; i < skipB && i < arrB.length; i++) {
            Solution160.ListNode n = new Solution160.ListNode(arrB[i]);
            if (headB == null) headB = n; else tailB.next = n;
            tailB = n;
        }

        if (headB == null) {
            headB = nodeAAtSkipA;
        } else {
            tailB.next = nodeAAtSkipA;
        }

        return new NodePair(headA, headB);
    }

    private static Solution160.ListNode buildList(int[] arr) {
        Solution160.ListNode dummy = new Solution160.ListNode(0);
        Solution160.ListNode curr = dummy;
        for (int v : arr) {
            curr.next = new Solution160.ListNode(v);
            curr = curr.next;
        }
        return dummy.next;
    }
}
