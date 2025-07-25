class Solution {
    public void setZeroes(int[][] mat) {
        int col[] = new int[mat[0].length];
        int row[] = new int[mat.length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    if (row[i] != -1)
                        row[i] = -1;
                    if (col[j] != -1)
                        col[j] = -1;
                }
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (row[i] == -1 || col[j] == -1) {
                    mat[i][j] = 0;
                }
            }
        }

    }
}
