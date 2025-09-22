// sort each sorted word as key and store into Hashmap

package repo.Hash.lc49;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> li = new LinkedList<>();
        HashMap<String, LinkedList<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String str_sorted = Arrays.toString(arr);
            if (map.containsKey(str_sorted)) {
                LinkedList<String> oldList = map.get(str_sorted);
                oldList.add(str);
            } else {
                LinkedList<String> newList = new LinkedList<>();
                newList.add(str);
                map.put(str_sorted, newList);
            }
        }

        // map.values() --> Collection
        return new LinkedList<>(map.values());
    }
}
