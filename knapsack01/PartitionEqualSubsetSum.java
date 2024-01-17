package knapsack01;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0)
            return false;
        else {
            boolean dp[][] = new boolean[202][(sum / 2) + 1];
            return subsetSum(nums, nums.length, sum / 2, dp);
        }
    }

    public static boolean subsetSum(int[] nums, int n, int k, boolean[][] dp) {
        for (int i = 0; i < k; i++) {
            dp[0][i] = false;
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                } else
                    dp[i][j] = dp[i - 1][j];
            }

        }
        return dp[n][k];
    }
}
