class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1; int max=Integer.MIN_VALUE;
        for(int i=0; i<nums.length;i++)
        {
            max=Math.max(max,nums[i]);
        }
        int high=max;
        int ans=1;
        while(low<=high)
        {
            int mid=(high+low)/2;
            if(validAns(mid,threshold,nums))
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


    public static boolean validAns(int divisor, int threshold,int nums[])
    {
        int sum=0;

        for(int i=0; i<nums.length;i++)
        {
            double temp=(nums[i]+divisor-1)/divisor;
            sum+=temp;
        }
        if(sum<=threshold)
        return true;
        else
        return false;
    }
}