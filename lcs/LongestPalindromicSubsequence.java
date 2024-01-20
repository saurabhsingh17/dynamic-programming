package lcs;

public class LongestPalindromicSubsequence {
    //Logic is pretty much simple
    // LPS(x) = LCS(x,reverse(x));
    static int longestPalindromeSubseq(String s) {
        String s2 = new StringBuilder(s).reverse().toString();
        return findLCS(s,s2);
    }
    static int findLCS(String s,String s2){
        int m = s.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                if(s.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("abc"));
    }
}
