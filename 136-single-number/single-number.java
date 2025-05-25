class Solution {
    public int singleNumber(int[] nums) {

// TC-> O(n) and SC-> O(n);/////////////////////////////////////////////////////
        
        // HashMap <Integer,Integer> map = new HashMap<>();

        // for(int i=0; i<nums.length;i++)
        // {
        //     map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        // }

        // System.out.println(map);

        // for(Map.Entry<Integer,Integer> e: map.entrySet())
        // {
        //     if(e.getValue()==1)
        //     return e.getKey();
        // }

        // return 0;

    // TC-> O(n) and SC-> O(n);/////////////////////////////////////////////////////


    // TC-> O(n) and SC-> O(1);////////////------------BIT 
    
    
   // 2 pointers-------------/////////////////////////////////////////

    int l=0; int r=0;
    Arrays.sort(nums);
    int count=0;
    while(r<nums.length)
    {
        if(nums[l]==nums[r]){
        count++;
        r++;
        }
        else
        {
        if(count==1)
        return nums[l];

         count =0;
         l=r;
            
        }

    }

    if(count==1)
    return nums[l];



    return 0;









    // TC-> O(n) and SC-> O(1);////////////------------BIT 
    
    
    
    
    //MANUPULATION-------------/////////////////////////////////////////





    
    
    
    //MANUPULATION-------------/////////////////////////////////////////










    // TC-> O(n) and SC-> O(1);////////////------------BIT MANUPULATION-------------/////////////////////////////////////////

        
    }
}