class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap <Integer,Integer> map = new HashMap<>();
        List<Integer> list=new ArrayList<>();

        for(int i=0; i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);

        }
        for( Map.Entry<Integer,Integer> e:map.entrySet())
        {
            int val=e.getValue();
            if(val>nums.length/3)
            list.add(e.getKey());
        }

        return list;
        
    }
}