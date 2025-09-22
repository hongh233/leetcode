package repo.Hash.lc350;

import java.util.HashMap;
import java.util.LinkedList;

public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {

        // key: num, value: amount
        HashMap<Integer, Integer> h1 = new HashMap<>();

        for (int num : nums1) {
            h1.put(num, h1.getOrDefault(num, 0) + 1);
        }

        LinkedList<Integer> li = new LinkedList<>();
        for (int num: nums2) {
            if (h1.containsKey(num)) {
                li.add(num);
                if (h1.get(num) == 1) {
                    h1.remove(num);
                } else {
                    h1.put(num, h1.get(num) - 1);
                }
            }
        }

        int[] result = new int[li.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = li.removeFirst();
        }

        return result;
    }
}
