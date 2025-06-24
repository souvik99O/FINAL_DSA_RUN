class Solution {
    public int longestOnes(int[] nums, int k) {

     //other way of stating is that the sliding window can have a max of k zeroes

    int l=0; int r=0;
    int len=0;
    int zeroes=0;
        while(r<nums.length)
        {
            if(nums[r]==0)
            {
                zeroes++;
            }
            while(zeroes>k)
            {
                if(nums[l]==0)
                zeroes--;
                l++;
            }
            len=Math.max(len,r-l+1);
            r++;
        }
        return len;
    }
}