class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0]; // Initialize to first element (handles all-negative case)
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Choose max between extending the subarray or starting fresh from current element
            sum = Math.max(nums[i], sum + nums[i]);
            max = Math.max(max, sum);
        }

        return max;
    }
}
