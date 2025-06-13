class Solution {
    public int trap(int[] height) {

       int prefixMax[]=new int[height.length];
       int suffixMax[]=new int[height.length];
       prefixMax[0]=height[0];
       suffixMax[height.length-1]=height[height.length-1];

       // Find tallest bar from left side up to each position
       for(int i=1; i<height.length;i++)
       {
        prefixMax[i]=Math.max(prefixMax[i-1],height[i]);
       }

        // Find tallest bar from right side up to each position
        for(int i=height.length-2; i>=0;i--)
       {
        suffixMax[i]=Math.max(suffixMax[i+1],height[i]);
       }

        // Water trapped = smaller wall - current bar height
        int total=0;
       for(int i=0; i<height.length;i++)
       {
        int leftWall=prefixMax[i];
        int rightWall=suffixMax[i];
        // Water fills up to the shorter wall
        total+=Math.min(leftWall,rightWall)-height[i];
       }

       return total;


    }
}

/*
Simple example: [3,0,2,0,4]

Prefix max (tallest from left): [3,3,3,3,4]
Suffix max (tallest from right): [4,4,4,4,4]

Water at each position:
Position 0: min(3,4)-3 = 0 (no water on edges)
Position 1: min(3,4)-0 = 3 (water trapped between walls 3 and 4)
Position 2: min(3,4)-2 = 1 (water trapped above bar of height 2)
Position 3: min(3,4)-0 = 3 (water trapped between walls 3 and 4)
Position 4: min(4,4)-4 = 0 (no water on edges)

Total = 7 units of water
*/
