// hashmap solution, avg time: O(1), space: O(n)

package repo.Hash.lc348;

import java.util.HashMap;

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */

public class Solution348 {
    public static class TicTacToe {

        int size;
        int[][] diagonal; // row: p1 p2; col: pos neg
        HashMap<Integer, Integer> hashRowP1; // k: row idx; v: num
        HashMap<Integer, Integer> hashColP1; // k: col idx; v: num
        HashMap<Integer, Integer> hashRowP2; // k: row idx; v: num
        HashMap<Integer, Integer> hashColP2; // k: col idx; v: num

        public TicTacToe(int n) {
            this.size = n;
            this.diagonal = new int[2][2];
            this.hashRowP1 = new HashMap<>();
            this.hashColP1 = new HashMap<>();
            this.hashRowP2 = new HashMap<>();
            this.hashColP2 = new HashMap<>();
        }

        public int move(int row, int col, int player) {
            if (row == col) {
                diagonal[player - 1][0] += 1;
                if (diagonal[player - 1][0] == size) return player;
            }
            if (row + col == size - 1) {
                diagonal[player - 1][1] += 1;
                if (diagonal[player - 1][1] == size) return player;
            }

            if (player == 1) {
                hashRowP1.put(row, hashRowP1.getOrDefault(row, 0)+1);
                hashColP1.put(col, hashColP1.getOrDefault(col, 0)+1);
                if (hashRowP1.get(row) == size || hashColP1.get(col) == size) {
                    return player;
                }
            } else {
                hashRowP2.put(row, hashRowP2.getOrDefault(row, 0)+1);
                hashColP2.put(col, hashColP2.getOrDefault(col, 0)+1);
                if (hashRowP2.get(row) == size || hashColP2.get(col) == size) {
                    return player;
                }
            }

            return 0;
        }
    }
}
