class Solution {
    public int missingNumber(int[] nums) {
        int n= nums.length;
        int returnVal=0;
        ArrayList<Integer> list= new ArrayList<>();

        for(int i:nums)
        {
            list.add(i);
        }

        for(int i =0; i<=n; i++)
        {
            if(!list.contains(i))
            {
                returnVal=i;
            }
        }

        return returnVal;
        
    }
}