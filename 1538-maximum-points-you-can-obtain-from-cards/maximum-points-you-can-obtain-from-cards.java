class Solution {
    public int maxScore(int[] nums, int k) {
        
        int sum=0;
        
        for(int i=0; i<k;i++)
        {
            sum+=nums[i];
        }
        int mainSum=sum;
        int l=0;
        int r=k-1;
        while(r!=nums.length-1)
        {
            

            sum-=nums[r];
            if(r==0)
            r=nums.length-1;
            else
            r--;

            if(l==0)
            {
                l=nums.length-1;
            }
            else
            {
                l--;
            }

            sum+=nums[l];


            if(sum>mainSum)
            {
                mainSum=sum;
            }
            

        }

        return mainSum;
        
    }
}