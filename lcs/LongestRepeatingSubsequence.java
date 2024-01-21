package lcs;

public class LongestRepeatingSubsequence {
    public int longestRepeatingSubsequence(String str) {
        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];
        char[] s1 = str.toCharArray();
        char[] s2 = str.toCharArray();
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s1[i - 1] == s2[j - 1] && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][n];
    }
}
