class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int n=nums.length;
        HashMap<String,Integer> memo= new HashMap<>();
        int ans= solve(n-1,0,target,nums,memo);
        return ans;
    }
    public static int solve(int ind,int sum, int target,int [] nums,HashMap<String,Integer> memo)
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
        String key= ind+","+sum;
        if(memo.containsKey(key))
        return memo.get(key);

        int negative=solve(ind-1,sum-nums[ind],target,nums,memo);
        int positive=solve(ind-1,sum+nums[ind],target,nums,memo);
        memo.put(key,positive+negative);
        return positive+negative;

    }
}