class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ps=0;
        int count=0;
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0; i<nums.length;i++)
        {
            ps+=nums[i];

            if(ps==goal)
            count++;

            if(map.containsKey(ps-goal))
            {
                count+=map.get(ps-goal);
            }

             map.put(ps,map.getOrDefault(ps,0)+1);
        }

        return count;

        
    }
}
