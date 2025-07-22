class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max=0;
        int sum=0;
        for(int i=0; i<weights.length;i++)
        {
            max=Math.max(max,weights[i]);
            sum+=weights[i];
        }
        int low=max;
        int high=sum;
        int ans=0;

        while(low<=high)
        {
            int mid=(low+high)/2;
            if(validAns(mid,weights,days))
            {
                ans=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }

        return ans;
        
    }

    public static boolean validAns(int weight, int [] weights, int days)
    {
        int dayCount=1;
        int sum=0;
        for(int i=0; i<weights.length;i++)
        {
                sum=sum+weights[i];
                if(sum>weight)
                {
                    sum=weights[i];
                    dayCount++;
                }
        }
        if(dayCount<=days)
        return true;
        else
        return false;
    }
}