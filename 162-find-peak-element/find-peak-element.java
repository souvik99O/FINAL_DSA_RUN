class Solution {
    public int findPeakElement(int[] nums) {
        
        int low=0;
        int high=nums.length-1;
        if(nums.length==1)
        return 0;
        while(low<=high)
        {
            int mid=(high+low)/2;
            if(mid==0 && nums[mid+1]<nums[mid])// linearly decreasing case
            {
             return mid;
            }
            else if(mid==nums.length-1 && nums[mid]>nums[mid-1])//linearly increasing case
            {
                return mid;
            }
            else if(mid>0 && mid<nums.length-1 && nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1])//mid element is peak
            {
                return mid;
            }
            else if(nums[mid]<nums[low] && nums[mid]<nums[high])//joins of two peak
            {
                low=mid+1;
            }
            else if(mid>0 && nums[mid]>nums[high] && nums[mid-1]>nums[mid])//decreasing slope
            {
                high=mid-1;
            }
            else// increasing slope
            {
                low=mid+1;
            }
        }

        return -1;
    }
}