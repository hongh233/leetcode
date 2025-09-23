// hashmap + pq + greedy

package repo.Heap.lc767;
import java.util.*;

public class Solution767 {

    class Pair {
        char digit;
        int freq;
        Pair(char c, int freq) {
            this.digit = c;
            this.freq = freq;
        }
    }
    public String reorganizeString(String s) {

        char[] arr = new char[s.length()];
        HashMap<Character, Integer> hm = new HashMap<>(); // k: char; v: freq
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            arr[i] = curr;
            hm.put(curr, hm.getOrDefault(curr, 0) + 1);
        }
        Arrays.sort(arr);


        PriorityQueue<Pair> pq = new PriorityQueue<>(
                new Comparator<Pair>() {
                    @Override
                    public int compare(Pair o1, Pair o2) {
                        return o2.freq-o1.freq;
                    }
                }
        );
        for (Map.Entry<Character, Integer> map : hm.entrySet()) {
            pq.offer(new Pair(map.getKey(), map.getValue()));
        }

        if (pq.peek().freq > (s.length()+1) / 2) {
            return "";
        }

        char[] ans = new char[s.length()];
        int i = 0;

        // take two elems at a time
        while (pq.size() >= 2) {
            Pair a = pq.poll();
            ans[i] = a.digit;
            i++;
            Pair b = pq.poll();
            ans[i] = b.digit;
            i++;

            a.freq--;
            if (a.freq > 0) pq.add(a);
            b.freq--;
            if (b.freq > 0) pq.add(b);
        }
        if (!pq.isEmpty()) {
            ans[i] = pq.poll().digit;
        }

        return String.valueOf(ans);
    }
}
