package knapsack01;

public class Knapsack01TopDown {
    static int[][] dp = new int[1001][1001];

    static int knapSack(int W, int wt[], int val[], int n) {
        // your code here
        //Arrays.stream(dp).forEach(row->Arrays.fill(row,-1));
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else
                    dp[i][j] = -1;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][W];
    }
}
