package repo.Stack.lc1249;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1249 {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder(s);

        // annotate redundant ')'
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                deque.push(i);
            } else if (c == ')') {
                if (!deque.isEmpty()) {
                    deque.pop();
                } else {
                    sb.setCharAt(i, '#');
                }
            }
        }

        // annotate redundant '('
        while (!deque.isEmpty()) {
            sb.setCharAt(deque.pop(), '#');
        }

        // delete char with '#' annotation
        int len = sb.length();
        for (int i = 0; i < len; i++) {
            if (sb.charAt(i) == '#') {
                sb.deleteCharAt(i);
                i--; len--; // handle index changing when deleting element
            }
        }
        return sb.toString();
    }
}
