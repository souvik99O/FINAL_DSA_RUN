class Solution {
    public int longestOnes(int[] nums, int k) {

        int len=0; int maxlen=0;
        int l=0; int r=0;
        int zeroCount=0;
        while(r<nums.length)
        {

            // if(nums[r]==1)
            // {
                
            //     len=r-l+1;
            //     if(len>maxlen)
            //     maxlen=len;
            //     r++;

            // }

            if(r<nums.length && nums[r]==0)
            {
               zeroCount++;
               while(zeroCount>k)
               {
                
                if(nums[l]==0)
                zeroCount--;

                l++;
               }
            }

                len=r-l+1;
                if(len>maxlen)
                maxlen=len;
                r++; 
            
        }




        return maxlen;
        
    }
}