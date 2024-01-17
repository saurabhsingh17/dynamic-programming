package knapsack01;//{ Driver Code Starts

class SubsetSum {
    static boolean[][] dp = new boolean[101][10001];

    static Boolean isSubsetSum(int N, int arr[], int sum) {
        // code here
        for (int i = 0; i <= N; i++)
            dp[i][0] = true;

        // If sum is not 0 and set is empty,
        // then answer is false
        for (int i = 1; i <= sum; i++)
            dp[0][i] = false;

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[N][sum];
    }

    public static void main(String[] args) {

    }
}