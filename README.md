# Dynamic Programming
DP is optimised recursion.

**Identification:**
1. Identifications of recursion ie. choices and decisions.
2. Optimal value is asked. Keywords like maximum, minimum, optimal is used.

**Identification of Knapsack Problems:**
- choices is present
- wt[] is given
- val[] may be present
- W(capacity) is given

**Recursive Approach to Knapsack Problem**
```java
class Knapsack01Recursion
{
    static int knapsack01(int[] wt, int[] val, int W, int n){

        if(n==0 || W == 0){
            return 0;
        }
        if(wt[n-1] <= W){
            return Math.max(val[n-1] + knapsack01(wt,val,W-wt[n-1],n-1),  knapsack01(wt,val,W,n-1));
        }
        else{
            return knapsack01(wt,val,W,n-1);
        }
    }
}
```
**Memoized Recursive Approach to Knapsack Problem**
```java

public class Knapsack01Memoized {
    static int[][] dp = new int[1001][1001];

    static int Knapsack01(int[] wt, int[] val, int W, int n) {

        if (n == 0 || W == 0) {
            return 0;
        }
        if (dp[n][W] != -1)
            return dp[n][W];

        if (wt[n - 1] <= W) {
            return dp[n][W] = Math.max(val[n - 1] + Knapsack01(wt, val, W - wt[n - 1], n - 1), Knapsack01(wt, val, W, n - 1));
        } else {
            return dp[n][W] = Knapsack01(wt, val, W, n - 1);
        }
    }
}
    
```
**Top-Down Approach**
```java
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
```
**Variations of Knapsack:**
1. Subset Sum
2. Equal Sum Partition
3. Count of Subset sum
4. Minimum subset off
5. Target Sum
6. "#" of subset c given d/f 