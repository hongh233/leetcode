package repo.Sort.lc215;

public class Test215 {

    public static String runTest(String input) {

        int[] nums = new int[0];
        int k = 0;

        int numsStart = input.indexOf('[');
        int numsEnd = input.indexOf(']');
        if (numsStart != -1 && numsEnd != -1 && numsEnd > numsStart) {
            String inside = input.substring(numsStart + 1, numsEnd).trim();
            if (!inside.isEmpty()) {
                String[] parts = inside.split(",");
                nums = new int[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    nums[i] = Integer.parseInt(parts[i].trim());
                }
            } else {
                nums = new int[0];
            }
        }

        int kIndex = input.indexOf("k =");
        if (kIndex != -1) {
            String kStr = input.substring(kIndex + 3).trim();
            k = Integer.parseInt(kStr);
        }

        Solution215 sol = new Solution215();
        int result = sol.findKthLargest(nums, k);

        return String.valueOf(result);
    }
}
