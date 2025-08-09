class Solution {
    public int orangesRotting(int[][] grid) {
        int count=0;
        while (true) {
          boolean changed = false;  
            
            int rotten[][] = new int[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 2)
                        rotten[i][j] = 1;
                }
            }
            int n=rotten.length;
            int m=rotten[0].length;
            for (int i = 0; i < rotten.length; i++) {
                for (int j = 0; j < rotten[0].length; j++) {
                    if (rotten[i][j] == 1) {
                        
                        if(i!=n-1 && grid[i + 1][j] ==1){
                        grid[i + 1][j] = 2;
                        changed=true;
                        }
                        if(j!=m-1 && grid[i][j + 1]  ==1){
                        grid[i][j + 1] = 2;
                        changed=true;
                        }
                        if(i!=0 && grid[i-1][j] ==1){
                        grid[i-1][j]=2;
                        changed=true;
                        }
                        if(j!=0 && grid[i][j-1] ==1){
                        grid[i][j-1]=2;
                        changed=true;
                        }
                        
                    }
                }
            }
            count++;
            if(!changed)
            break;
        }
        for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1)
                        return -1;
                }
            }





    return count-1;
    }
}