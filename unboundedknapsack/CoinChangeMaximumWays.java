package unboundedknapsack;

public class CoinChangeMaximumWays {
    //solved on leetcode
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp =new int[n+1][amount+1];
        for(int i=1; i < amount+1; i++){
            dp[0][i] = 0;
        }
        for(int i=0; i < n+1; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < amount+1; j++){
                if(coins[i-1] <= j){
                    int n1 = dp[i][j-coins[i-1]];
                    int n2 = dp[i-1][j];
                    dp[i][j] =  n1+n2;
                }
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][amount];
    }
}
