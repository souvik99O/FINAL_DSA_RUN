class Solution {
    HashMap<Integer,Integer> map= new  HashMap<>();
    public int countMaxOrSubsets(int[] nums) {
    
    List<Integer> list= new ArrayList<>();
    int maxXor=solve(0,list,nums,0);
    

    return map.get(maxXor);   
    }

    public int solve(int i, List<Integer> list,int[]nums,int maxXor)
    {
        int n=nums.length;
        if(i>=n)
        {
            int xor=0;
            for(int j=0; j<list.size();j++)
            {
              
              xor= xor | list.get(j);   
            }
            
            maxXor=Math.max(maxXor,xor);
            map.put(xor,map.getOrDefault(xor,0)+1);
            return maxXor;
        }

        list.add(nums[i]);
        int pick=solve(i+1,list,nums,maxXor);
        list.remove(list.size()-1);
        int notPick=solve(i+1,list,nums,maxXor);

        return Math.max(pick,notPick);

    }
}