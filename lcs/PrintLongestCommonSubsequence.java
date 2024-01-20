package lcs;

public class PrintLongestCommonSubsequence {
    public static String findLCSS(int n, int m, String s1, String s2){
        // Initialising 'dp' array.
        int [][]dp = new int[n + 1][m + 1];
        int i = n, j = m;
        StringBuilder lcs = new StringBuilder();
        calculateLCS(n, m, s1, s2, dp);

        // Moving through 'dp[i][j]', if s1[i]==s2[j], the current character is a part
        // of 'lcs', else we move to the cell from which dp[i][j] got it's value, i.e.
        // maximum of dp[i-1][j] and dp[i][j-1].
        while (i > 0 && j > 0)
        {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)){
                lcs.append(s1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1])
                    i--;
                else
                    j--;
            }
        }

        return lcs.reverse().toString();
    }

    // Function to calculate 'dp' array for LCS.
    public static void calculateLCS(int n, int m, String s1, String s2, int[][] dp) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = Math.max(1 + dp[i - 1][j - 1], dp[i][j]);
                }
            }
        }
    }
    public static String findLCS(int n, int m, String s1, String s2){
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<n+1;i++){
            for(int j = 1; j<m+1;j++){
                if(s1.charAt(i-1) == s2.charAt(i-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        int i = n;
        int j = m;
        StringBuilder resultReversed = new StringBuilder();
        while(i > 0 && j > 0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                resultReversed.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else{
                if( dp[i-1][j] < dp[i][j-1]){
                    j--;
                }
                else
                    i--;
            }
        }
        return resultReversed.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(findLCS(2,2,"ab","ac"));
    }
}
