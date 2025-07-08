class Solution {
    public boolean canPartition(int[] nums) {

        int totalSum = 0;

        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }
        if (totalSum % 2 != 0) return false;

        int dp[][] = new int[nums.length + 1][totalSum + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        boolean ans = solve(0, 0, totalSum, nums, dp);
        return ans;
    }

    public boolean solve(int ind, int p1sum, int totalSum, int nums[], int[][] dp) {
        int n = nums.length;
        if (ind >= n) {
            if (p1sum == (totalSum - p1sum))
                return true;
            return false;
        }

        if (dp[ind][p1sum] != -1) {
            if (dp[ind][p1sum] == 1)
                return true;
            return false;
        }

        boolean pick = solve(ind + 1, p1sum + nums[ind], totalSum, nums, dp);
        boolean notPick = solve(ind + 1, p1sum, totalSum, nums, dp);

        if (pick == true || notPick == true) {
            dp[ind][p1sum] = 1;
            return true;
        } else {
            dp[ind][p1sum] = 0;
        }
        return false;

    }
}