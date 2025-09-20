package repo.Stack.lc1209;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Solution1209 {
    public String removeDuplicates(String s, int k) {

        LinkedList<Character> str = new LinkedList<>();
        Deque<Integer> dequeNum = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (str.isEmpty()) {
                str.add(c);
                dequeNum.push(1);
            } else if (str.getLast() == c) {
                if (dequeNum.peek() + 1 == k) {
                    for (int j = 0; j < k-1; j++) {
                        str.removeLast();
                    }
                    dequeNum.poll();
                } else {
                    str.add(c);
                    dequeNum.push(dequeNum.poll()+1);
                }
            } else {
                str.add(c);
                dequeNum.push(1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : str) sb.append(c);
        return sb.toString();
    }
}
