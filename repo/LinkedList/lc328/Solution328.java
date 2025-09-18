package repo.LinkedList.lc328;

public class Solution328 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode root1 = head;
        ListNode root2 = head.next;
        ListNode p1 = root1;
        ListNode p2 = root2;

        while (true) {
            ListNode p1_next = p1.next.next;
            ListNode p2_next = p2.next.next;
            p1.next = p1_next;
            p2.next = p2_next;
            p1 = p1_next;
            p2 = p2_next;

            if (p2 == null || p2.next == null) {
                // odd or even
                break;
            }
        }

        p1.next = root2;
        return head;
    }
}