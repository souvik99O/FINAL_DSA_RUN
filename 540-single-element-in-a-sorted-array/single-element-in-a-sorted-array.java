class Solution {
    public int singleNonDuplicate(int[] nums) {

        int low=0;
        int high=nums.length-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(nums.length==1)
            return nums[mid];
            if(mid==nums.length-1 && nums[mid]!=nums[mid-1])
            return nums[mid];
            if(mid==0 && nums[mid+1]!=nums[mid])
            return nums[mid];

            if(nums[mid-1]!=nums[mid] && nums[mid+1]!=nums[mid])
            {
                return nums[mid];
            }
            else if(nums[mid-1]==nums[mid])
            {
                int len=(mid+low)+1;
                if(len%2!=0)
                {
                    high=mid;
                }
                else
                {
                    low=mid+1;
                }
            }
            else
            {
                int len=(high-mid)+1;
                if(len%2!=0)
                {
                    low=mid;
                }
                else
                {
                    high=mid-1;
                }
            }           
        }

        return -1;
        
    }
}