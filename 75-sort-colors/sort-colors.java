class Solution {
    public void sortColors(int[] nums) {
        int temp=0;
        for(int i=1;i<nums.length;i++)
        {
            temp=nums[i];
            for(int j=i-1;j>=0;j--)
            {
                
                if(temp<nums[j])
                {
                        nums[j+1]=nums[j];
                        nums[j]=temp;
                }
            }
        }

        
    }
}