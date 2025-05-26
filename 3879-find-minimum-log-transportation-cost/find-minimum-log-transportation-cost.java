class Solution {
    public long minCuttingCost(int n, int m, int k) {
        long len1=0;
        long len2=0;
        long cost=0;
        if(n>k || m>k || (n>k && m>k))
        {
            if(n>k)
            {
                len1=n-k;
                len2=k;
                cost=len1*len2;
            }
            else 
            {
                len1=m-k;
                len2=k;
                cost=len1*len2;
            }
            
            return cost;
        }
        else
        return 0;
    }
}