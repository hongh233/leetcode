// use Heap
// time: O(Nlogk); space: O(k)

package repo.Heap.lc23;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution23 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                new Comparator<ListNode>() {
                    @Override
                    public int compare(ListNode o1, ListNode o2) {
                        return o1.val-o2.val;
                    }
                }
        );
        ListNode head = new ListNode(0);
        ListNode tail = head;

        // init pq: put all heads into pq
        for (ListNode li : lists) {
            if (li != null) {
                pq.add(li);
            }
        }

        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            if (minNode.next != null) {
                pq.add(minNode.next);
            }
            tail.next = minNode;
            tail = tail.next;
        }

        return head.next;
    }

}
