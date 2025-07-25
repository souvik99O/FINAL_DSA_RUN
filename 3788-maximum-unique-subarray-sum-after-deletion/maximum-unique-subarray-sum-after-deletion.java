class Solution {
    public int maxSum(int[] nums) {
        HashSet<Integer> set= new HashSet<>();
        int negCount=0;
        int max=Integer.MIN_VALUE;
        for(int i=0; i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                set.add(nums[i]);
            }

            if(nums[i]<0)
            negCount++;
            max=Math.max(max,nums[i]);
        }
        if(negCount==nums.length)
        return max;

        int ans=0;
        for(int val:set)
        {
            ans+=val;
        }

        return ans;
        
    }
}