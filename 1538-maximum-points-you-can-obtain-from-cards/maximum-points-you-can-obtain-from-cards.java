class Solution {
    public int maxScore(int[] nums, int k) {
        
        int lSum=0;
        
        for(int i=0; i<k;i++)
        {
            lSum+=nums[i];
        }
        int mainSum=lSum;
        int l=0;
        int r=k-1;
        while(r!=nums.length-1)
        {
            

            lSum-=nums[r];
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

            lSum+=nums[l];


            if(lSum>mainSum)
            {
                mainSum=lSum;
            }
            

        }

        return mainSum;
        
    }
}