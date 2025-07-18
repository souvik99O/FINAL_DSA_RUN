class Solution {
    public int maxProfit(int[] prices) {

        int dp[][] = new int[prices.length+1][2];
        
        int n=prices.length;
        dp[n][0]=0;
        dp[n][1]=0;

        int buy=Integer.MIN_VALUE;
        int notBuy=Integer.MIN_VALUE;
        int notSell=Integer.MIN_VALUE;
        int sell=Integer.MIN_VALUE;


        for(int i=n-1; i>=0;i--)
        {
            for(int j=0; j<2;j++)
            {

                if(j==0){
                buy=dp[i+1][1]-prices[i];
                notBuy=dp[i+1][0];
                dp[i][j] = Math.max(buy, notBuy);
                }
                if(j==1){
                sell=dp[i+1][0]+prices[i];
                notSell=dp[i+1][1];
                dp[i][j] = Math.max(sell, notSell);
                }
            }
        }

        return dp[0][0];
    }
}

//MEMOIZATION--------------------------------------------------------------------------------------------------------------

//     public int solve(int i, char action,int [] prices,HashMap<String,Integer>  dp)
//     {
//         //base case
//         int n=prices.length;
//         String key=  i + "," +action;
//         if(i>=n){
//         dp.put(key,0);
//         return 0;
//         }

//         if(dp.containsKey(key))
//         return dp.get(key);

//         int buy=Integer.MIN_VALUE;
//         int notBuy=Integer.MIN_VALUE;
//         int notSell=Integer.MIN_VALUE;
//         int sell=Integer.MIN_VALUE;

//         if(action=='B'){
//         buy=solve( i+1 , 'S',prices,dp )-prices[i];
//         notBuy=solve(i+1 , 'B',prices,dp);
//         }
//         if(action=='S'){
//         sell=solve( i+1 , 'B',prices,dp)+prices[i];
//         notSell=solve( i+1, 'S',prices,dp);
//         }

//         int max1=Math.max(buy,notBuy);
//         int max2=Math.max(max1,sell);
//         int max3=Math.max(max2,notSell);

//         dp.put(key,max3);
//         return max3;
//     }
// }