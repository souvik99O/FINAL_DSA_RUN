class Solution {
    public int search(int[] nums, int target) {
        int ans=binarySearch(0,nums.length-1,target,nums);
        return ans;
    }

    public int binarySearch(int low, int high, int target, int nums[])
    {
        if(high<low)
        return -1;

        int mid=(high+low)/2;
        if(target>nums[mid])
        return binarySearch(mid+1,high,target,nums);
        else if(target<nums[mid])
        return binarySearch(low,mid-1,target,nums);
        else
        return mid;

    }
}