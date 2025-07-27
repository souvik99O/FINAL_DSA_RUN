class Solution {
    public int countHillValley(int[] nums) {
        int count=0;
        for(int i=1; i<nums.length-1;i++)
        {
            int l=i-1;
            int r=i+1;
            if(nums[r]==nums[i])
            {
                while(r>nums.length && nums[r]==nums[i])
                {
                    r++;
                }

            }
            if(nums[l]==nums[i])
            {
                while(l>0 && nums[l]==nums[i])
                {
                    l--;
                }
            }


            if(nums[l]!=nums[i] && nums[r]!=nums[i])
            {
                if((nums[l]>nums[i] && nums[r]>nums[i])||(nums[l]<nums[i] && nums[r]<nums[i]))
                {
                    count++;
                }
            }
        }

        return count;
        
    }
}