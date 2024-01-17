package knapsack01;

import java.util.ArrayList;
import java.util.Arrays;
class MinimumSubsetSumDifference{

    int[][] dp  = new int[1001][1001];
    static int solve(int[] arr){
        int sum = Arrays.stream(arr).sum();
        //slight modification needed in return type of subsetSum function
        //boolean[][] dp = SubsetSum.isSubsetSum(arr.length, arr, sum/2);
        boolean[][] dp={{false,true}};
        int n = dp.length;
        int result = 0;
        for(int i = dp[n-1].length-1; i >=0;i--) {
            if (dp[n-1][i]) {
                result = sum - 2*i;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-36,36};
        System.out.println(solve(arr));
    }
}
