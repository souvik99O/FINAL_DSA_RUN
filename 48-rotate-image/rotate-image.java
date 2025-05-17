class Solution {
    public void rotate(int[][] matrix) {
        int n= matrix.length;
  //--------------------------------------------------BRUTE FORCE USING ANOTHER MATRIX DUPLICATE------------------------------      
        // int dupmat[][]=new int [n][n];
        // for(int i=0; i<n; i++)
        // {
        //     for(int j=0; j<n; j++)
        //     {
        //         dupmat[i][j]=matrix[i][j];
        //     }
        // }

       

        // for(int i=0; i<n; i++)
        // {
        //     for(int j=0; j<n; j++)
        //     {
        //         matrix[i][j]=dupmat[n-j-1][i];
        //     }
        // }

    //---------------------optimal solution inplace------------------------

    //transpose the matrix

    for(int i=0; i<n; i++)
    {
        for(int j=i+1; j<n;j++)
        {
            int c= matrix[i][j];
            matrix[i][j]= matrix[j][i];
            matrix[j][i]=c;
        }
    }

    //reversing each row of the matrix

    for(int i=0; i<n; i++)
    {
        int start=0;
        int end=n-1;
        while(start<end)
        {
           
            int c= matrix[i][start];
            matrix[i][start]= matrix[i][end];
            matrix[i][end]=c;
            start++;
            end--;

        }
    }

    
    }
}
