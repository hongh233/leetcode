package repo.Stack.lc735;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution735 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int ast : asteroids) {
            if (deque.isEmpty()) {
                deque.push(ast);
            } else if (ast > 0 || (ast < 0 && deque.peek() < 0)) {
                deque.push(ast);
            } else { // deque.peek() > 0 && asteroids[i] < 0
                while (true) {
                    if (deque.peek() + ast > 0) {
                        break;
                    } else if (deque.peek() + ast == 0) {
                        deque.pop();
                        break;
                    } else if (deque.peek() < 0) { // handle [-2,-2,1,-2]
                        deque.push(ast);
                        break;
                    } else {
                        deque.pop();
                    }
                    if (deque.isEmpty()) {
                        deque.push(ast);
                        break;
                    }
                }
            }
        }

        int dq_size = deque.size();
        int[] result = new int[deque.size()];
        for (int i = 0; i < dq_size; i++) {
            result[dq_size-i-1] = deque.pop();
        }
        return result;
    }

}
