class Solution {
    public boolean isPowerOfTwo(int n) {
        int count=0;
        while(n>0)
        {
            int bit=n&1;
            n=n>>1;
            if(bit==1)
            count++;
        }
        if(count==1){
        return true;
        }
        return false;
    }
}