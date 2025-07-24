class Solution {
    public int jump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int dp[] = new int[nums.length + max];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = -1;
        }

        int ans = solve(0, nums, dp);

        return ans;
    }

    public int solve(int i, int nums[], int dp[]) {
        if (i >= nums.length - 1) {
            return dp[i] = 0;
        }

        if (dp[i] != -1)
            return dp[i];
        int options = 0;
        int min = 99999999;
        for (int j = 1; j <= nums[i]; j++) {
            options = 1 + solve(i + j, nums, dp);
            min = Math.min(min, options);
        }

        return dp[i] = min;

    }
}