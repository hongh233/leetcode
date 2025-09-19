package repo.Queue.lc54;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {

        Queue<int[]> dirQue = new LinkedList<>();
        dirQue.add(new int[]{0, 1});
        dirQue.add(new int[]{1, 0});
        dirQue.add(new int[]{0, -1});
        dirQue.add(new int[]{-1, 0});

        int i = 0;
        int j = 0;
        List<Integer> result = new LinkedList<>();

        int row_len = matrix[0].length;
        int col_len = matrix.length;
        int total = row_len * col_len;
        int counter = 0;

        int[] d = dirQue.poll();
        dirQue.add(d);
        while (counter < total) {
            result.add(matrix[i][j]);
            matrix[i][j] = Integer.MIN_VALUE;
            counter++;

            int next_i = i + d[0];
            int next_j = j + d[1];
            if (next_i >= 0 && next_i < col_len &&
                    next_j >= 0 && next_j < row_len &&
                    matrix[next_i][next_j] != Integer.MIN_VALUE) {
                i = next_i;
                j = next_j;
            } else {
                d = dirQue.poll();
                dirQue.add(d);
                i = i + d[0];
                j = j + d[1];
            }
        }
        return result;
    }
}
