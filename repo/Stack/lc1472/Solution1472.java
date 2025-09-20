package repo.Stack.lc1472;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */

public class Solution1472 {
    public static class BrowserHistory {

        Deque<String> s1 = new ArrayDeque<>();
        Deque<String> s2 = new ArrayDeque<>();

        public BrowserHistory(String homepage) {
            this.s1.push(homepage);
        }

        public void visit(String url) {
            s1.push(url);
            s2.clear();
        }

        public String back(int steps) {
            for (int i = 0; i < steps; i++) {
                if (s1.size() > 1) {
                    s2.push(s1.pop());
                }
            }
            return s1.peek();
        }

        public String forward(int steps) {
            for (int i = 0; i < steps; i++) {
                if (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
            }
            return s1.peek();
        }
    }
}
