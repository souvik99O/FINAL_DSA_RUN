class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int n=nums.length;
        int ans= solve(n-1,0,target,nums);
        return ans;
    }
    public static int solve(int ind,int sum, int target,int [] nums)
    {
        if(ind==0)
        {
         int count=0; 

         if(sum+nums[ind]==target)
         count++;
         if(sum-nums[ind]==target)
         count++;

         return count;
         
        }

        int negative=solve(ind-1,sum-nums[ind],target,nums);
        int positive=solve(ind-1,sum+nums[ind],target,nums);

        return positive+negative;

    }
}