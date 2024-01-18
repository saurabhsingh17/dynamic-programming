package unboundedknapsack;

public class RodCutting {
    public static int cutRod(int price[], int n) {
        //code here
        int[] arr = new int[n];
        for(int i = 0;i<n;i++)
            arr[i] = i+1;
        int[][]dp = new int[n+1][n+1];
        for(int i = 0;i<n+1;i++){
            dp[i][0]=0;
            dp[0][i]=0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(arr[i-1]<=j){
                    int a = price[i-1]+dp[i][j-arr[i-1]];
                    int b = dp[i-1][j] ;
                    dp[i][j] = (a > b ) ? a:b;
                }
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][n];
    }

    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(cutRod(price,8));
    }
}
