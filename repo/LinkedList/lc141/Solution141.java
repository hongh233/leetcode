package repo.LinkedList.lc141;

public class Solution141 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        if (fast == null || fast.next == null) {
            return false;
        }

        while (true) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
            if (fast == null || fast.next == null) {
                return false;
            }
        }

    }
}
