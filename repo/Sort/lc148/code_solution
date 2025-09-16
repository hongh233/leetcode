package repo.Sort.lc148;

public class Solution148 {

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

    public ListNode sortList(ListNode head) {

        // base case
        if (head == null || head.next == null) {
            return head;
        }

        // find mid node
        ListNode mid = getMidNode(head);

        // divide
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;

        ListNode leftSorted = sortList(left);
        ListNode rightSorted = sortList(right);

        // conquer
        return mergeSort(leftSorted, rightSorted);
    }

    public ListNode getMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode mergeSort(ListNode left, ListNode right) {
        ListNode result = new ListNode(42);
        ListNode curr = result;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                curr.next = new ListNode(left.val);
                left = left.next;
            } else {
                curr.next = new ListNode(right.val);
                right = right.next;
            }
            curr = curr.next;
        }
        curr.next = (left != null) ? left : right;
        return result.next;
    }
}