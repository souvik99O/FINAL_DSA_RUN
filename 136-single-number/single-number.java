class Solution {
    public int singleNumber(int[] nums) {

        Arrays.sort(nums);
        HashMap <Integer,Integer> map = new HashMap<>();

        for(int i=0; i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        System.out.println(map);

        for(Map.Entry<Integer,Integer> e: map.entrySet())
        {
            if(e.getValue()==1)
            return e.getKey();
        }

        return 0;
        
    }
}