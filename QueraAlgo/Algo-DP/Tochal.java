import java.util.*;

public class Tochal {
    static final int rem = 1000_000_007;
    static long[][] dp;
    static int n;
    static long[] h;

    static long setDp() {
        long res = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][i + 1] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                int r = i + j;
                dp[j][r] = dp[j][r - 1];

                if (h[j] == h[r - 1]) {
                    dp[j][r] += 1;
                    for (int k = j + 1; k <= r - 2; k++) {
                        if (h[k] >= h[j]) {
                            dp[j][r] += dp[k][r - 1];
                            dp[j][r] %= rem;
                        }
                    }
                }
            }
            res += dp[n - i + 1][n + 1];
            res %= rem;

        }

        return res;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        // 1 base
        dp = new long[n + 5][n + 5];
        h = new long[n + 5];
        for (int i = 1; i <= n; i++) {
            h[i] = scanner.nextInt();
        }


        System.out.println(setDp());
    }


}
