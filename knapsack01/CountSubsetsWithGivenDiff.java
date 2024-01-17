package knapsack01;

import java.util.Arrays;

class CountSubsetsWithGivenDiff {

    public static int countPartitions(int n, int d, int arr[]) {
        int sum = Arrays.stream(arr).sum();
        if ((sum + d) % 2 != 0)
            return 0;
        int s = (sum + d) / 2;

        int[][] dp = new int[n + 1][s + 1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        return CountOfSubsetSumWithGivenSum.perfectSum(arr, n, s);
    }

    public static void main(String[] args) {
        int[] arr = {2, 40, 6, 6, 43, 44, 10, 32, 12, 12, 26, 31, 48, 14, 38, 42, 25};
        System.out.println(countPartitions(17, 2, arr));
    }
}