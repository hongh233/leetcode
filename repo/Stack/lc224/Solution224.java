package repo.Stack.lc224;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution224 {
    public int calculate(String s) {
        int res = 0, n = s.length(), i = 0;
        Deque<Integer> signs = new ArrayDeque<>();
        signs.push(1);
        int sign = 1;

        while (i < n) {
            char c = s.charAt(i);
            if (c == ' ') { i++; continue; }

            if (c == '+') {
                sign = signs.peek(); i++;
            } else if (c == '-') {
                sign = -signs.peek(); i++;
            } else if (c == '(') {
                signs.push(sign);
                i++;
            } else if (c == ')') {
                signs.pop();
                i++;
            } else if (Character.isDigit(c)) {
                int num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                res += sign * num;
            } else {
                i++;
            }
        }
        return res;
    }
}
