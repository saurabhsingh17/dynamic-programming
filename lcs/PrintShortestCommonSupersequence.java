package lcs;

public class PrintShortestCommonSupersequence {
    static String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        int i = m;
        int j = n;
        StringBuilder sb = new StringBuilder();
        while (i > 0 && j > 0) {
            if (a[i - 1] == b[j - 1]) {
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i][j - 1] > dp[i - 1][j]) {
                    sb.append(str2.charAt(j - 1));
                    j--;
                } else {
                    sb.append(str1.charAt(i - 1));
                    i--;
                }
            }
        }
        while (i > 0) {
            sb.append(str1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            sb.append(str2.charAt(j - 1));
            j--;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "abab";
        String s2 = "cab";
        System.out.println(shortestCommonSupersequence(s1, s2));
    }
}
