package repo.Stack.lc155;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

public class Solution155 {

    public static class MinStack {

        static class Node {
            int val;
            int min;
            Node next;
            Node () {}
            Node (int val, int min, Node next) {
                this.val = val;
                this.min = min;
                this.next = next;
            }
        }

        Node head;

        public MinStack() {
            head = null;
        }

        public void push(int val) {
            if (head == null) {
                head = new Node(val, val, head);
            } else {
                head = new Node(val, Math.min(val, head.min), head);
            }
        }

        public void pop() {
            Node nextHead = head.next;
            if (head.next != null) {
                head.next = null;
            }
            head = nextHead;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }
    }
}
