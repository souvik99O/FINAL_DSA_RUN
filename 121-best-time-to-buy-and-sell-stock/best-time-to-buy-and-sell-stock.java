class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int profit_main=0;
        int minPrice=Integer.MAX_VALUE;
       
        for(int i=0; i<prices.length; i++)
        {
            
            if(prices[i]<minPrice)
            minPrice=prices[i];
            
            profit=prices[i]-minPrice;
            if(profit_main<profit)
            {
                profit_main=profit;
            }
        }
        return profit_main;



       
    }
}