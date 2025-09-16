package repo.Sort.lc27;

import java.util.*;
import java.util.regex.*;

public class Test27 {

    public static String runTest(String input) {
        Pattern pNums = Pattern.compile("nums\\s*=\\s*\\[(.*?)]");
        Matcher mNums = pNums.matcher(input);
        int[] nums = new int[0];
        if (mNums.find()) {
            String[] parts = mNums.group(1).trim().split(",");
            if (parts.length == 1 && parts[0].isEmpty()) {
                nums = new int[0];
            } else {
                nums = Arrays.stream(parts).map(String::trim)
                        .mapToInt(Integer::parseInt).toArray();
            }
        }

        Pattern pVal = Pattern.compile("val\\s*=\\s*(-?\\d+)");
        Matcher mVal = pVal.matcher(input);
        int val = 0;
        if (mVal.find()) {
            val = Integer.parseInt(mVal.group(1));
        }

        Solution27 sol = new Solution27();
        int res = sol.removeElement(nums, val);

        return String.valueOf(res);
    }
}
