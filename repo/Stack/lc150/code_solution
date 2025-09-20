package repo.Stack.lc150;
import java.util.Stack;

public class Solution150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> q = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") ||s.equals("/")) {
                int right = q.pop();
                int left = q.pop();
                int result = 0;
                switch (s) {
                    case "+": result = left + right; break;
                    case "-": result = left - right; break;
                    case "*": result = left * right; break;
                    case "/": result = left / right; break;
                    default:
                }
                q.push(result);
            } else {
                q.push(Integer.parseInt(s));
            }
        }
        return q.pop();
    }
}
