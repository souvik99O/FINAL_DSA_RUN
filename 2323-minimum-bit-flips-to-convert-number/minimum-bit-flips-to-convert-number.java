class Solution {
    public int minBitFlips(int start, int goal) {
    int res=start^goal;
    System.out.println(res);
    int ans=findNoOfBitsSet(res);
    return ans;
    }

    int findNoOfBitsSet(int n)
    {
        int count=0;
        while(n>1)
        {
            count += n & 1;
            n=n>>1;
        }
        if (n==1)
        count++;
    return count;
    }




}