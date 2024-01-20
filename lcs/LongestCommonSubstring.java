package lcs;

public class LongestCommonSubstring {
    static int longestCommonSubstr(String S1, String S2, int n, int m) {
        // code here
        int[][] dp = new int[n + 1][m + 1];
        int max = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                    int currVal = 1 + dp[i - 1][j - 1];
                    max = Math.max(max, currVal);
                    dp[i][j] = currVal;
                } else dp[i][j] = 0;
            }

        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubstr("abc", "abcc", 3, 4));
    }
}
