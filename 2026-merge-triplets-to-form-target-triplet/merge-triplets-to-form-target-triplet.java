class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean found1=false;
        boolean found2=false;
        boolean found3=false;
        for(int i=0; i<triplets.length;i++)
        {
         if (triplets[i][0] > target[0] || triplets[i][1] > target[1] || triplets[i][2] > target[2])
         {
           triplets[i][0]=0;
           triplets[i][1]=0;
           triplets[i][2]=0; 
         }
        if(target[0]==triplets[i][0])
        found1=true;
        if(target[1]==triplets[i][1])
        found2=true;
        if(target[2]==triplets[i][2])
        found3=true;

        }

        return found1&&found2&&found3;
        
    }
}