// use hash

package repo.Hash.lc1;
import java.util.HashMap;

public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> h = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (h.isEmpty()) {
                h.put(curr, i);
            } else if (h.containsKey(target - curr)) {
                result[0] = Math.min(i, h.get(target - curr));
                result[1] = Math.max(i, h.get(target - curr));
                return result;
            } else {
                h.put(curr, i);
            }
        }
        return null;
    }
}
