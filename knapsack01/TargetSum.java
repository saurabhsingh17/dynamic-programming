package knapsack01;

import java.util.Arrays;

public class TargetSum {
    //exactly same as count subset with given difference
    //one more optimised solution
        public static int findTargetSumWays(int[] nums, int S) {
            int total = Arrays.stream(nums).sum();
            int[] dp = new int[2 * total + 1];
            dp[nums[0] + total] = 1;
            dp[-nums[0] + total] += 1;

            for (int i = 1; i < nums.length; i++) {
                int[] next = new int[2 * total + 1];
                for (int sum = -total; sum <= total; sum++) {
                    if (dp[sum + total] > 0) {
                        next[sum + nums[i] + total] += dp[sum + total];
                        next[sum - nums[i] + total] += dp[sum + total];
                    }
                }
                dp = next;
            }

            return Math.abs(S) > total ? 0 : dp[S + total];
        }

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1};
        int diff = 3;
        System.out.println(findTargetSumWays(arr,3));
    }
    }
