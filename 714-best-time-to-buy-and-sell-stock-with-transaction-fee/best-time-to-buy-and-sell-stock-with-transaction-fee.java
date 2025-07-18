class Solution {
    public int maxProfit(int[] prices, int fee) {

    HashMap<String ,Integer> dp =new HashMap<>();
    int ans=solve(0,'B',prices,fee,dp);
    return ans;
        
    }
    public int solve(int i,char activity,int [] prices, int fee, HashMap<String ,Integer> dp)
    {
        String key=i+","+activity;
        int n=prices.length;
        //base case
        if(i>=n){
        dp.put(key,0);
        return 0;
        }
        if(dp.containsKey(key))
        {
            return dp.get(key);
        }
        
        if(activity=='B')
        {
           int buy= solve(i+1,'S',prices,fee,dp)-prices[i]-fee;
           int notBuy=solve(i+1,'B',prices,fee,dp);
           dp.put(key,Math.max(buy,notBuy));
           return Math.max(buy,notBuy);
        }
        if(activity=='S')
        {
            int sell=solve(i+1,'B',prices,fee,dp)+prices[i];
            int notSell=solve(i+1,'S',prices,fee,dp);
            dp.put(key,Math.max(sell,notSell));
            return Math.max(sell,notSell);
        }

        return 0;


    }
       
}