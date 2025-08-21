import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextInt();
        long[] dp = new long[10];
        for (int j = 1; j < 10; j++) {
            dp[j] = -1;
        }
        long i = 1;

        while (in.hasNextInt()) {
            long a = in.nextInt();
            long[] ndp = new long[10];

            for (int j = 0; j < 10; j++) {
                if (i >= j) {
                    long dp_skip = dp[j] + i;
                    if (dp[(j-1 + 10) % 10] == -1) {
                        ndp[j] = dp_skip;
                        continue;
                    }
                    long dp_kill = dp[(j-1 + 10) % 10] + a + a * j;
                    ndp[j] = Math.max(dp_skip, dp_kill);
                }
            }
            dp = ndp;
            i++;
        }

        long total = 0;
        for (int j = 0; j < 10; j++) {
            total = Math.max(total, dp[j]);
        }

        System.out.println(total);
    }

}