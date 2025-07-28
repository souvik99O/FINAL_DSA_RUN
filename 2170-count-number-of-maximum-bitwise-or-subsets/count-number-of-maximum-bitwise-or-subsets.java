class Solution {
    HashMap<Integer,Integer> map= new  HashMap<>();
    int count=0;

    public int countMaxOrSubsets(int[] nums) {

    int maxXor=0;

    for(int i=0; i<nums.length;i++)
    {
       maxXor = maxXor | nums[i];
    }

    solve(0,0,nums,maxXor);
    
    //can i ooptimize this?
    //offcourse yes'''''''
    return count;   
    }

    public void solve(int i,int curOr,int[]nums,int maxXor)
    {
        int n=nums.length;
        if(i>=n)
        {
            if(curOr==maxXor)
            count++;
            return;
        } 
        solve(i+1,curOr | nums[i],nums,maxXor);
        solve(i+1,curOr,nums,maxXor);
    }
}