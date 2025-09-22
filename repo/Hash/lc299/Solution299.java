// time: O(n), pass over string twice
// space: O(1), store at mose 10 digits

package repo.Hash.lc299;
import java.util.HashMap;

public class Solution299 {
    public String getHint(String secret, String guess) {

        int A = 0;
        int B = 0;
        // k: digit, v: amount
        HashMap<Character, Integer> h = new HashMap<>();

        int len = secret.length();
        for (int i = 0; i < len; i++) {
            char curr_secret = secret.charAt(i);
            char curr_guess = guess.charAt(i);
            if (curr_secret == curr_guess) {
                A++;
            } else {
                h.put(curr_secret, h.getOrDefault(curr_secret, 0) + 1);
            }
        }

        for (int i = 0; i < len; i++) {
            char curr_secret = secret.charAt(i);
            char curr_guess = guess.charAt(i);
            if (curr_secret != curr_guess) {
                if (h.containsKey(curr_guess)) {
                    B++;
                    if (h.get(curr_guess) == 1) {
                        h.remove(curr_guess);
                    } else {
                        h.put(curr_guess, h.get(curr_guess) - 1);
                    }
                }
            }
        }

        return A + "A" + B + "B";
    }
}
