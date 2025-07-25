class Solution {
    public int maxSum(int[] nums) {
        HashSet<Integer> set= new HashSet<>();
        int negCount=0;
        int ans=0;
        int max=Integer.MIN_VALUE;
        for(int i=0; i<nums.length;i++)
        {
            // if(nums[i]>0)
            // {
            //     set.add(nums[i]);
            // }

            if (nums[i] > 0 && set.add(nums[i])) {
                ans += nums[i];  // Only add if it's a new positive number
            }

            if(nums[i]<0)
            negCount++;
            max=Math.max(max,nums[i]);
        }
        if(negCount==nums.length)
        return max;
        return ans;
        
    }
}