package knapsack01;

public class CountOfSubsetSumWithGivenSum {
    static int perfectSum(int arr[], int N, int sum) {
        int mod = (int) 1e9 + 7;
        int[][] dp = new int[N + 1][sum + 1];
        for (int i = 0; i < sum + 1; i++) {
            dp[0][i] = 0;
        }
        dp[0][0] = 1;

        // If sum is not 0 and set is empty,
        // then answer is false


        for (int i = 1; i < N + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = ((dp[i - 1][j - arr[i - 1]]) % mod + (dp[i - 1][j]) % mod) % mod;
                } else
                    dp[i][j] = (dp[i - 1][j]) % mod;
            }
        }
        return dp[N][sum];
    }

    public static void main(String[] args) {
        int N = 6;
        int[] arr = {5, 2, 3, 10, 6, 8};
        int sum = 10;
        System.out.println(perfectSum(arr,N,sum));
    }
}
