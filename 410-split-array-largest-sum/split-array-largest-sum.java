class Solution {
    public int splitArray(int[] nums, int k) {
        int tSum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++)
        {
            max=Math.max(max,nums[i]);
            tSum+=nums[i];
        }
        
        int high=tSum;
        int low=max;
        int ans=max;

       while(low<=high)
       {
        int mid=(high+low)/2;
        if(isValidAns(mid,k,nums))
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

    public boolean isValidAns(int mid,int k,int nums[])
    {
        System.out.println(mid);
        int sum=0;
        int count=1;
        for(int i=0; i<nums.length;i++)
        {
            sum+=nums[i];
            if(sum>mid)
            {
                sum=nums[i];
                count++;
            }
        }
          System.out.println(count);

        if(count<=k)
        return true;
        else
        return false;
    }
}