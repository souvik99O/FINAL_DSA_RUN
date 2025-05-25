class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        //Brute Force-----------------------------------------------------------------------------------------

        // int unique=0;
        // int count=0;
        // HashSet<Integer> set= new HashSet<>();
        // for(int i=0; i<nums.length;i++)
        // {
        //     set.clear();
        //     unique=0;
        //     for(int j=i; j<nums.length;j++)
        //     {
        //         if(!set.contains(nums[j]))
        //         {
        //             unique++;
        //             set.add(nums[j]);
        //         }
                
        //         if(unique==k)
        //         {
        //             count++;
        //         }


        //     }
        // }

        // return count;

        //Brute Force-----------------------------------------------------------------------------------------


        //BETTER APPROACH-----------------------------------------------------------------------------------------

        int ans= AtmostK(nums,k);
        int ans1=AtmostK(nums,k-1);
        
        return ans-ans1;

    }

    int AtmostK(int [] nums,int k)
    {
            HashMap<Integer,Integer> map = new HashMap<>();

            int l=0;
            int r=0;
            int count=0;
            int size=nums.length;

            while(r<size)
            {

            
             map.put(nums[r],map.getOrDefault(nums[r],0)+1);
                

                while(map.size()>k)
                {
                    if(map.containsKey(nums[l]))
                    {
                        map.put(nums[l],map.getOrDefault(nums[l],0)-1);
                        if(map.get(nums[l])==0)
                        map.remove(nums[l]);
                    }

                    l++;
                }

                if(map.size()<=k)
                count=count+((r-l)+1);

                r++;

            }
            return count;

    }
    //BETTER APPROACH-----------------------------------------------------------------------------------------


}