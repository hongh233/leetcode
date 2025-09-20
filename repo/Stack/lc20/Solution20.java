package repo.Stack.lc20;
import java.util.Stack;

public class Solution20 {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (curr == '(' || curr == '{' || curr == '[') {
                stack.push(curr);
            } else if (curr == ')') {
                if (stack.isEmpty()) return false;
                if (stack.peek() != '(') {
                    break;
                } else {
                    stack.pop();
                }
            } else if (curr == ']') {
                if (stack.isEmpty()) return false;
                if (stack.peek() != '[') {
                    break;
                } else {
                    stack.pop();
                }
            } else if (curr == '}') {
                if (stack.isEmpty()) return false;
                if (stack.peek() != '{') {
                    break;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}
