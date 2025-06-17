class Solution {
    public boolean canJump(int[] nums) {
        int max=nums[0];
        int i=0;

        if(nums.length==1)
        {
            return true;
        }

        while(i<nums.length && i!=max+1)
        {
            if(nums[i]+i > max)
            max=nums[i]+i;

            if(max>=nums.length-1)
            return true;

            i++;
        }

       return false;
    }
}