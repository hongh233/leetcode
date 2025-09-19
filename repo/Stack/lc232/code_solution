// use 2 Stacks for follow up: each operation is amortized O(1)

package repo.Stack.lc232;
import java.util.Stack;

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

public class Solution232 {
    public static class MyQueue {

        Stack<Integer> in;
        Stack<Integer> out;

        public MyQueue() {
            this.in = new Stack<>();
            this.out = new Stack<>();
        }

        public void push(int x) {
            in.push(x);
        }

        public int pop() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            return out.pop();
        }

        public int peek() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            return out.peek();
        }

        public boolean empty() {
            return in.size() + out.size() == 0;
        }
    }
}
