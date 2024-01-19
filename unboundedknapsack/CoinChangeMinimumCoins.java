package unboundedknapsack;

public class CoinChangeMinimumCoins {
    //This problem is slightly unique than all other knapsack problems.
    // in this problem we assign 1 row also with i/coin[0] or MAX_VALUE-1
    // MAX-VALUE-1 because if we add 1 to MAX_VALUE it will go beyond the range of int and
    // negative values will come;
    //also in this problem we do min(1+dp[][],dp[][]) which is unique;

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] =new int[n+1][amount+1];
        //Arrays.stream(dp).forEach(row ->Arrays.fill(row,-1));
        for(int i = 0;i<amount+1;i++){
            dp[0][i] = Integer.MAX_VALUE-1;
        }
        for(int i = 1;i<n+1;i++){
            dp[i][0] = 0;
        }
        for(int i = 1;i<amount+1;i++){
            if(i%coins[0]==0)
                dp[1][i]=i/coins[0];
            else
                dp[1][i]=Integer.MAX_VALUE-1;
        }

        for(int i=2;i<n+1;i++){
            for(int j=1;j<amount+1;j++){
                if(coins[i-1]<=j){
                    dp[i][j] = Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
                }
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        if(dp[n][amount] == Integer.MAX_VALUE-1)
            return -1;
        else
            return dp[n][amount];
    }
}
