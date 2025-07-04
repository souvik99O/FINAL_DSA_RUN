class Solution {

    public int rob(int[] nums) {

        if(nums.length==1)
        return nums[0];

        int rightNums[] = new int[nums.length - 1];
        int leftNums[] = new int[nums.length - 1];
        int k = 0;

        for (int i = 1; i < nums.length; i++) {
            rightNums[k] = nums[i];
            k++;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            leftNums[i] = nums[i];
        }
        int dp1[] = new int[leftNums.length + 1];
        for (int i = 0; i < leftNums.length + 1; i++) {
            dp1[i] = -1;
        }

        int dp2[] = new int[rightNums.length + 1];
        for (int i = 0; i < rightNums.length + 1; i++) {
            dp2[i] = -1;
        }

        int maxRobRight = solve(0, rightNums, dp1);
        int maxRobLeft = solve(0, leftNums, dp2);

        return Math.max(maxRobRight, maxRobLeft);
    }

    int solve(int index, int nums[], int dp[]) {
        if (index >= nums.length) {
            return 0;
        }
        if (dp[index] != -1)
            return dp[index];

        int rob = nums[index] + solve(index + 2, nums, dp);
        int notrob = solve(index + 1, nums, dp);

        return dp[index] = Math.max(rob, notrob);
    }
}
