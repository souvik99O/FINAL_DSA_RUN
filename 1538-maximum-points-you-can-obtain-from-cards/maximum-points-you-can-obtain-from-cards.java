class Solution {
    public int maxScore(int[] nums, int k) {
        
        int lSum=0;
        int rSum=0;
        for(int i=0; i<k;i++)
        {
            lSum+=nums[i];
        }
        int mainSum=lSum;
        int l=-1;
        int r=k-1;
        while(l==-1 || l>nums.length-k)
        {
            lSum-=nums[r];
            r--;
            if(l==-1)
            {
                l=nums.length-1;
            }
            else
            {
                l--;
            }

            rSum+=nums[l];


            if(lSum+rSum>mainSum)
            {
                mainSum=lSum+rSum;
            }
            

        }

        return mainSum;
        
    }
}