class Solution {
    public int maxArea(int[] height) {
        int l=0;
        int r= height.length-1;
        int area=0;
        int max=0;

        while(l<r)
        {
            area=Math.min(height[l],height[r])*(r-l);
            max=Math.max(max,area);

            if(height[l]>height[r])
            {
                r--;
            }
            else
            {
                l++;
            }
            
        }
        return max;

        
    }
}