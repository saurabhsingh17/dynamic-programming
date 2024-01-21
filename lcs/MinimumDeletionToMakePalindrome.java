package lcs;

public class MinimumDeletionToMakePalindrome {
    static int lcs(String s, String s2) {
        int m = s.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

    //deletion => 1/size(palindromeString)
    int minDeletions(String str, int n) {
        return str.length() - lcs(str, new StringBuilder(str).reverse().toString());
    }
}
