class Solution {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer,Integer> ps =new HashMap<>();

        int sum=0;
        int count=0;
        
        for(int i=0; i<nums.length;i++)
        {
            sum+=nums[i];
            
            if(sum==k)
            count++;

            if(ps.containsKey(sum-k))
            {
                count=count+ps.get(sum-k);
            }

            ps.put(sum,ps.getOrDefault(sum,0)+1);


        }

        return count;
        
    }
}