package knapsack01;

import java.util.Arrays;

public class Knapsack01Memoized {
    static int[][] dp =new int[1001][1001];

    static int Knapsack01(int[] wt, int[] val, int W, int n){

        if(n==0 || W == 0){
            return 0;
        }
        if( dp[n][W] != -1)
            return dp[n][W];

        if(wt[n-1] <= W){
            return dp[n][W]=Math.max(val[n-1] + Knapsack01(wt,val,W-wt[n-1],n-1),  Knapsack01(wt,val,W,n-1));
        }
        else{
            return dp[n][W]=Knapsack01(wt,val,W,n-1);
        }
    }
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n)
    {
        // your code here
        Arrays.stream(dp).forEach(row->Arrays.fill(row,-1));
        return Knapsack01(wt,val,W,n);
    }

    public static void main(String[] args) {
        // define W wt val and n and then call knapSack
    }
}