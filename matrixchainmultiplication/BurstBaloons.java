package matrixchainmultiplication;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class BurstBaloons {
    static int matrixMultiplication(int N, int arr[]) {
        int[][] dp = new int[N + 1][N + 1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        return solve(arr, N, 1, N - 1, dp);
    }

    static int solve(int[] arr, int N, int i, int j, int[][] dp) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        int mn = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int tempAns = solve(arr, N, i, k, dp) + solve(arr, N, k + 1, j, dp) + arr[i - 1] * arr[i] * arr[i+1];
            if (tempAns < mn) {
                mn = tempAns;
            }
        }

        return dp[i][j] = mn;
    }

    public static void main(String[] args) {
//        Input: N = 5
//        arr = {40, 20, 30, 10, 30}
//        Output: 26000
        System.out.println(matrixMultiplication(5,new int[]{1,3,1,5,8,1}));
        String str = "ehllo";
        Set<String> stringSet = new TreeSet<>();
        stringSet.add("hllo");
        System.out.println(str.substring(1,5));
        System.out.println(stringSet.contains(str.substring(1,5)));
    }
}
