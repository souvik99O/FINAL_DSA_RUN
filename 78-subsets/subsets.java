class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
    ArrayList<List<Integer>> mainList = new ArrayList<>();  
    int n=nums.length;  
    int subset=1 << n ;
   

    for(int num=0; num<subset; num++)
    {
            ArrayList<Integer> localList = new ArrayList<>();
        
        for(int i=0; i<nums.length;i++)
        {
            int check=1<<i;
            int x=check & num;
            if(x !=0)
            {
                localList.add(nums[i]);
            }
        } 
    mainList.add(localList);
    

    }

    return mainList;





    }
}