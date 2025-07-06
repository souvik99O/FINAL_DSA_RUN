class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length; 
        int dp[][] = new int[m][n];

        // Initialize first row (instead of filling with -1)
        for(int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        // Fill DP table row by row (replace your nested loops)
        for(int i = 1; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int up = dp[i-1][j];
                int leftD = (j > 0) ? dp[i-1][j-1] : Integer.MAX_VALUE;
                int rightD = (j < n-1) ? dp[i-1][j+1] : Integer.MAX_VALUE;
                
                dp[i][j] = matrix[i][j] + Math.min(up, Math.min(leftD, rightD));
            }
        }

        // Find minimum in last row (keep your existing logic)
        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[m-1][j]);
        }

        return ans;
    }
    
    // Remove the solve method entirely - not needed for tabulation
}
