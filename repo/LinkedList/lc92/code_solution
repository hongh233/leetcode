package repo.LinkedList.lc92;

public class Solution92 {
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        left--;
        right--;

        // find left node and the node before left node
        ListNode leftNode = head;
        ListNode beforeLeftNode = null;
        int idx = 0;
        while (idx != left) {
            beforeLeftNode = leftNode;
            leftNode = leftNode.next;
            idx++;
        }

        // find right node and the node after right node
        ListNode rightNode= leftNode;
        ListNode afterRightNode = null;
        while (idx != right) {
            rightNode = rightNode.next;
            idx++;
        }
        afterRightNode = rightNode.next;

        // This is just implementation of reverse linked list
        // reverse the partial list: leftNode to rightNode
        ListNode p1 = null;
        ListNode p2 = leftNode;
        while (true) {
            ListNode nextNode = p2.next;
            p2.next = p1;
            if (nextNode == afterRightNode) {
                break;
            }
            p1 = p2;
            p2 = nextNode;
        }

        // put left, partial list, right together
        if (beforeLeftNode == null) {
            leftNode.next = afterRightNode;
            return rightNode;
        } else {
            beforeLeftNode.next = rightNode;
            leftNode.next = afterRightNode;
            return head;
        }

    }
}