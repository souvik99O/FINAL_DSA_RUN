class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> biglist= new ArrayList<>();
        List<List<Integer>> anslist= new ArrayList<>();
        List<Integer> zero = new ArrayList<>();
        int count=0;

        for(int i=0; i<nums.length;i++)
        {
            if(nums[i]==0)
            count++;
        
            
        }

        if(count==nums.length){
            for(int i=0; i<3;i++)
        {
          zero.add(0);
        
            
        }
        anslist.add(zero);
        return anslist;
        }

        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
        {

             if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int tempval=0-nums[i];
            biglist=find2sum(nums,tempval,nums[i],i+1);

            if(biglist.size()!=0)
            {
                
                anslist.addAll(biglist);
            }
        }
        return anslist;
       
    }



   public List<List<Integer>> find2sum(int[] nums,int target,int firstval,int start) 
   { 
        List<List<Integer>> smalllist= new ArrayList<>();
        HashMap<Integer,Integer> map= new HashMap<>();

        for(int i=start; i<nums.length;i++)
        {
           
            
            List<Integer> tripple = new ArrayList<>();
            
            if(target==0)
            {
                     if(map.containsKey(-nums[i]))
                        {
                            tripple.add(firstval);
                            tripple.add(-nums[i]);
                            tripple.add(nums[i]);
                            smalllist.add(tripple);

                              while (i + 1 < nums.length && nums[i] == nums[i + 1])
                                {
                                    i++;
                                }
                        }
                        else
                        {
                            map.put(nums[i],i);
                        }


            }
            else
            {
                int findelement=target-nums[i];

                if(map.containsKey(findelement))
                {
                    tripple.add(firstval);
                    tripple.add(findelement);
                    tripple.add(nums[i]);
                    smalllist.add(tripple);
                    while (i + 1 < nums.length && nums[i] == nums[i + 1])
                                {
                                    i++;
                                }

                }
                
                else
                {
                    map.put(nums[i],i);
                }
            }

        }


return smalllist;

   }
}