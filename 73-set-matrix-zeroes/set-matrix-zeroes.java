class Solution {
    public void setZeroes(int[][] matrix) {
        int cols=matrix[0].length;
        int rows=matrix.length;
        int flagmat [][]= new int [rows][cols];
        int k=0;int c=0;
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                if(matrix[i][j]==0  && flagmat[i][j]!=-500)
                {                 
                    for(k=0; k<cols;k++)
                    {
                        if(matrix[i][k]!=0)
                        {
                        flagmat[i][k]=-500;
                        }
                        matrix[i][k]=0;    
                    }   
                    for(c=0; c<rows;c++)
                    {
                        if(matrix[c][j]!=0)
                        {
                        flagmat[c][j]=-500;
                        }
                        matrix[c][j]=0;
                    }   
                }

            }  
        }













    
        
    }
}