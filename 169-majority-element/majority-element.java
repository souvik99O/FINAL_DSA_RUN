class Solution {
    public int majorityElement(int[] nums) {

       //brute force
       //hashing

       //morre's voting algo

      int i=0;
      int element=0;
      int count=0;
      for(i=0; i<nums.length;i++) 
      {
        if(count==0)
        {
            element=nums[i];
            count=1;
        }
        else if(nums[i]==element)
        {
            count++;
        }
        else{
            count--;
        }
      }

      return element;
      
    }
}