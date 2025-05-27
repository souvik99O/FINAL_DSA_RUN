class Solution {
    public void sortColors(int[] nums) {
        int temp=0;
        int j=0;
        for(int i=1;i<nums.length;i++)
        {
            temp=nums[i];
             j=i-1;
            while(j>=0 && nums[j]>temp)
            {
                nums[j+1]=nums[j];
                j--;
            }
            nums[j+1]=temp;
        }

        
    }
}