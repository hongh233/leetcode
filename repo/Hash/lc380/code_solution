package repo.Hash.lc380;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
public class Solution380 {
    public static class RandomizedSet {

        ArrayList<Integer> arr;
        HashMap<Integer, Integer> map;
        Random rand = new Random();

        public RandomizedSet() {
            this.arr = new ArrayList<>();
            this.map = new HashMap<>();
        }

        public boolean insert(int val) {
            if (!map.containsKey(val)) {
                arr.add(val);
                map.put(val, arr.size()-1);
                return true;
            } else {
                return false;
            }
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            } else {
                int removeIndex = (int) map.get(val);
                int lastElemValue = arr.get(arr.size()-1);
                arr.set(removeIndex, lastElemValue);
                map.put(lastElemValue, removeIndex);
                arr.remove(arr.size()-1);
                map.remove(val);
                return true;
            }
        }

        public int getRandom() {
            return arr.get(rand.nextInt(0, arr.size()));
        }
    }
}
