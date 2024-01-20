package lcs;

public class ShortestCommonSupersequence {
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        //Your code here
        int[][] dp = new int[m+1][n+1];
        for( int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                if(X.charAt(i-1) == Y.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return m+n-dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(shortestCommonSupersequence("abccc","abcc",5,4));
    }
}
