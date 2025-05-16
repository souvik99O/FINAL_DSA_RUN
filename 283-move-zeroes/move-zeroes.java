class Solution {
    public void moveZeroes(int[] nums) {
        int i=0;
        int j=0;
        int zeros=0;
        int n= nums.length;
        
        for(int m=0; m<nums.length;m++)
        {
            if(nums[m]==0)
            {
                zeros++;
            }
        }

    if(zeros>0){
        while(i<=(n-zeros))
        {
            if(nums[i]==0)
            {
                while(j<nums.length && nums[j]==0 )
                {
                    j++;

                }

                if(j<n){
                int c= nums[j];
                nums[j]= nums[i];
                nums[i]=c;
                }

                i++;
                j=i;
            }
            else
            {
                i++;
                j++;
            }
        }
    }
    
        
    }
}