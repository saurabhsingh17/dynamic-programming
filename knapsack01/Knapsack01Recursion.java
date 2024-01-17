package knapsack01;

class Knapsack01Recursion
{
    static int Knapsack01(int[] wt, int[] val, int W, int n){

        if(n==0 || W == 0){
            return 0;
        }
        if(wt[n-1] <= W){
            return Math.max(val[n-1] + Knapsack01(wt,val,W-wt[n-1],n-1),  Knapsack01(wt,val,W,n-1));
        }
        else{
            return Knapsack01(wt,val,W,n-1);
        }
    }
    //Function to return max value that can be put in knapsack of capacity W.
    public static void main(String[] args) {
        int[] wt = {4,5,1};
        int[] val = {1,2,3};
        //no of elements
        int n = 3;
        //capacity
        int W = 4;
        System.out.println( Knapsack01(wt,val,W,n));
    }
}
