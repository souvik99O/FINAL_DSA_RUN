class Solution {
    public int cherryPickup(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int dp[][][] = new int[rows][cols][cols];

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == j)
                    dp[rows - 1][i][j] = grid[rows - 1][j];

                else
                    dp[rows - 1][i][j] = grid[rows - 1][i] + grid[rows - 1][j];

            }
        }

        

        for (int i = rows - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < cols; j1++) {
                for (int j2 = 0; j2 < cols; j2++) {

                    int max=Integer.MIN_VALUE;

                    for (int dj1 = -1; dj1 < 2; dj1++) {
                        for (int dj2 = -1; dj2 < 2; dj2++) {

                            if (j1 + dj1 >=0 && j1 + dj1 <= cols - 1 && j2 + dj2 > 0 && j2 + dj2 <= cols - 1) {
                                int cherry = 0;
                                if (j1 == j2)
                                    cherry = grid[i][j1];
                                else
                                    cherry = grid[i][j1] + grid[i][j2];

                                cherry = cherry + dp[i + 1][j1 + dj1][j2 + dj2];

                                max = Math.max(max, cherry);
                            }
                        }
                    }
                    dp[i][j1][j2] = max;

                }
            }
        }

        return dp[0][0][cols - 1];

    }

}