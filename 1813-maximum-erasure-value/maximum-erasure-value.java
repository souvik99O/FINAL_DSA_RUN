class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        int l=0;
        int r=0;
        HashMap<Integer,Integer> frequencyMap= new HashMap<>();
        int max=Integer.MIN_VALUE;
        int maxSum=0;

        while(r<nums.length)
        {
            
            frequencyMap.put(nums[r],frequencyMap.getOrDefault(nums[r],0)+1);
            while(frequencyMap.get(nums[r])>1)
            {
              frequencyMap.put(nums[l],frequencyMap.getOrDefault(nums[l],0)-1);
              maxSum=maxSum-nums[l];
              if(frequencyMap.get(nums[l])==0)
              frequencyMap.remove(nums[l]) ;
              l++; 
            }

            maxSum+=nums[r];
            max=Math.max(max,maxSum);
            r++;

        }

        return max;

    }
}