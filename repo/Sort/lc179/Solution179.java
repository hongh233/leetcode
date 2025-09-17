// quick sort

package repo.Sort.lc179;

public class Solution179 {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        quickSort(arr, 0, arr.length - 1);

        StringBuilder result = new StringBuilder();
        boolean firstIsZero = arr[0].equals("0");

        for (int i = 0; i < arr.length; i++) {
            if (firstIsZero && i != arr.length-1) {
                firstIsZero = arr[i+1].equals("0");
                continue;
            }
            result.append(arr[i]);
        }

        return result.toString();
    }

    private void quickSort(String[] arr, int left, int right) {
        if (left >= right) return;

        int i = left;
        int j = right;

        String pivot = arr[left];

        while (i <= j) {
            while (cmp(arr[i], pivot) > 0) i++;
            while (cmp(arr[j], pivot) < 0) j--;
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        if (left < j) quickSort(arr, left, j);
        if (i < right) quickSort(arr, i, right);
    }

    private int cmp(String s1, String s2) {
        return (s1 + s2).compareTo(s2 + s1);
    }


    private void swap(String[] sums, int i, int j) {
        String tmp = sums[i];
        sums[i] = sums[j];
        sums[j] = tmp;
    }

}