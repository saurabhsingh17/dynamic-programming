package lcs;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LongestCommonSubsequence {
    static int recursiveApproach(String x, String y, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (x.charAt(m - 1) == y.charAt(n - 1)) {
            return 1 + recursiveApproach(x, y, m - 1, n - 1);
        } else
            return Math.max(recursiveApproach(x, y, m - 1, n), recursiveApproach(x, y, m, n - 1));
    }

    static int memoizedApproach(String x, String y, int m, int n, int[][] dp) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        if (x.charAt(m - 1) == y.charAt(n - 1)) {
            return dp[m][n] = 1 + memoizedApproach(x, y, m - 1, n - 1, dp);
        } else
            return dp[m][n] = Math.max(memoizedApproach(x, y, m - 1, n, dp), memoizedApproach(x, y, m, n - 1, dp));
    }

    static int topDownApproach1(String x, String y, int m, int n, int[][] dp) {
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

    public static int topDownApproach(String x, String y) {
        int m = x.length();
        int n = y.length();

        int[][] dp = new int[m + 1][n + 1];

        IntStream.rangeClosed(1, m).forEach(i ->
                IntStream.rangeClosed(1, n).forEach(j ->
                        dp[i][j] = x.charAt(i - 1) == y.charAt(j - 1) ? 1 + dp[i - 1][j - 1] : Math.max(dp[i - 1][j], dp[i][j - 1])
                )
        );

        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(recursiveApproach("abccdef", "abf", 7, 3));
        int[][] dp = new int[8][4];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        System.out.println(memoizedApproach("abccdef", "abf", 7, 3, dp));
        System.out.println(topDownApproach1("abccdef", "abf", 7, 3, new int[8][4]));
        System.out.println(topDownApproach("abccdef", "abf"));
    }
}
