class Solution {
    public void setZeroes(int[][] mat) {
       
        boolean FrowZ=true;
        boolean FcolZ=true;

        for(int i=0; i<mat.length;i++)
        {
            if(mat[i][0]==0)
            FcolZ=false;
        }

        for(int j=0; j<mat[0].length;j++)
        {
            if(mat[0][j]==0)
            FrowZ=false;
        }

        for(int i=1; i<mat.length;i++)
        {
            for(int j=1; j<mat[0].length;j++)
            {
                if(mat[i][j]==0)
                {
                    mat[0][j]=0;
                    mat[i][0]=0;
                }
            }
        }

        for(int i=1; i<mat.length;i++)
        {
            for(int j=1; j<mat[0].length;j++)
            {
                if(mat[i][0]==0 || mat[0][j]==0)
                {
                    mat[i][j]=0;
                }
            }
        }

        if(FrowZ==false)
        {
            for(int j=0; j<mat[0].length;j++)
            {
                mat[0][j]=0;
            
            }
        }
        if(FcolZ==false)
        {
            for(int i=0; i<mat.length;i++)
            {
                mat[i][0]=0;
              
            }  
        }
    }
}
