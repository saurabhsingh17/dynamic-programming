package lcs;

public class SequencePatternMatching {
    public boolean isSubsequence(String s, String t) {
        char[] a = s.toCharArray();
        int m = a.length;
        char[] b = t.toCharArray();
        int n = b.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return m == dp[m][n];
    }
}
