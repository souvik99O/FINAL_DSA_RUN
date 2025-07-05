
class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
         if (grid[0][0] == 1) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int dp[][] = new int[m][n];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        int ans = solve(0, 0, grid.length, grid[0].length, dp, grid);
        return ans;
    }

    public int solve(int row, int col, int m, int n, int dp[][], int[][] grid) {
        int down = 0;
        int right = 0;
        if (row >= m || col >= n)
            return 0;
        if (row == m - 1 && col == n - 1)
            return 1;

        if (dp[row][col] != -1)
            return dp[row][col];

        if (row != m - 1 && grid[row + 1][col] != 1)
            down = solve(row + 1, col, m, n, dp, grid);
        if (col != n - 1 && grid[row][col + 1] != 1)
            right = solve(row, col + 1, m, n, dp, grid);

        return dp[row][col] = down + right;
    }
}