class Solution {
    public void rotate(int[][] matrix) {
        int n= matrix.length;
        int dupmat[][]=new int [n][n];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                dupmat[i][j]=matrix[i][j];
            }
        }

       

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                matrix[i][j]=dupmat[n-j-1][i];
            }
        }


        
    }
}