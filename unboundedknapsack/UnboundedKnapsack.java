package unboundedknapsack;

public class UnboundedKnapsack {

    //Unbounded Knapsack is similar to 0-1 Knapsack problem just that
    //we can pick same item any no of times.
    static int recursiveApproach(int n, int W, int[] val, int[] wt) {
        if (n == 0 || W == 0)
            return 0;
        if (wt[n - 1] <= W) {
            return Math.max(val[n - 1] + recursiveApproach(n, W - wt[n - 1], val, wt), recursiveApproach(n - 1, W, val, wt));
        } else
            return recursiveApproach(n - 1, W, val, wt);
    }

    static int recursiveMemoizedApproach(int n, int W, int[] val, int[] wt, int[][] dp) {
        if (n == 0 || W == 0)
            return 0;
        if (dp[n][W] != -1)
            return dp[n][W];
        if (wt[n - 1] <= W) {
            return dp[n][W] = Math.max(val[n - 1] + recursiveMemoizedApproach(n, W - wt[n - 1], val, wt, dp), recursiveMemoizedApproach(n - 1, W, val, wt, dp));
        } else
            return dp[n][W] = recursiveMemoizedApproach(n - 1, W, val, wt, dp);
    }

    static int topDownApproach(int n, int W, int[] val, int[] wt, int[][] dp) {
        for (int i = 0; i < W + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (wt[i - 1] <= j)
                    dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][W];


    }

    public static void main(String[] args) {
        int N = 1;
        int W = 2;
        int[] val = {};
        int[] wt = {};

        int[][] dp = new int[N + 1][W + 1];
        System.out.println(topDownApproach(N, W, val, wt, dp));
    }
}
